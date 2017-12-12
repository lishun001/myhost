/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rs.ocp.msg;

import com.jolbox.bonecp.BoneCPDataSource;
import com.rs.ocp.domain.dao.GameLoginSessionDao;
import com.rs.ocp.domain.endity.GameLoginsession;
import com.rs.ocp.service.PpPassportService;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.embedded.EmbeddedChannel;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.apache.commons.lang.ArrayUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * a为测试出的结果，b2为预计值
 *
 * @author zhangli
 */
public class LoginTester {

    @Autowired
    private PpPassportService passportService;
    EmbeddedChannel channel;
    JdbcTemplate jt;

    @Before
    public void init() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:META-INF/spring/applicationContext.xml");
        channel = (EmbeddedChannel) ctx.getBean("embeddedchannel");

        jt = new JdbcTemplate();
        DataSource ds = new DriverManagerDataSource("com.mysql.jdbc.Driver",
                "jdbc:mysql://192.168.2.241:3306/rshui_charge", "root", "123456");
        jt.setDataSource(ds);
    }

    /* 16   passport_name = test064
     * 用户名,密码正确,账号状态(账号表,字段:passport_status):1 - 正常,返回code=1
     */
    @Test
    public void test_passportstatus_1() {
        //登陆
        byte[] b1 = new byte[]{96, 0, 0, 0, 1, 3, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 32, 0, 0,
            2, 1, 0, 0, 0,
            4, 116, 101, 115, 116, 48, 54, 52, 0,
            4, 101, 49, 48, 97, 100, 99, 51, 57, 52, 57, 98, 97, 53, 57, 97, 98, 98, 101, 53, 54, 101, 48, 53, 55, 102, 50, 48, 102, 56, 56, 51, 101, 0,
            4, 49, 57, 50, 46, 49, 54, 56, 46, 49, 46, 49, 49, 52, 0,
            2, 22, 29, 0, 0};
        ByteBuf buf = Unpooled.buffer();
        buf.writeBytes(b1);

        channel.writeInbound(buf);
        channel.finish();

        ByteBuf output = (ByteBuf) channel.readOutbound();
        byte[] result = new byte[output.readableBytes()];
        output.readBytes(result);
        int a = bytesToInt(ArrayUtils.subarray(result, 47, 51));
        int b2 = bytesToInt(new byte[]{1, 0, 0, 0});
        System.out.println(b2 + "....." + a);
        Assert.assertEquals(b2, a);
    }

    /* 10  passport_name = test041
     * 4, 116, 101, 115, 116, 48, 52, 49, 0  (116--->11)
     * 用户名不存在, 返回code=1
     */
    @Test
    public void test_nopassport() {
        byte[] b1 = new byte[]{96, 0, 0, 0, 1, 3, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 32, 0, 0,
            2, 1, 0, 0, 0,
            4, 11, 101, 115, 116, 48, 52, 49, 0,
            4, 101, 49, 48, 97, 100, 99, 51, 57, 52, 57, 98, 97, 53, 57, 97, 98, 98, 101, 53, 54, 101, 48, 53, 55, 102, 50, 48, 102, 56, 56, 51, 101, 0,
            4, 49, 57, 50, 46, 49, 54, 56, 46, 49, 46, 49, 49, 52, 0,
            2, 22, 29, 0, 0};
        ByteBuf buf = Unpooled.buffer();
        buf.writeBytes(b1);

        channel.writeInbound(buf);
        channel.finish();

        ByteBuf output = (ByteBuf) channel.readOutbound();
        byte[] result = new byte[output.readableBytes()];
        output.readBytes(result);
        int a = bytesToInt(ArrayUtils.subarray(result, 47, 51));
        int b2 = bytesToInt(new byte[]{57, -57, 0, 0});
        System.out.println(b2 + "....." + a + "....." + result.length);
        Assert.assertEquals(b2, a);
        Assert.assertEquals(51, result.length);
    }

    /* 11   passport_name = test041
     * 4, 101, 49, 48, 97.... (101----->10)
     * 用户名存在,密码错误,返回code=51002
     */
    @Test
    public void test_nopassword() {
        byte[] b1 = new byte[]{96, 0, 0, 0, 1, 3, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 32, 0, 0,
            2, 1, 0, 0, 0,
            4, 116, 101, 115, 116, 48, 52, 49, 0,
            4, 10, 49, 48, 97, 100, 99, 51, 57, 52, 57, 98, 97, 53, 57, 97, 98, 98, 101, 53, 54, 101, 48, 53, 55, 102, 50, 48, 102, 56, 56, 51, 101, 0,
            4, 49, 57, 50, 46, 49, 54, 56, 46, 49, 46, 49, 49, 52, 0,
            2, 22, 29, 0, 0};
        ByteBuf buf = Unpooled.buffer();
        buf.writeBytes(b1);

        channel.writeInbound(buf);
        channel.finish();

        ByteBuf output = (ByteBuf) channel.readOutbound();
        byte[] result = new byte[output.readableBytes()];
        output.readBytes(result);
        int a = bytesToInt(ArrayUtils.subarray(result, 47, 51));
        int b2 = bytesToInt(new byte[]{58, -57, 0, 0});
        System.out.println(b2 + "....." + a + "....." + result.length);
        Assert.assertEquals(b2, a);
        Assert.assertEquals(51, result.length);
    }

    /* 12  passport_name = test042
     * 用户名,密码正确,账号状态(账号表,字段:passport_status):2 - 锁定,返回code=51012
     */
    @Test
    public void test_passport_status_2() {
        byte[] b1 = new byte[]{96, 0, 0, 0, 1, 3, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 32, 0, 0,
            2, 1, 0, 0, 0,
            4, 116, 101, 115, 116, 48, 52, 50, 0,
            4, 101, 49, 48, 97, 100, 99, 51, 57, 52, 57, 98, 97, 53, 57, 97, 98, 98, 101, 53, 54, 101, 48, 53, 55, 102, 50, 48, 102, 56, 56, 51, 101, 0,
            4, 49, 57, 50, 46, 49, 54, 56, 46, 49, 46, 49, 49, 52, 0,
            2, 22, 29, 0, 0};
        ByteBuf buf = Unpooled.buffer();
        buf.writeBytes(b1);

        channel.writeInbound(buf);
        channel.finish();

        ByteBuf output = (ByteBuf) channel.readOutbound();
        byte[] result = new byte[output.readableBytes()];
        output.readBytes(result);
        int a = bytesToInt(ArrayUtils.subarray(result, 47, 51));
        int b2 = bytesToInt(new byte[]{68, -57, 0, 0});
        System.out.println(b2 + "....." + a + "....." + result.length);
        Assert.assertEquals(b2, a);
        Assert.assertEquals(51, result.length);
    }

    /* 13  passport_name = test043
     * 用户名,密码正确,账号状态(账号表,字段:passport_status):3 - 冻结,返回code=51003
     */
    @Test
    public void test_passportstatus_3() {
        byte[] b1 = new byte[]{96, 0, 0, 0, 1, 3, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 32, 0, 0,
            2, 1, 0, 0, 0,
            4, 116, 101, 115, 116, 48, 52, 51, 0,
            4, 101, 49, 48, 97, 100, 99, 51, 57, 52, 57, 98, 97, 53, 57, 97, 98, 98, 101, 53, 54, 101, 48, 53, 55, 102, 50, 48, 102, 56, 56, 51, 101, 0,
            4, 49, 57, 50, 46, 49, 54, 56, 46, 49, 46, 49, 49, 52, 0,
            2, 22, 29, 0, 0};
        ByteBuf buf = Unpooled.buffer();
        buf.writeBytes(b1);

        channel.writeInbound(buf);
        channel.finish();

        ByteBuf output = (ByteBuf) channel.readOutbound();
        byte[] result = new byte[output.readableBytes()];
        output.readBytes(result);
        int a = bytesToInt(ArrayUtils.subarray(result, 47, 51));
        int b2 = bytesToInt(new byte[]{59, -57, 0, 0});
        System.out.println(b2 + "....." + a + "....." + result.length);
        Assert.assertEquals(b2, a);
        Assert.assertEquals(51, result.length);
    }

    /* 14  passport_name = test044
     * 用户名,密码正确,账号状态(账号表,字段:passport_status):4 - 停封,返回code=1000(log_code:51015)
     */
    @Test
    public void test_passportstatus_4() {
        byte[] b1 = new byte[]{96, 0, 0, 0, 1, 3, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 32, 0, 0,
            2, 1, 0, 0, 0,
            4, 116, 101, 115, 116, 48, 52, 52, 0,
            4, 101, 49, 48, 97, 100, 99, 51, 57, 52, 57, 98, 97, 53, 57, 97, 98, 98, 101, 53, 54, 101, 48, 53, 55, 102, 50, 48, 102, 56, 56, 51, 101, 0,
            4, 49, 57, 50, 46, 49, 54, 56, 46, 49, 46, 49, 49, 52, 0,
            2, 22, 29, 0, 0};
        ByteBuf buf = Unpooled.buffer();
        buf.writeBytes(b1);

        channel.writeInbound(buf);
        channel.finish();

        ByteBuf output = (ByteBuf) channel.readOutbound();
        byte[] result = new byte[output.readableBytes()];
        output.readBytes(result);
        int a = bytesToInt(ArrayUtils.subarray(result, 47, 51));
        int b2 = bytesToInt(new byte[]{-24, 3, 0, 0});
        System.out.println(b2 + "....." + a + "....." + result.length);
        Assert.assertEquals(b2, a);
        Assert.assertEquals(51, result.length);
    }

    /* 15  passport_name = test045
     * 用户名,密码正确,账号状态(账号表,字段:passport_status):9 - 删除,返回code=1000(log_code=51016)
     */
    @Test
    public void test_passportstatus_9() {
        byte[] b1 = new byte[]{96, 0, 0, 0, 1, 3, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 32, 0, 0,
            2, 1, 0, 0, 0,
            4, 116, 101, 115, 116, 48, 52, 53, 0,
            4, 101, 49, 48, 97, 100, 99, 51, 57, 52, 57, 98, 97, 53, 57, 97, 98, 98, 101, 53, 54, 101, 48, 53, 55, 102, 50, 48, 102, 56, 56, 51, 101, 0,
            4, 49, 57, 50, 46, 49, 54, 56, 46, 49, 46, 49, 49, 52, 0,
            2, 22, 29, 0, 0};
        ByteBuf buf = Unpooled.buffer();
        buf.writeBytes(b1);

        channel.writeInbound(buf);
        channel.finish();

        ByteBuf output = (ByteBuf) channel.readOutbound();
        byte[] result = new byte[output.readableBytes()];
        output.readBytes(result);
        int a = bytesToInt(ArrayUtils.subarray(result, 47, 51));
        int b2 = bytesToInt(new byte[]{-24, 3, 0, 0});
        System.out.println(b2 + "....." + a + "....." + result.length);
        Assert.assertEquals(b2, a);
        Assert.assertEquals(51, result.length);
    }

    /* 16.1  passport_name = test046  
     * 账户不存在, 返回code=1
     */
    @Test
    public void test_noaccount() {
        byte[] b1 = new byte[]{96, 0, 0, 0, 1, 3, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 32, 0, 0,
            2, 1, 0, 0, 0,
            4, 116, 101, 115, 116, 48, 52, 54, 0,
            4, 101, 49, 48, 97, 100, 99, 51, 57, 52, 57, 98, 97, 53, 57, 97, 98, 98, 101, 53, 54, 101, 48, 53, 55, 102, 50, 48, 102, 56, 56, 51, 101, 0,
            4, 49, 57, 50, 46, 49, 54, 56, 46, 49, 46, 49, 49, 52, 0,
            2, 22, 29, 0, 0};
        ByteBuf buf = Unpooled.buffer();
        buf.writeBytes(b1);

        channel.writeInbound(buf);
        channel.finish();

        ByteBuf output = (ByteBuf) channel.readOutbound();
        byte[] result = new byte[output.readableBytes()];
        output.readBytes(result);
        byte[] bb2 = new byte[]{-126, 0, 0, 0, 1, 3, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 32, 0, 0,
            2, 1, 0, 0, 0,
            4, 116, 101, 115, 116, 48, 52, 54, 0,
            2, 1, 0, 0, 0,
            2, 6, 0, 0, 0,
            4, 76, 54, 73, 76, 100, 72, 57, 118, 105, 106, 84, 82, 49, 57, 107, 78, 120, 55, 116, 106, 85, 87, 98, 69, 52, 98, 122, 105, 73, 49, 119, 118, 0,
            4, 0,
            2, 20, 0, 0, 0,
            4, 0,
            2, 0, 0, 0, 0,
            7, 0, 0, 0, 0, 0, 0, 0, 0,
            2, 2, 0, 0, 0,
            4, 48, 49, 57, 48, 48, 45, 48, 49, 45, 48, 49, 44, 84, 44, 0};
        System.out.println(Arrays.toString(result));
        int a = bytesToInt(ArrayUtils.subarray(result, 47, 51));
        int a1 = bytesToInt(ArrayUtils.subarray(result, 114, 118));
        int b2 = bytesToInt(new byte[]{1, 0, 0, 0});
        int b3 = bytesToInt(new byte[]{2, 0, 0, 0});
        System.out.println(b2 + "....." + a + "....." + result.length);
        Assert.assertEquals(b2, a);
        Assert.assertEquals(b3, a1);
    }

    /* 16.2  passport_name = test047
     * 账户存在,账户状态(account_status):2-锁定,返回code=1000
     */
    @Test
    public void test_accountstatus_2() {
        byte[] b1 = new byte[]{96, 0, 0, 0, 1, 3, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 32, 0, 0,
            2, 1, 0, 0, 0,
            4, 116, 101, 115, 116, 48, 52, 55, 0,
            4, 101, 49, 48, 97, 100, 99, 51, 57, 52, 57, 98, 97, 53, 57, 97, 98, 98, 101, 53, 54, 101, 48, 53, 55, 102, 50, 48, 102, 56, 56, 51, 101, 0,
            4, 49, 57, 50, 46, 49, 54, 56, 46, 49, 46, 49, 49, 52, 0,
            2, 22, 29, 0, 0};
        ByteBuf buf = Unpooled.buffer();
        buf.writeBytes(b1);

        channel.writeInbound(buf);
        channel.finish();

        ByteBuf output = (ByteBuf) channel.readOutbound();
        byte[] result = new byte[output.readableBytes()];
        output.readBytes(result);
        int a = bytesToInt(ArrayUtils.subarray(result, 47, 51));
        int b2 = bytesToInt(new byte[]{-24, 3, 0, 0});
        System.out.println(b2 + "....." + a + "....." + result.length);
        Assert.assertEquals(b2, a);
        Assert.assertEquals(51, result.length);
    }

    /* 16.3  passport_name = test048
     * 账户存在,账户状态(account_status):3-冻结,返回code=1000
     */
    @Test
    public void test_accountstatus_3() {
        byte[] b1 = new byte[]{96, 0, 0, 0, 1, 3, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 32, 0, 0,
            2, 1, 0, 0, 0,
            4, 116, 101, 115, 116, 48, 52, 56, 0,
            4, 101, 49, 48, 97, 100, 99, 51, 57, 52, 57, 98, 97, 53, 57, 97, 98, 98, 101, 53, 54, 101, 48, 53, 55, 102, 50, 48, 102, 56, 56, 51, 101, 0,
            4, 49, 57, 50, 46, 49, 54, 56, 46, 49, 46, 49, 49, 52, 0,
            2, 22, 29, 0, 0};
        ByteBuf buf = Unpooled.buffer();
        buf.writeBytes(b1);

        channel.writeInbound(buf);
        channel.finish();

        ByteBuf output = (ByteBuf) channel.readOutbound();
        byte[] result = new byte[output.readableBytes()];
        output.readBytes(result);
        int a = bytesToInt(ArrayUtils.subarray(result, 47, 51));
        int b2 = bytesToInt(new byte[]{-24, 3, 0, 0});
        System.out.println(b2 + "....." + a + "....." + result.length);
        Assert.assertEquals(b2, a);
        Assert.assertEquals(51, result.length);
    }

    /* 16.4  passport_name = test049
     * 账户存在,账户状态(account_status):4-停封,返回code=1000
     */
    @Test
    public void test_accountstatus_4() {
        byte[] b1 = new byte[]{96, 0, 0, 0, 1, 3, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 32, 0, 0,
            2, 1, 0, 0, 0,
            4, 116, 101, 115, 116, 48, 52, 57, 0,
            4, 101, 49, 48, 97, 100, 99, 51, 57, 52, 57, 98, 97, 53, 57, 97, 98, 98, 101, 53, 54, 101, 48, 53, 55, 102, 50, 48, 102, 56, 56, 51, 101, 0,
            4, 49, 57, 50, 46, 49, 54, 56, 46, 49, 46, 49, 49, 52, 0,
            2, 22, 29, 0, 0};
        ByteBuf buf = Unpooled.buffer();
        buf.writeBytes(b1);

        channel.writeInbound(buf);
        channel.finish();

        ByteBuf output = (ByteBuf) channel.readOutbound();
        byte[] result = new byte[output.readableBytes()];
        output.readBytes(result);
        int a = bytesToInt(ArrayUtils.subarray(result, 47, 51));
        int b2 = bytesToInt(new byte[]{-24, 3, 0, 0});
        System.out.println(b2 + "....." + a + "....." + result.length);
        Assert.assertEquals(b2, a);
        Assert.assertEquals(51, result.length);
    }

    /* 16.5  passport_name = test050
     * 账户存在,账户状态(account_status):9-删除,返回code=1000
     */
    @Test
    public void test_accountstatus_9() {
        byte[] b1 = new byte[]{96, 0, 0, 0, 1, 3, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 32, 0, 0,
            2, 1, 0, 0, 0,
            4, 116, 101, 115, 116, 48, 53, 48, 0,
            4, 101, 49, 48, 97, 100, 99, 51, 57, 52, 57, 98, 97, 53, 57, 97, 98, 98, 101, 53, 54, 101, 48, 53, 55, 102, 50, 48, 102, 56, 56, 51, 101, 0,
            4, 49, 57, 50, 46, 49, 54, 56, 46, 49, 46, 49, 49, 52, 0,
            2, 22, 29, 0, 0};
        ByteBuf buf = Unpooled.buffer();
        buf.writeBytes(b1);

        channel.writeInbound(buf);
        channel.finish();

        ByteBuf output = (ByteBuf) channel.readOutbound();
        byte[] result = new byte[output.readableBytes()];
        output.readBytes(result);
        int a = bytesToInt(ArrayUtils.subarray(result, 47, 51));
        int b2 = bytesToInt(new byte[]{-24, 3, 0, 0});
        System.out.println(b2 + "....." + a + "....." + result.length);
        Assert.assertEquals(b2, a);
        Assert.assertEquals(51, result.length);
    }

    /* 16.6 passport_name = test051 --->116, 101, 115, 116, 48, 53, 49
     * 账户存在,账户状态(account_status):1-正常,返回code=1
     */
    @Test
    public void test_accountstatus_1() {
        byte[] b1 = new byte[]{96, 0, 0, 0, 1, 3, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 32, 0, 0,
            2, 1, 0, 0, 0,
            4, 116, 101, 115, 116, 48, 53, 49, 0,
            4, 101, 49, 48, 97, 100, 99, 51, 57, 52, 57, 98, 97, 53, 57, 97, 98, 98, 101, 53, 54, 101, 48, 53, 55, 102, 50, 48, 102, 56, 56, 51, 101, 0,
            4, 49, 57, 50, 46, 49, 54, 56, 46, 49, 46, 49, 49, 52, 0,
            2, 22, 29, 0, 0};
        ByteBuf buf = Unpooled.buffer();
        buf.writeBytes(b1);

        channel.writeInbound(buf);
        channel.finish();

        ByteBuf output = (ByteBuf) channel.readOutbound();
        byte[] result = new byte[output.readableBytes()];
        output.readBytes(result);
        int a = bytesToInt(ArrayUtils.subarray(result, 47, 51));
        int b2 = bytesToInt(new byte[]{1, 0, 0, 0});
        System.out.println(b2 + "....." + a + "....." + result.length);
        Assert.assertEquals(b2, a);
    }
    /* 16.7 
     * passport_name = test052  --->116, 101, 115, 116, 48, 53, 50
     * 新登录会在game_loginsession表中插入一条sessionid记录并返回
     */

    @Test
    public void game_loginsession() {
        byte[] b1 = new byte[]{96, 0, 0, 0, 1, 3, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 32, 0, 0,
            2, 1, 0, 0, 0,
            4, 116, 101, 115, 116, 48, 53, 50, 0,
            4, 101, 49, 48, 97, 100, 99, 51, 57, 52, 57, 98, 97, 53, 57, 97, 98, 98, 101, 53, 54, 101, 48, 53, 55, 102, 50, 48, 102, 56, 56, 51, 101, 0,
            4, 49, 57, 50, 46, 49, 54, 56, 46, 49, 46, 49, 49, 52, 0,
            2, 22, 29, 0, 0};
        ByteBuf buf = Unpooled.buffer();
        buf.writeBytes(b1);

        channel.writeInbound(buf);
        channel.finish();

        ByteBuf output = (ByteBuf) channel.readOutbound();
        byte[] result = new byte[output.readableBytes()];
        output.readBytes(result);
        byte[] byt = ArrayUtils.subarray(result, 57, 89);
        String str = new String(byt);
        System.out.println(str);
        System.out.println(Arrays.toString(byt));
        int i = jt.queryForInt("SELECT COUNT(*) FROM game_loginsession  l WHERE l.session_key = '" + str + "'");
        Assert.assertEquals(1, i);
    }

    /* 16.7  passport_status状态为3的loginsession未插入测试  passport_name = test043
     * 用户名,密码正确,账号状态(账号表,字段:passport_status):3 - 冻结
     * 新登录会在game_loginsession表中插入一条sessionid记录并返回  accounttype  account  result
     */
    @Test
    public void test_nologinsession_1() {
        byte[] b1 = new byte[]{96, 0, 0, 0, 1, 3, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 32, 0, 0,
            2, 1, 0, 0, 0,
            4, 116, 101, 115, 116, 48, 52, 51, 0,
            4, 101, 49, 48, 97, 100, 99, 51, 57, 52, 57, 98, 97, 53, 57, 97, 98, 98, 101, 53, 54, 101, 48, 53, 55, 102, 50, 48, 102, 56, 56, 51, 101, 0,
            4, 49, 57, 50, 46, 49, 54, 56, 46, 49, 46, 49, 49, 52, 0,
            2, 22, 29, 0, 0};
        ByteBuf buf = Unpooled.buffer();
        buf.writeBytes(b1);

        channel.writeInbound(buf);
        channel.finish();

        ByteBuf output = (ByteBuf) channel.readOutbound();
        byte[] result = new byte[output.readableBytes()];
        output.readBytes(result);
        byte[] byt = ArrayUtils.subarray(result, 57, 89);
        String str = new String(byt);
        System.out.println(Arrays.toString(result));
        int i = jt.queryForInt("SELECT COUNT(*) FROM game_loginsession  l WHERE l.session_key = '" + str + "'");
        Assert.assertEquals(0, i);
    }

    /* 16.8  passport_name = test070
     * 登陆成功检验对应返回参数正确 非防沉迷返回参数
     */
    @Test
    public void test_Toaccinfo() {
        byte[] b1 = new byte[]{96, 0, 0, 0, 1, 3, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 32, 0, 0,
            2, 1, 0, 0, 0,
            4, 116, 101, 115, 116, 48, 55, 48, 0,
            4, 101, 49, 48, 97, 100, 99, 51, 57, 52, 57, 98, 97, 53, 57, 97, 98, 98, 101, 53, 54, 101, 48, 53, 55, 102, 50, 48, 102, 56, 56, 51, 101, 0,
            4, 49, 57, 50, 46, 49, 54, 56, 46, 49, 46, 49, 49, 52, 0,
            2, 22, 29, 0, 0};
        ByteBuf buf = Unpooled.buffer();
        buf.writeBytes(b1);

        channel.writeInbound(buf);
        channel.finish();

        ByteBuf output = (ByteBuf) channel.readOutbound();
        byte[] result = new byte[output.readableBytes()];
        output.readBytes(result);
        int a = bytesToInt(ArrayUtils.subarray(result, 47, 51));
        int b2 = bytesToInt(new byte[]{1, 0, 0, 0});
        System.out.println(b2 + "....." + a);
        Assert.assertEquals(b2, a);

        //返回的GM
        //System.out.println(bytesToInt(ArrayUtils.subarray(result, 93, 97)));
        int outGM = jt.queryForInt("SELECT passport_gmlevel FROM pp_passport  l WHERE l.passport_name = '" + new String(ArrayUtils.subarray(result, 38, 45)) + "'");
        Assert.assertEquals(bytesToInt(ArrayUtils.subarray(result, 93, 97)), outGM);
        //返回的剩余点数
        //System.out.println(bytesToInt(ArrayUtils.subarray(result, 100, 104)));
        int outpoint = jt.queryForInt("SELECT account_points FROM acc_account a , pp_passport p WHERE a.account_pid=p.passport_pid AND p.passport_name= '" + new String(ArrayUtils.subarray(result, 38, 45)) + "'");
        Assert.assertEquals(bytesToInt(ArrayUtils.subarray(result, 100, 104)), outpoint);
        //返回的到期日期月卡期限
        //System.out.println(byteToDouble(ArrayUtils.subarray(result, 105, 113)));
        int outlimit = jt.queryForInt("SELECT account_deadline FROM acc_account a , pp_passport p WHERE a.account_pid=p.passport_pid AND p.passport_name= '" + new String(ArrayUtils.subarray(result, 38, 45)) + "'");
        Assert.assertEquals((int) byteToDouble(ArrayUtils.subarray(result, 105, 113)), outlimit);
        //返回的是否为人民币玩家
        //System.out.println(bytesToInt(ArrayUtils.subarray(result, 114, 118)));
        int outidrmb = jt.queryForInt("SELECT account_isrmb FROM acc_account a , pp_passport p WHERE a.account_pid=p.passport_pid AND p.passport_name= '" + new String(ArrayUtils.subarray(result, 38, 45)) + "'");
        Assert.assertEquals(bytesToInt(ArrayUtils.subarray(result, 114, 118)), outidrmb);

        //账号信息
        /* 性别和生日设为固定01900-01-01
         * 验证性别截取字符串与数据库user_sex相比较
         */
        String str = new String(ArrayUtils.subarray(result, 119, result.length));
        String outsex1 = str.substring(0, 1);
        String outbirth1 = str.substring(1, 11);
        Assert.assertEquals("0", outsex1);
        Assert.assertEquals("1900-01-01", outbirth1);
        Assert.assertEquals("01900-01-01,T, ", new String(ArrayUtils.subarray(result, 119, result.length)));
    }

    /**
     * -------------------------------单独测------------------------------------
     */
    /* 16.8  passport_name = test053  通过登录登出登录登出取累计在线时间与数据库fcm_onlinetime比较是否一致
     * fcm用户测试
     */
    //@Test
    public void test_fcm() {
        byte[] b1 = new byte[]{96, 0, 0, 0, 1, 3, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 32, 0, 0,
            2, 1, 0, 0, 0,
            4, 116, 101, 115, 116, 48, 52, 49, 0,
            4, 101, 49, 48, 97, 100, 99, 51, 57, 52, 57, 98, 97, 53, 57, 97, 98, 98, 101, 53, 54, 101, 48, 53, 55, 102, 50, 48, 102, 56, 56, 51, 101, 0,
            4, 49, 57, 50, 46, 49, 54, 56, 46, 49, 46, 49, 49, 52, 0,
            2, 22, 29, 0, 0};
        ByteBuf buf = Unpooled.buffer();
        buf.writeBytes(b1);

        channel.writeInbound(buf);
        channel.finish();

        ByteBuf output = (ByteBuf) channel.readOutbound();
        byte[] result = new byte[output.readableBytes()];
        output.readBytes(result);
        System.out.println(Arrays.toString(result));
        System.out.println(new String(ArrayUtils.subarray(result, 119, result.length)));
        String str = new String(ArrayUtils.subarray(result, 132, result.length - 2));
        /*
         * 验证fcm截取字符串与数据库pp_fcm_toltaltime相比较
         */
        System.out.println(str);
        //System.out.println(str.substring(12, str.length()));
    }

    //16.1  如果是防沉迷用户, 记录防沉迷信息，是防沉迷用户pp_fcm_totaltime表会新增一条数据
    /* passport_name = test069  id=3019
     * fcm用户测试
     */
    //@Test
    public void test_fcmtest() {
        byte[] b1 = new byte[]{96, 0, 0, 0, 1, 3, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 32, 0, 0,
            2, 1, 0, 0, 0,
            4, 116, 101, 115, 116, 48, 53, 51, 0,
            4, 101, 49, 48, 97, 100, 99, 51, 57, 52, 57, 98, 97, 53, 57, 97, 98, 98, 101, 53, 54, 101, 48, 53, 55, 102, 50, 48, 102, 56, 56, 51, 101, 0,
            4, 49, 57, 50, 46, 49, 54, 56, 46, 49, 46, 49, 49, 52, 0,
            2, 22, 29, 0, 0};
        ByteBuf buf = Unpooled.buffer();
        buf.writeBytes(b1);

        channel.writeInbound(buf);
        channel.finish();

        ByteBuf output = (ByteBuf) channel.readOutbound();
        byte[] result = new byte[output.readableBytes()];
        output.readBytes(result);
        int a = bytesToInt(ArrayUtils.subarray(result, 47, 51));
        int b2 = bytesToInt(new byte[]{1, 0, 0, 0});
        System.out.println(b2 + "....." + a);
    }

    /* 16.9  passport_name = test041
     * 记录登陆日志(表:game_login) 登录时日志中会新增一条数据	
     */
    //@Test
    public void test_gamelogin() {
        byte[] b1 = new byte[]{96, 0, 0, 0, 1, 3, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 32, 0, 0,
            2, 1, 0, 0, 0,
            4, 116, 101, 115, 116, 48, 52, 49, 0,
            4, 101, 49, 48, 97, 100, 99, 51, 57, 52, 57, 98, 97, 53, 57, 97, 98, 98, 101, 53, 54, 101, 48, 53, 55, 102, 50, 48, 102, 56, 56, 51, 101, 0,
            4, 49, 57, 50, 46, 49, 54, 56, 46, 49, 46, 49, 49, 52, 0,
            2, 22, 29, 0, 0};
        ByteBuf buf = Unpooled.buffer();
        buf.writeBytes(b1);

        channel.writeInbound(buf);
        channel.finish();

        ByteBuf output = (ByteBuf) channel.readOutbound();
        byte[] result = new byte[output.readableBytes()];
        output.readBytes(result);
        byte[] byt = ArrayUtils.subarray(result, 57, 89);
        String str = new String(byt);
        System.out.println(Arrays.toString(byt));
        int i = jt.queryForInt("SELECT COUNT(*) FROM game_login  l WHERE l.login_sessionkey = '" + str + "'");
        System.out.println(i);
    }

    /* 16.9   passport_name = test041 取对应的数据库中的session值
     * 登出时日志中会新增一条数据
     */
    //@Test
    public void test_gameloginout() {
        byte[] b2 = new byte[]{115, 0, 0, 0, 1, 3, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 32, 0, 0,
            2, 1, 0, 0, 0,
            4, 82, 108, 55, 51, 81, 75, 84, 116, 86, 50, 83, 104, 99, 113, 68, 48, 99, 122, 75, 74, 112, 54, 113, 111, 89, 78, 57, 107, 122, 105, 108, 84, 0,
            2, 2, 0, 0, 0,
            4, 116, 101, 115, 116, 48, 52, 49, 0,
            4, 101, 49, 48, 97, 100, 99, 51, 57, 52, 57, 98, 97, 53, 57, 97, 98, 98, 101, 53, 54, 101, 48, 53, 55, 102, 50, 48, 102, 56, 56, 51, 101, 0};
        ByteBuf buf = Unpooled.buffer();
        buf.writeBytes(b2);

        channel.writeInbound(buf);
        channel.finish();

        ByteBuf output = (ByteBuf) channel.readOutbound();
        byte[] result = new byte[output.readableBytes()];
        output.readBytes(result);
        byte[] byt = ArrayUtils.subarray(b2, 38, 70);
        String str = new String(byt);
        System.out.println(Arrays.toString(byt));
        int i2 = jt.queryForInt("SELECT COUNT(*) FROM game_login  l WHERE l.login_sessionkey = '" + str + "'");
        System.out.println(i2);
    }

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
}
