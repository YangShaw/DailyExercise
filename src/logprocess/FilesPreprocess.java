package logprocess;

import java.io.*;
import java.lang.reflect.Field;
import java.util.*;

public class FilesPreprocess {

    public static String[] fields = new String[]{
            "ts", "fuid", "tx_hosts", "rx_hosts", "conn_uids", "source",
            "depth", "analyzers", "mime_types", "filename", "duration", "local_orig",
            "is_orig", "seen_bytes", "total_bytes", "missing_bytes",
            "overflow_bytes", "timedout", "parent_fuid", "md5", "sha1",
            "sha256", "extracted", "extracted_cutoff", "extracted_size"
    };

    public static Map<String,String> getString(String line){
        System.out.println(fields.length);
        line = line.replaceAll(",", ";");
        Map<String,String> map=new HashMap<>();
        String[] values = line.split("\t");
        //for(String value: values){
        //    System.out.println(value);
        //}
        for(int i=0;i<values.length;++i){
            map.put(fields[i], values[i]);
        }
        return map;
    }

    public static List<Map<String,String>> readFile(String filePath){
        List<Map<String,String>> list=new LinkedList<>();
        try{
            String encoding= "UTF-8";
            File file=new File(filePath);
            int count=0;//定义顺序变量
            if(true){ // 判断文件是否存在
                InputStreamReader read=new InputStreamReader(
                        new FileInputStream(file),encoding);// 考虑到编码格式
                BufferedReader bufferedReader=new BufferedReader(read);
                String line;
                while((line=bufferedReader.readLine())!=null){//按行读取
                    if(!"".equals(line) && !line.startsWith("#")){
                        Map<String,String> map=getString(line);
                        list.add(map);
                    }
                }
                read.close();//关闭InputStreamReader
                bufferedReader.close();//关闭BufferedReader
            }else{
                System.out.println("找不到指定的文件");
            }
        }catch(Exception e){
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) throws IOException, IllegalAccessException {
        List<Map<String,String>> list=readFile("d:\\files.txt");
        List<Files> filesList = new LinkedList<>();

        for(Map<String, String> map: list){
            Files files = new Files();
            files.setTs(map.get("ts"));
            files.setFuid(map.get("fuid"));
            files.setTx_hosts(map.get("tx_hosts"));
            files.setRx_hosts(map.get("rx_hosts"));
            files.setConn_uids(map.get("conn_uids"));
            files.setSource(map.get("source"));
            files.setDepth(map.get("depth"));
            files.setAnalyzers(map.get("analyzers"));
            files.setMime_types(map.get("mime_types"));
            files.setFilename(map.get("filename"));
            files.setDuration(map.get("duration"));
            files.setLocal_orig(map.get("local_orig"));
            files.setIs_orig(map.get("is_orig"));
            files.setSeen_bytes(map.get("seen_bytes"));
            files.setTotal_bytes(map.get("total_bytes"));
            files.setMissing_bytes(map.get("missing_bytes"));
            files.setOverflow_bytes(map.get("overflow_bytes"));
            files.setTimedout(map.get("timedout"));
            files.setParent_fuid(map.get("parent_fuid"));
            files.setMd5(map.get("md5"));
            files.setSha1(map.get("sha1"));
            files.setSha256(map.get("sha256"));
            files.setExtracted(map.get("extracted"));
            files.setExtracted_cutoff(map.get("extracted_cutoff"));
            files.setExtracted_size(map.get("extracted_size"));
            filesList.add(files);
        }
        exportCsv(fields, fields, filesList);
    }

    public static <T> String exportCsv(String[] titles, String[] propertys, List<T> list) throws IOException, IllegalArgumentException, IllegalAccessException{
        File file = new File("d:\\files.csv");
        //构建输出流，同时指定编码
        OutputStreamWriter ow = new OutputStreamWriter(new FileOutputStream(file), "utf-8");

        //csv文件是逗号分隔，除第一个外，每次写入一个单元格数据后需要输入逗号
        for(String title : titles){
            ow.write(title);
            ow.write(",");
        }
        //写完文件头后换行
        ow.write("\r\n");
        //写内容
        for(Object obj : list){
            //利用反射获取所有字段
            Field[] fields = obj.getClass().getDeclaredFields();
            for(String property : propertys){
                for(Field field : fields){
                    //设置字段可见性
                    field.setAccessible(true);
                    if(property.equals(field.getName())){
                        ow.write(field.get(obj).toString());
                        ow.write(",");
                        continue;
                    }
                }
            }
            //写完一行换行
            ow.write("\r\n");
        }
        ow.flush();
        ow.close();
        return "0";
    }
}
