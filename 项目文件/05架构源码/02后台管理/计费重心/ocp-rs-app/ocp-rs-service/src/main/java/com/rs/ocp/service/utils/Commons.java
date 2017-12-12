 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rs.ocp.service.utils;

import com.rs.ocp.domain.utils.DomainConfConst;
import com.rs.ocp.service.conf.CommonConstants;
import com.rs.ocp.service.conf.MessageConfConst;
import com.rs.ocp.service.dto.MsgHeader;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.slf4j.LoggerFactory;

/**
 *
 * @author zhaoweixing
 */
public class Commons {

    private static org.slf4j.Logger exception_logger = LoggerFactory.getLogger("exception_logger");
    public static final String GBK = "gbk";
    public static final String UNICODE = "unicode";
    /**
     * 防沉迷开关 true为开 false为关
     */
    public static boolean IS_OPEN_FCM = false;

    public static Object getPropertyByKey(String key) throws Exception {
        InputStream input = new BufferedInputStream(new FileInputStream(
                new File(CommonConstants.CONFIG_DATABASES)));
        Properties properties = new Properties();
        properties.load(input);
        input.close();
        return properties.get(key);
    }

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
        return ArrayUtils.add(Commons.intToByte(n), 0, MessageConfConst.TYPE_INT);
    }

    /*由double型转换成带type类型的byte数组, 类似new byte[]{2, 1, 0, 0, 0, 1, 0, 0, 0}*/
    public static byte[] doubleToByteWithType(double d) {
        return ArrayUtils.add(Commons.doubleToByte(d), 0, MessageConfConst.TYPE_DOUBLE);
    }

    /*由String型转换成带type类型并有结束符的byte数组, 类似new byte[]{4, 83, 75, 89, 95, 83, 69, 82, 86, 69, 82, 0}*/
    public static byte[] stringToByteWithType(String s) {
        if (StringUtils.isEmpty(s)) {
            return ArrayUtils.addAll(new byte[]{MessageConfConst.TYPE_STRING}, MessageConfConst.TYPE_STRING_END);
        }
        return ArrayUtils.addAll(ArrayUtils.add(s.getBytes(), 0, MessageConfConst.TYPE_STRING), MessageConfConst.TYPE_STRING_END);
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
        //ArrayUtils.reverse(b);
        return b;
    }

    //字节到浮点转换  
    public static double byteToDouble(byte[] b) {
        //解决大小端问题
        //ArrayUtils.reverse(b);
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
        return (int) (date.getTime() / 1000);
    }

    public static String getBirthdayByIdentity(String identity) {
        return StringUtils.substring(identity, 6, 10) + "-" + StringUtils.substring(identity, 10, 12) + "-" + StringUtils.substring(identity, 12, 14);
    }

    /*根据map生成json*/
    public static String GaneratorJsonByMap(Map map) {
        return JSONObject.fromObject(map).toString();
    }

    public static String getRandomMiBao() {
        Set<String> keySet = DomainConfConst.MiBaoColsMap.keySet();
        Object[] keys = keySet.toArray();
        List<String> result = new ArrayList<String>();
        StringBuilder miBao = new StringBuilder();
        int count = 1;
        String col = keys[RandomUtils.nextInt(keys.length)].toString();
        result.add(col);
        miBao.append(col).append(",");
        while (true) {
            col = keys[RandomUtils.nextInt(keys.length)].toString();
            while (result.contains(col)) {
                col = keys[RandomUtils.nextInt(keys.length)].toString();
            }
            result.add(col);
            if (count == 2) {
                miBao.append(col);
                break;
            }
            miBao.append(col).append(",");
            count++;
        }
        return miBao.toString();
    }

    public static String[][] getMiBaoByJson(String mibaJso) {
        JSONArray j_rows = JSONArray.fromObject(mibaJso);
        int rows = DomainConfConst.MIBAO_ROW_NUMS;
        JSONArray j_cols = (JSONArray) j_rows.get(0);
        int cols = DomainConfConst.MIBAO_COL_NUMS;
        String[][] mbarray = new String[rows][cols];
        for (int i = 0; i < j_rows.size(); i++) {
            j_cols = (JSONArray) j_rows.get(i);
            for (int h = 0; h < j_cols.size(); h++) {
                mbarray[i][h] = j_cols.getString(h);
            }
        }
        return mbarray;
    }

    public static void main(String[] args) {
        System.out.println(getRandomMiBao());
        try {


            DomainConfConst.init();
            Map<String, String> aaa = DomainConfConst.MiBaoColsMap;
            for (Map.Entry<String, String> e : aaa.entrySet()) {
                String beList = e.getValue();
                String stockId = e.getKey();
            }

            String sss = Commons.getRandomMiBao();
            System.out.println("**********************");
            System.out.println(sss);
            String[][] dddd = Commons.getMiBaoByJson("[[\"8A\",\"99\",\"1B\",\"B8\",\"C5\",\"77\",\"2E\",\"F3\",\"D5\"],[\"3D\",\"D2\",\"21\",\"93\",\"E2\",\"A0\",\"FB\",\"57\",\"DE\"],[\"AF\",\"B8\",\"F7\",\"2A\",\"97\",\"11\",\"CE\",\"3E\",\"71\"],[\"3D\",\"B2\",\"11\",\"D5\",\"F5\",\"FB\",\"1B\",\"DA\",\"70\"],[\"82\",\"55\",\"19\",\"66\",\"9E\",\"37\",\"A9\",\"11\",\"28\"],[\"B8\",\"22\",\"26\",\"77\",\"50\",\"9E\",\"E0\",\"64\",\"F8\"],[\"B2\",\"F4\",\"46\",\"28\",\"78\",\"9D\",\"F6\",\"D7\",\"88\"],[\"90\",\"CC\",\"7D\",\"F9\",\"08\",\"9F\",\"13\",\"63\",\"BA\"]]");

            System.out.println("**********************");

            System.out.println(Arrays.toString(Commons.intToByte(0x3000)));
            System.out.println(Arrays.toString(Commons.intToByte(1)));
            System.out.println(Arrays.toString(Commons.intToByte(2)));
            System.out.println(Arrays.toString(Commons.intToByte(3)));

            String name = "test0001";
            System.out.println(Arrays.toString(name.getBytes()));


            String pwd = "e10adc3949ba59abbe56e057f20f883e";
            System.out.println(Arrays.toString(pwd.getBytes()));
            byte[] b44 = new byte[]{77, 0, 0, 0, 1, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 64, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 48, 0, 0,
                4, 116, 101, 115, 116, 48, 48, 48, 49, 0,
                2, 3, 0, 0, 0,
                4, 101, 49, 48, 97, 100, 99, 51, 57, 52, 57, 98, 97, 53, 57, 97, 98, 98, 101, 53, 54, 101, 48, 53, 55, 102, 50, 48, 102, 56, 56, 51, 101, 0};
            System.out.println(b44.length-4);
            System.out.println(Arrays.toString(Commons.intToByte(77)));
            
            //验证账号
            byte[] b344 = new byte[]{102, 0, 0, 0, 1, 3, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 48, 0, 0,
                2, 1, 0, 0, 0,
                4, 116, 101, 115, 116, 49, 48, 48, 48, 0,
                4, 101, 49, 48, 97, 100, 99, 51, 57, 52, 57, 98, 97, 53, 57, 97, 98, 98, 101, 53, 54, 101, 48, 53, 55, 102, 50, 48, 102, 56, 56, 51, 101, 0,
                4, 49, 57, 50, 46, 49, 54, 56, 46, 49, 46, 49, 49, 52, 0,
                2, 22, 29, 0, 0,
                2, 22, 29, 0, 0};
            System.out.println(b344.length-4);
            System.out.println(Arrays.toString(Commons.intToByte(102)));
           
            String ggg="e10adc3949ba59abbe56e057f20f883e|H10,D4,A8";
            System.out.println(Arrays.toString(ggg.getBytes()));
            
            
                        //登陆
            byte[] b367 = new byte[]{107, 0, 0, 0, 1, 3, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 32, 0, 0,
                2, 1, 0, 0, 0,
                4, 116, 101, 115, 116, 49, 48, 48, 48, 0,
                4, 101, 49, 48, 97, 100, 99, 51, 57, 52, 57, 98, 97, 53, 57, 97, 98, 98, 101, 53, 54, 101, 48, 53, 55, 102, 50, 48, 102, 56, 56, 51, 101, 124, 72, 49, 48, 44, 68, 52, 44, 65, 56, 0,
                4, 49, 57, 50, 46, 49, 54, 56, 46, 49, 46, 49, 49, 52, 0,
                2, 22, 29, 0, 0};
            
             System.out.println(b367.length-4);
            System.out.println(Arrays.toString(Commons.intToByte(106)));

            //注册服务器
            byte[] b1 = new byte[]{89, 0, 0, 0, 1, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 64, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 16, 0, 0,
                2, 1, 0, 0, 0,
                2, -119, 0, 0, 0,
                4, 83, 75, 89, 95, 83, 69, 82, 86, 69, 82, 0,
                4, 53, 51, 48, 53, 102, 53, 54, 99, 98, 53, 49, 102, 101, 57, 102, 54, 56, 101, 50, 99, 54, 48, 49, 55, 99, 99, 100, 102, 56, 49, 101, 48, 0,
                2, 0, 0, 0, 0};

            //注销服务器
            byte[] b2 = new byte[]{28, 0, 0, 0, 1, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 64, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 16, 0, 0};

            //登陆
            byte[] b3 = new byte[]{97, 0, 0, 0, 1, 3, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 32, 0, 0,
                2, 1, 0, 0, 0,
                4, 116, 101, 115, 116, 49, 48, 48, 48, 0,
                4, 101, 49, 48, 97, 100, 99, 51, 57, 52, 57, 98, 97, 53, 57, 97, 98, 98, 101, 53, 54, 101, 48, 53, 55, 102, 50, 48, 102, 56, 56, 51, 101, 0,
                4, 49, 57, 50, 46, 49, 54, 56, 46, 49, 46, 49, 49, 52, 0,
                2, 22, 29, 0, 0};

            //登出
            byte[] b4 = new byte[]{115, 0, 0, 0, 1, 3, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 32, 0, 0,
                2, 1, 0, 0, 0,
                4, 116, 90, 114, 68, 71, 83, 84, 83, 90, 85, 109, 105, 70, 67, 75, 81, 78, 103, 121, 53, 72, 104, 106, 101, 55, 109, 52, 107, 119, 75, 84, 119, 0,
                2, 2, 0, 0, 0,
                4, 116, 101, 115, 116, 48, 52, 49, 0,
                4, 101, 49, 48, 97, 100, 99, 51, 57, 52, 57, 98, 97, 53, 57, 97, 98, 98, 101, 53, 54, 101, 48, 53, 55, 102, 50, 48, 102, 56, 56, 51, 101, 0};
            //查询点数
            byte[] b5 = new byte[]{33, 0, 0, 0, 1, 3, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 28, 32, 0, 0,
                2, -24, 3, 0, 0};

            //更新帐户(游戏服务器发)（扣点,每隔60秒发一次）
            byte[] b6 = new byte[]{78, 0, 0, 0, 45, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 32, 0, 0,
                2, 5, 0, 0, 0,
                4, 66, 69, 85, 121, 71, 114, 116, 77, 102, 57, 54, 121, 51, 105, 90, 67, 120, 107, 108, 57, 66, 82, 88, 100, 113, 104, 97, 53, 97, 120, 71, 66, 0,
                2, 2, 0, 0, 0,
                4, 97, 97, 97, 97, 0};



        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    /*
     * 中文-"测试" 对应java unicode转码为:{-2, -1, 109, 75, -117, -43}
     * 现发给游戏服务端需要把-2, -1去掉, 然后大小端两两位置互换, 结果为{75, 109, -43, -117}
     * 游戏方能解析
     */
    public static byte[] exchangeStr2WideStr(byte[] source) {
        byte[] target = new byte[source.length - 2];
        for (int i = 0; i < target.length; i++) {
            if (i % 2 == 0) {
                target[i] = source[i + 3];
            } else {
                target[i] = source[i + 1];
            }
        }
        return target;
    }

    /*
     * 两两反转
     */
    public static byte[] exchangeWideStr2Str(byte[] source) {
        byte[] target = new byte[source.length];
        for (int i = 0; i < source.length; i++) {
            if (i % 2 == 0) {
                target[i] = source[i + 1];
            } else {
                target[i] = source[i - 1];
            }
        }
        return target;
    }

    /*由WideString型转换成带type类型并有结束符的byte数组, 类似new byte[]{5, 83, 75, 89, 95, 83, 69, 82, 86, 69, 82, 0, 0}*/
    public static byte[] wideStringToByteWithType(String s) throws UnsupportedEncodingException {
        if (StringUtils.isEmpty(s)) {
            return ArrayUtils.addAll(new byte[]{MessageConfConst.TYPE_WIDESTR}, MessageConfConst.TYPE_WIDESTR_END);
        }
        return ArrayUtils.addAll(ArrayUtils.add(exchangeStr2WideStr(s.getBytes(Commons.UNICODE)), 0, MessageConfConst.TYPE_WIDESTR), MessageConfConst.TYPE_WIDESTR_END);
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
                field = ArrayUtils.subarray(msg, 1, 1 + MessageConfConst.TYPE_INT_LENGTH);
                msg = ArrayUtils.subarray(msg, 1 + MessageConfConst.TYPE_INT_LENGTH, msg.length);
                System.out.println(bytesToInt(field));
                break;
            case 4:
                int index = ArrayUtils.indexOf(msg, (byte) 0);
                field = ArrayUtils.subarray(msg, 1, index);
                msg = ArrayUtils.subarray(msg, index + 1, msg.length);
                System.out.println(new String(field));
                break;
            case 7:
                field = ArrayUtils.subarray(msg, 1, 1 + MessageConfConst.TYPE_DOUBLE_LENGTH);
                msg = ArrayUtils.subarray(msg, 1 + MessageConfConst.TYPE_DOUBLE_LENGTH, msg.length);
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
    public static String getExceptionMessage(Throwable e) {
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
                exception_logger.error(ex.getMessage());
            }
            pw.close();
        }
    }

    /**
     *
     * 日期是否过期
     *
     * @param orig 被比较日期
     * @param dest 参考日期
     * @return 是否过期
     */
    public static boolean isExceed(Date orig, Date dest) {
        int balance = orig.compareTo(dest);
        if (balance > 0) {
            return false;
        } else {
            return true;
        }
    }

    public static String getGbkByBytes(byte[] str) {
        try {
            String account = new String(str, Commons.GBK);
            return account;
        } catch (Exception e) {
            exception_logger.error(e.getMessage());
            return null;
        }
    }
}
