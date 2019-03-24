package com.xf.mvcp.utils;

/**
 * 字符串工具类
 */
public class StringUtils {
    /**
     * 判断字符串是否为空
     * @param arg
     * @return
     */
    public static boolean isEmpty(String arg){
        if(arg != null && !arg.equals("")){
            return false;
        }

        return true;
    }

    /**
     * 去除输入的非法字符，防止sql注入风险
     * @param str
     * @return
     */
    public static String removeIllegalChar(String str) {
        String str2 = str.toLowerCase();//统一转为小写
        String[] SqlStr1 = {"and","exec","execute","insert","select","delete","update","count","drop","chr","mid","master","truncate","char","declare","sitename","net user","xp_cmdshell","like","and","exec","execute","insert","create","drop","table","from","grant","use","group_concat","column_name","information_schema.columns","table_schema","union","where","select","delete","update","order","by","count","chr","mid","master","truncate","char","declare","or"};//词语
        String[] SqlStr2 = {"\\*","'",";","or","-","--","\\+","//","/","%","#", "=", ":", "\\?"};//特殊字符

        for (int i = 0; i < SqlStr1.length; i++) {
            if (str2.indexOf(SqlStr1[i])>=0) {
                str = str.replaceAll("(?i)"+SqlStr1[i],"");//正则替换词语，无视大小写
            }
        }
        for (int i = 0; i < SqlStr2.length; i++) {
            if (str2.indexOf(SqlStr2[i]) >= 0) {
                str = str.replaceAll(SqlStr2[i],"");
            }
        }

        return str;

    }
}
