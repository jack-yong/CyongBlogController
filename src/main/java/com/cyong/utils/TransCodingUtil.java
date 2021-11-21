package com.cyong.utils;

import com.cyong.constant.StringConst;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * @BelongsProject: CyongBlogController
 * @BelongsPackage: com.cyong.utils
 * @Author: cyong
 * @CreateTime: 2021-11-21 18:46
 * @Description: 转码工具
 */
public class TransCodingUtil {
    /**
     * 中文转unicode编码
     * @param gbString 汉字
     * @return unicode编码
     */
    public static String stringToUnicode(final String gbString) {
        char[] utfBytes = gbString.toCharArray();
        String unicodeBytes = StringConst.BLANK;
        for (int i = 0; i < utfBytes.length; i++) {
            String hexB = Integer.toHexString(utfBytes[i]);
            if (hexB.length() <= 2) {
                hexB = "00" + hexB;
            }
            unicodeBytes = unicodeBytes + "\\u" + hexB;
        }
        return unicodeBytes;
    }

    /**
     * unicode编码转中文
     * @param unicode unicode编码
     * @return 中文
     */
    public static String unicodeToString(String unicode) {
        if(!unicode.contains("\\u")){
            return unicode;
        }

        StringBuffer string = new StringBuffer();
        String[] hex = unicode.split("\\\\u");

        for (int i = 1; i < hex.length; i++) {
            // 转换出每一个代码点
            int data = Integer.parseInt(hex[i], 16);
            // 追加成string
            string.append((char) data);
        }

        return string.toString();
    }

    /**
     * 将utf-8展开的16进制数转换成utf-8汉字
     * @param strUtf16
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String utf16ToUtf8(String strUtf16) throws UnsupportedEncodingException {
        String strUtf8 = URLDecoder.decode(strUtf16, "UTF-8");
        return strUtf8;
    }
    /**
     * 判断是否为汉字
     * @param str
     * @return
     */
    public static boolean isChinese(String str){
        for(int i=0;i<str.length();i++){
            int char1 = str.charAt(i);
            //汉字范围
            if(char1>=19968 && char1<=171941){
                return true;
            }
        }
        return false;
    }

}
