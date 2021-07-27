package algorithm.chapter4;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author YangShaw
 * @date 2021/4/8 16:50
 */
public class Ali {

    class Solver implements Callable {
        String[] titles;
        int left;
        int right;
        public Solver(String[] titles, int left, int right) {
            this.titles = titles;
            this.left = left;
            this.right = right;
        }

        @Override
        public Map<String, Integer> call() throws Exception {
            Map<String, Integer> wordToCount = new HashMap<>();
            for (int i = left; i <= right; i++) {
                // 读取文件
                String article = fileLoad(titles[i]);
                Map<String, Integer> map = splitArticle(titles[i]);
                mapSum(wordToCount, map);
            }
            return wordToCount;
        }

        private void mapSum(Map<String, Integer> allMap, Map<String, Integer> segMap) {
            segMap.forEach((k, v) -> {
                allMap.put(k, allMap.getOrDefault(k, 0) + v);
            });
        }

        private String fileLoad(String title) {
            File file = new File(title);
            StringBuilder sb = new StringBuilder();
            try {
                BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
                byte[] bytes = new byte[2048];
                while (in.read(bytes, 0, bytes.length) != -1) {
                    sb.append(new String(bytes));
                }
                in.close();
                return sb.toString();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        private Map<String, Integer> splitArticle(String article) {
            String[] words = article.split(" ");
            Map<String, Integer> map = new HashMap<>();
            for (String word : words) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
            return map;
        }
    }

    public void solution(String[] titles) throws InterruptedException, ExecutionException {
        FutureTask<Map<String, Integer>>[] tasks = new FutureTask[10];
        Thread[] threads = new Thread[10];
        int count = titles.length;
        int eachNum = titles.length / 10;
        for (int i = 0; i < 10; i++) {
            tasks[i] = new FutureTask<>(new Solver(titles, i * eachNum, (i+1) * eachNum));
            threads[i] = new Thread(tasks[i]);
        }
        for (int i = 0; i < 10; i++) {
            threads[i].start();
        }
        for (int i = 0; i < 10; i++) {
            threads[i].join();
        }
        Map<String, Integer> allMap = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            Map<String, Integer> map = tasks[i].get();
            mapSum(allMap, map);
        }
        allMap.forEach((k, v) -> {
            System.out.println(k + " " + v);
        });
    }

    public void mapSum(Map<String, Integer> allMap, Map<String, Integer> segMap) {
        segMap.forEach((k, v) -> {
            allMap.put(k, allMap.getOrDefault(k, 0) + v);
        });
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Ali ali = new Ali();
        String[] articles = new String[1000];
        ali.solution(articles);
    }

    public Map<String, Integer> splitArticle(String article) {
        String[] words = article.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        return map;
    }
}
