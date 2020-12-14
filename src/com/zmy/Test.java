package com.zmy;

/*import org.springframework.util.StringUtils;*/

import java.util.HashMap;
import java.util.Map;

public class Test {

    /**
     * 方法描述：将string-string的map集合转化为格式string:string,string:string的字符串
     * @author sxj 20170611
     * */
    public static String parseMapToString(Map<String,String> param){
        String str = "";
        if(param != null && param.size() > 0){
            for(Map.Entry<String,String> entry : param.entrySet()){
                str += entry.getKey()+":"+entry.getValue()+",";
            }
            str = str.substring(0, str.length()-1);
        }
        return str;
    }

    /**
     * 方法描述：将格式string:string,string:string的字符串转化为string-string的map集合
     * @author sxj 20170611
     * */
    public static Map<String,String> parseStringToMap(String str){
        Map<String,String> param = new HashMap<>(0);
       /* if(!StringUtils.isEmpty(str)){
            if(str.indexOf(",") != -1){
                String[] strs = str.split(",");
                for(String strItem : strs){
                    if(strItem.indexOf(":")>-1){
                        param.put(strItem.substring(0, strItem.indexOf(":")), strItem.substring(strItem.indexOf(":")+1));
                    }
                }
            }else{
                if(str.indexOf(":")>-1){
                    param.put(str.substring(0, str.indexOf(":")), str.substring(str.indexOf(":")+1));
                }
            }
        }*/
        return param;
    }

    public static void main(String[] args) {
        Map<String,String> map = new HashMap<String,String>();
        map.putIfAbsent("String","String");
        map.putIfAbsent("int","int");
        String result = Test.parseMapToString(map);
        System.out.println(result);
    }
}
