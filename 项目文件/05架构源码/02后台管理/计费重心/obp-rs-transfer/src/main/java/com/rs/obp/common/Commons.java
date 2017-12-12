/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rs.obp.common;

import com.rs.obp.entity.dto.MsgHeader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Date;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author wangxinming
 */
public class Commons {
    
    public static int getMessageCode(byte[] msg) {
        byte[] code = ArrayUtils.subarray(msg, 28, 32);
        return bytesToInt(code);
    }

    /*低位在前 , 高位在后 -逆序*/
    public static int bytesToInt(byte[] bytes) {
        int addr = bytes[0] & 0xFF;
        addr |= ((bytes[1] << 8) & 0xFF00);
        addr |= ((bytes[2] << 16) & 0xFF0000);
        addr |= ((bytes[3] << 24) & 0xFF000000);
        return addr;
    }
    
    public static byte[] intToByte(int n) {
        byte[] b = new byte[4];
        b[0] = (byte) (n & 0xff);
        b[1] = (byte) (n >> 8 & 0xff);
        b[2] = (byte) (n >> 16 & 0xff);
        b[3] = (byte) (n >> 24 & 0xff);
        return b;
    }

    /*由int型转换成带type类型的byte数组, 类似new byte[]{2, 1, 0, 0, 0}*/
    public static byte[] intToByteWithType(int n) {
        return ArrayUtils.add(Commons.intToByte(n), 0, Constants.TYPE_INT);
    }

    /*由double型转换成带type类型的byte数组, 类似new byte[]{2, 1, 0, 0, 0, 1, 0, 0, 0}*/
    public static byte[] doubleToByteWithType(double d) {
        return ArrayUtils.add(Commons.doubleToByte(d), 0, Constants.TYPE_DOUBLE);
    }

    /*由String型转换成带type类型并有结束符的byte数组, 类似new byte[]{4, 83, 75, 89, 95, 83, 69, 82, 86, 69, 82, 0}*/
    public static byte[] stringToByteWithType(String s) {
        if (StringUtils.isEmpty(s)) {
            return ArrayUtils.addAll(new byte[]{Constants.TYPE_STRING}, Constants.TYPE_STRING_END);
        }
        return ArrayUtils.addAll(ArrayUtils.add(s.getBytes(), 0, Constants.TYPE_STRING), Constants.TYPE_STRING_END);
    }

    //浮点到字节转换  
    public static byte[] doubleToByte(double d) {
        byte[] b = new byte[8];
        long l = Double.doubleToLongBits(d);
        for (int i = 0; i < b.length; i++) {
            b[i] = new Long(l).byteValue();
            l = l >> 8;
            
        }
        //解决大小端问题
        ArrayUtils.reverse(b);
        return b;
    }

    //字节到浮点转换  
    public static double byteToDouble(byte[] b) {
        //解决大小端问题
        ArrayUtils.reverse(b);
        long m;
        m = b[0];
        m &= 0xff;
        m |= ((long) b[1] << 8);
        m &= 0xffff;
        m |= ((long) b[2] << 16);
        m &= 0xffffff;
        m |= ((long) b[3] << 24);
        m &= 0xffffffffl;
        m |= ((long) b[4] << 32);
        m &= 0xffffffffffl;
        m |= ((long) b[5] << 40);
        m &= 0xffffffffffffl;
        m |= ((long) b[6] << 48);
        m &= 0xffffffffffffffl;
        m |= ((long) b[7] << 56);
        return Double.longBitsToDouble(m);
    }

    /*生成36位uuid*/
    public synchronized static String getUuid() {
        return java.util.UUID.randomUUID().toString();
    }

    /*生成32位随机key*/
    public synchronized static String ganerator32Keys() {
        return RandomStringUtils.randomAlphanumeric(32);
    }

    /*获取现在时间的int类型值*/
    public static int getNowWithInteger() {
        return getDatetimeWithInteger(new Date());
    }

    /*获取传入时间的int类型值*/
    public static int getDatetimeWithInteger(Date date) {
        return (int) date.getTime() / 1000;
    }
    
    public static String getBirthdayByIdentity(String identity) {
        return StringUtils.substring(identity, 6, 10) + "-" + StringUtils.substring(identity, 10, 12) + "-" + StringUtils.substring(identity, 12, 14);
    }


    
    public static void getHeader(byte[] msg) {
        System.out.println(bytesToInt(ArrayUtils.subarray(msg, 0, 4)));
        System.out.println(Integer.toHexString(bytesToInt(ArrayUtils.subarray(msg, 4, 8))));
        System.out.println(Arrays.toString(ArrayUtils.subarray(msg, 8, 24)));
        System.out.println(bytesToInt(ArrayUtils.subarray(msg, 24, 28)));
        System.out.println(Integer.toHexString(bytesToInt(ArrayUtils.subarray(msg, 28, 32))));
    }
    
    public static void getBodys(byte[] msg) {
        if (msg.length == 0) {
            return;
        }
        byte[] field = null;
        byte type = msg[0];
        switch (type) {
            case 2:
                field = ArrayUtils.subarray(msg, 1, 1 + Constants.TYPE_INT_LENGTH);
                msg = ArrayUtils.subarray(msg, 1 + Constants.TYPE_INT_LENGTH, msg.length);
                System.out.println(bytesToInt(field));
                break;
            case 4:
                int index = ArrayUtils.indexOf(msg, (byte) 0);
                field = ArrayUtils.subarray(msg, 1, index);
                msg = ArrayUtils.subarray(msg, index + 1, msg.length);
                System.out.println(new String(field));
                break;
            case 7:
                field = ArrayUtils.subarray(msg, 1, 1 + Constants.TYPE_DOUBLE_LENGTH);
                msg = ArrayUtils.subarray(msg, 1 + Constants.TYPE_DOUBLE_LENGTH, msg.length);
                System.out.println(byteToDouble(field));
                break;
            default:
                return;
            
        }
//        System.out.println(Arrays.toString(field));
        if (msg.length == 0) {
            return;
        }
        getBodys(msg);
    }

    /**
     * 重組新的MsgHeader
     *
     * @param mh
     * @param msgCode
     * @return
     */
    public static MsgHeader getNewMsgHeader(MsgHeader mh, int msgCode) {
        MsgHeader result = new MsgHeader();
        result.setMessageVersion(mh.getMessageVersion());
        result.setMessageUserID(mh.getMessageUserID());
        result.setMessageReserved(mh.getMessageReserved());
        result.setMessageCode(msgCode);
        return result;
    }

    /**
     * 将异常堆栈信息转为字符串
     *
     * @param e
     * @return
     */
    public static String getExceptionMessage(Exception e) {
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        PrintWriter pw = new PrintWriter(buf, true);
        try {
            e.printStackTrace(pw);
            String expMessage = buf.toString();
            return expMessage;
        } finally {
            try {
                buf.close();
            } catch (IOException ex) {
            }
            pw.close();
        }
    }
}
