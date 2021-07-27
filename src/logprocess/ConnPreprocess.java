//package logprocess;
//
//import org.junit.Test;
//
//import java.io.*;
//import java.util.HashMap;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Map;
//import java.lang.reflect.Field;
//
//public class ConnPreprocess {
//
//    String type[] =new String[]{"ts","uid","id.orig_h","id.orig_p","id.resp_h","id.resp_p","proto","service","duration","orig_bytes","resp_bytes","conn_state","local_orig","local_resp","missed_bytes","history","orig_pkts","orig_ip_bytes","resp_pkts","resp_ip_bytes","tunnel_parents"};
//    public Map<String,Object> getString(String lineTxt ){
//        Map<String,Object> map=new HashMap<>();
//        int left=0,right=0,count=0;
//        for(int i=0;i<lineTxt.length();i++){
//            if(lineTxt.charAt(i)=='\t'){
//                right=i;
//                System.out.println(lineTxt.substring(left+1,right));
//                map.put(type[count++],lineTxt.substring(left,right));
//                left=right;
//            }
//        }
//        return map;
//    }
//
//
//    public List<Map<String,Object>> getDate(String filePath){
//        List<Map<String,Object>> list=new LinkedList<>();
//        try{
//            String encoding= "UTF-8";
//            File file=new File(filePath);
//            int count=0;//定义顺序变量
//            if(file.isFile()&&file.exists()){ // 判断文件是否存在
//                InputStreamReader read=new InputStreamReader(
//                        new FileInputStream(file),encoding);// 考虑到编码格式
//                BufferedReader bufferedReader=new BufferedReader(read);
//                String lineTxt=null;
//                while((lineTxt=bufferedReader.readLine())!=null){//按行读取
//                    if(!"".equals(lineTxt)){
//                        Map<String,Object> map=getString(lineTxt);
//                        list.add(map);
////                        System.out.println(lineTxt);
//                    }
//                }
//                read.close();//关闭InputStreamReader
//                bufferedReader.close();//关闭BufferedReader
//            }else{
//                System.out.println("找不到指定的文件");
//            }
//        }catch(Exception e){
//            System.out.println("读取文件内容出错");
//            e.printStackTrace();
//        }
//        return list;
//    }
//    @Test
//    public void testGetString() throws IOException, IllegalAccessException {
//        List<Map<String,Object>> list=getDate("/Users/youyuhan/Desktop/NewDataAnPro/src/http.txt");
//        List<Conn> listUser=new LinkedList<>();
//        for(int i=0;i<list.size();i++){
//            Map<String,Object> map= list.get(i);
//            System.out.println(map);
//            Conn conn =new Conn(map.getOrDefault("ts","").toString(),map.getOrDefault("uid","").toString(),map.getOrDefault("id.orig_h","").toString(),map.getOrDefault("id.orig_p","")
//                    .toString(),map.getOrDefault("id.resp_h","").toString(),map.getOrDefault("id.resp_p","").toString(),map.getOrDefault("proto","").toString(),map.getOrDefault("service","").toString(),map.getOrDefault("duration","").toString(),
//                    map.getOrDefault("orig_bytes","").toString(),map.getOrDefault("resp_bytes","").toString(),map.getOrDefault("conn_state","").toString(),map.getOrDefault("local_orig","").toString(),map.getOrDefault("local_resp","").toString(),map.getOrDefault("missed_bytes","").toString(),map.getOrDefault("history","").toString()
//                    ,map.getOrDefault("orig_pkts","").toString(),map.getOrDefault("orig_ip_bytes","").toString(),map.getOrDefault("resp_pkts","").toString(),map.getOrDefault("resp_ip_bytes","").toString(),map.getOrDefault("tunnel_parents","").toString());
//            listUser.add(conn);
//        }
//        String[] propertys = new String[]{"ts","uid","id_orig_h","id_orig_p","id_resp_h","id_resp_p","proto","service","duration","orig_bytes","resp_bytes","conn_state","local_orig","local_resp","missed_bytes","orig_pkts","orig_ip_bytes","resp_pkts","resp_ip_bytes","tunnel_parents"};
//        String[] titles = new String[]{"ts","uid","id_orig_h","id_orig_p","id_resp_h","id_resp_p","proto","service","duration","orig_bytes","resp_bytes","conn_state","local_orig","local_resp","missed_bytes","orig_pkts","orig_ip_bytes","resp_pkts","resp_ip_bytes","tunnel_parents"};
//
//        exportCsv(titles,propertys, listUser);
//    }
//
//    public static <T> String exportCsv(String[] titles, String[] propertys, List<T> list) throws IOException, IllegalArgumentException, IllegalAccessException{
//        File file = new File("dns.csv");
//        //构建输出流，同时指定编码
//        OutputStreamWriter ow = new OutputStreamWriter(new FileOutputStream(file), "gbk");
//
//        //csv文件是逗号分隔，除第一个外，每次写入一个单元格数据后需要输入逗号
//        for(String title : titles){
//            ow.write(title);
//            ow.write(",");
//        }
//        //写完文件头后换行
//        ow.write("\r\n");
//        //写内容
//        for(Object obj : list){
//            //利用反射获取所有字段
//            Field[] fields = obj.getClass().getDeclaredFields();
//            for(String property : propertys){
//                for(Field field : fields){
//                    //设置字段可见性
//                    field.setAccessible(true);
//                    if(property.equals(field.getName())){
//                        ow.write(field.get(obj).toString());
//                        ow.write(",");
//                        continue;
//                    }
//                }
//            }
//            //写完一行换行
//            ow.write("\r\n");
//        }
//        ow.flush();
//        ow.close();
//        return "0";
//    }
//
//}
