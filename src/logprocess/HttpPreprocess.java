package logprocess;

import java.io.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class HttpPreprocess {

    public static String[] fields = new String[]{
            "ts", "uid", "id_orig_h", "id_orig_p", "id_resp_h", "id_resp_p",
            "trans_depth", "method", "host", "uri", "referrer", "version",
            "user_agent", "origin", "request_body_len", "response_body_len",
            "status_code", "status_msg", "info_code", "info_msg", "tags",
            "username", "password", "proxied", "orig_fuids", "orig_filenames",
            "orig_mime_types", "resp_fuids", "resp_filenames", "resp_mime_types"
    };

    public static Map<String,String> getString(String line){
        System.out.println(fields.length);
        Map<String,String> map=new HashMap<>();
        //String[] values = line.split("\\s+");
        String[] values = line.split("\t");
        //System.out.println(values.length);
        for(String value: values){
            System.out.println(value);
        }
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
        String rootPath = "E:\\EclipseWorkSpace\\DailyExercise\\src\\logprocess\\http2020\\";
        for(int i=1; i<=13; ++i){
            List<Map<String, String>> list = readFile(rootPath+i+".log");
            List<HTTP> HTTPList =new LinkedList<>();

            for(Map<String, String> map: list){
                HTTP http = new HTTP();
                http.setTs(map.get("ts"));
                http.setUid(map.get("uid"));
                http.setId_orig_h(map.get("id_orig_h"));
                http.setId_orig_p(map.get("id_orig_p"));
                http.setId_resp_h(map.get("id_resp_h"));
                http.setId_resp_p(map.get("id_resp_p"));
                http.setTrans_depth(map.get("trans_depth"));
                http.setMethod(map.get("method"));
                http.setHost(map.get("host"));
                http.setUri(map.get("uri"));
                http.setReferrer(map.get("referrer"));
                http.setVersion(map.get("version"));
                http.setUser_agent(map.get("user_agent"));
                http.setOrigin(map.get("origin"));
                http.setRequest_body_len(map.get("request_body_len"));
                http.setResponse_body_len(map.get("response_body_len"));
                http.setStatus_code(map.get("status_code"));
                http.setStatus_msg(map.get("status_msg"));
                http.setInfo_code(map.get("info_code"));
                http.setInfo_msg(map.get("info_msg"));
                http.setTags(map.get("tags"));
                http.setUsername(map.get("username"));
                http.setPassword(map.get("password"));
                http.setProxied(map.get("proxied"));
                http.setOrig_fuids(map.get("orig_fuids"));
                http.setOrig_filenames(map.get("orig_filenames"));
                http.setOrig_mime_types(map.get("orig_mime_types"));
                http.setResp_fuids(map.get("resp_fuids"));
                http.setResp_filenames(map.get("resp_filenames"));
                http.setResp_mime_types(map.get("resp_mime_types"));
                HTTPList.add(http);
            }
            exportCsv(fields, fields, HTTPList);
        }

    }

    public static <T> String exportCsv(String[] titles, String[] propertys, List<T> list) throws IOException, IllegalArgumentException, IllegalAccessException{
        File file = new File("E:\\EclipseWorkSpace\\DailyExercise\\src\\logprocess\\http2020\\http2020.csv");
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
