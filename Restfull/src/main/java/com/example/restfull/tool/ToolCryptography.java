package com.example.restfull.tool;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 创建时间:2019/9/9
 * 创建人:pmc
 * 描述:
 */
public class ToolCryptography
{
    /**
     * md5加密
     *
     * @param str 加密原文
     * @return 密文
     */
    public static String MD5(String str)
    {
        // 获取MD5实例
        MessageDigest md5 = null;
        try
        {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e)
        {
            System.out.println(e.toString());
            return "获取MD5实例异常";
        }
        // 将加密字符串转换为字符数组
        char[] charArray = str.toCharArray();
        byte[] byteArray = new byte[charArray.length];
        // 开始加密
        for (int i = 0; i < charArray.length; i++)
            byteArray[i] = (byte) charArray[i];
        byte[] digest = md5.digest(byteArray);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < digest.length; i++)
        {
            int var = digest[i] & 0xff;
            if (var < 16)
                sb.append("0");
            sb.append(Integer.toHexString(var));
        }
        return sb.toString();
    }

    /**
     * md5值校验
     *
     * @param str    原文
     * @param md5str MD5密文
     * @return bool
     */
    public static boolean MD5Verifier(String str, String md5str)
    {
        String mw = MD5(str);
        return mw.equals(md5str);
    }
}
