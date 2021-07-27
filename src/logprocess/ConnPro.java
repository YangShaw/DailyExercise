package logprocess;

import java.io.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ConnPro {


    //public static String[] fields = new String[]{
    //        "ts", "uid", "id_orig_h", "id_orig_p", "id_resp_h", "id_resp_p",
    //        "trans_depth", "method", "host", "uri", "referrer", "version",
    //        "user_agent", "origin", "request_body_len", "response_body_len",
    //        "status_code", "status_msg", "info_code", "info_msg", "tags",
    //        "username", "password", "proxied", "orig_fuids", "orig_filenames",
    //        "orig_mime_types", "resp_fuids", "resp_filenames", "resp_mime_types"
    //};

    public static String fields[] =new String[]{
            "ts","uid","id_orig_h","id_orig_p","id_resp_h",
            "id_resp_p","proto","service","duration","orig_bytes",
            "resp_bytes","conn_state","local_orig","local_resp",
            "missed_bytes","history","orig_pkts","orig_ip_bytes",
            "resp_pkts","resp_ip_bytes","tunnel_parents"
    };


    public static Map<String,String> getString(String line){
        System.out.println(fields.length);
        Map<String,String> map=new HashMap<>();
        //String[] values = line.split("\\s+");
        String[] values = line.split("\t");
        //System.out.println(values.length);
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
        String rootPath = "E:\\EclipseWorkSpace\\DailyExercise\\src\\logprocess\\conn202006\\";
        for(int i=1; i<=10; ++i){
            List<Map<String, String>> list = readFile(rootPath+i+".log");
            List<Conn> connList =new LinkedList<>();

            for(Map<String, String> map: list){
                Conn conn =new Conn(map.getOrDefault("ts","").toString(),map.getOrDefault("uid","").toString(),map.getOrDefault("id.orig_h","").toString(),map.getOrDefault("id.orig_p","")
                    .toString(),map.getOrDefault("id.resp_h","").toString(),map.getOrDefault("id.resp_p","").toString(),map.getOrDefault("proto","").toString(),map.getOrDefault("service","").toString(),map.getOrDefault("duration","").toString(),
                    map.getOrDefault("orig_bytes","").toString(),map.getOrDefault("resp_bytes","").toString(),map.getOrDefault("conn_state","").toString(),map.getOrDefault("local_orig","").toString(),map.getOrDefault("local_resp","").toString(),map.getOrDefault("missed_bytes","").toString(),map.getOrDefault("history","").toString()
                    ,map.getOrDefault("orig_pkts","").toString(),map.getOrDefault("orig_ip_bytes","").toString(),map.getOrDefault("resp_pkts","").toString(),map.getOrDefault("resp_ip_bytes","").toString(),map.getOrDefault("tunnel_parents","").toString());


                connList.add(conn);
            }
            exportCsv(fields, fields, connList);
        }

    }

    public static <T> String exportCsv(String[] titles, String[] propertys, List<T> list) throws IOException, IllegalArgumentException, IllegalAccessException{
        File file = new File("E:\\EclipseWorkSpace\\DailyExercise\\src\\logprocess\\conn2020\\conn202006.csv");
        //构建输出流，同时指定编码
        OutputStreamWriter ow = new OutputStreamWriter(new FileOutputStream(file, true), "utf-8");

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
