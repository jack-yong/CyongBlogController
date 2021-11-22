package com.cyong.utils;

/**
 * @BelongsProject: CyongBlogController
 * @BelongsPackage: com.cyong.utils
 * @Author: cyong
 * @CreateTime: 2021-11-22 10:15
 * @Description: 字符串和数组之间进行转换
 */
public class StringAndArray {

    /**
     * 字符串转换成字符串数组
     * @param str 字符串
     * @return 转换后的字符串数组
     */
    public static String[] stringToArray(String str){
        String[] array = str.split(",");
        for(int i=0;i<array.length;i++){
            array[i] = array[i].trim();
        }
        return array;
    }

    /**
     * 字符串数组拼接成字符串
     * @param articleTags 字符串数组
     * @return 拼接后的字符串
     */
    public static String arrayToString(String[] articleTags){
        StringBuilder sb = new StringBuilder();
        for(String s : articleTags){
            if(sb.length() == 0){
                sb.append(s.trim());
            } else {
                sb.append(",").append(s.trim());
            }
        }
        return sb.toString();
    }
}
