package week207;

import java.util.*;
public class Problem1 {

    public static void main(String[] args) {
        String text = "  this   is  a sentence ";
        System.out.println(reorderSpaces(text));
    }
    public static String reorderSpaces(String text) {
        int count = 0;
        List<String> words = new ArrayList<>();
        int i=0;
        int length = text.length();
        while(i<length){
            if(text.charAt(i)==' '){
                count++;
                i++;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(text.charAt(i));
                i++;
                while(i<length && text.charAt(i)!=' '){
                    sb.append(text.charAt(i));
                    i++;
                }
                words.add(sb.toString());
            }
        }
        int wordCount = words.size();
        int each=0, last=0;
        if(wordCount==1){
            last=count;
        } else {
            each = count/(wordCount-1);
            last = count%(wordCount-1);
        }
        System.out.println(each);
        System.out.println(last);
        StringBuilder result = new StringBuilder();
        result.append(words.get(0));
        words.remove(0);
        for (String word: words){
            for(int j=0;j<each;++j){
                result.append(" ");
            }
            result.append(word);

        }
        for(int k=0;k<last;++k){
            result.append(" ");
        }
        return result.toString();

    }
}
