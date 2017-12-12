/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rs.ocp.msg;

import static com.rs.ocp.msg.LoginTester.bytesToInt;
import com.rs.ocp.service.PpPassportService;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.embedded.EmbeddedChannel;
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
 *
 * @author zhangli
 */
public class QueryPointTester {

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

    /**
     * 无论跑多少遍，测试结果都是一样的 返回中心点数
     *
     * @param bytes
     * @return
     */
    /* 20   2, 1, 0, 0, 0--->2, 50, 0, 0, 0
     * 账户不存在(账户表:acc_account ), 返回code=51014
     */
    @Test
    public void test_pointnoaccount() {
        byte[] b1 = new byte[]{33, 0, 0, 0, 1, 3, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 28, 32, 0, 0,
            2, 50, 0, 0, 0};
        ByteBuf buf = Unpooled.buffer();
        buf.writeBytes(b1);

        channel.writeInbound(buf);
        channel.finish();

        ByteBuf output = (ByteBuf) channel.readOutbound();
        byte[] result = new byte[output.readableBytes()];
        output.readBytes(result);
        int a = bytesToInt(ArrayUtils.subarray(result, 38, 42));
        int b2 = bytesToInt(new byte[]{70, -57, 0, 0});
        System.out.println(b2 + "....." + a);
        Assert.assertEquals(b2, a);
    }

    /* 21
     * 账户存在,账户状态(account_status):2-锁定,返回code=51012
     */
    @Test
    public void test_pointaccountstatus_2() {
        byte[] b1 = new byte[]{33, 0, 0, 0, 1, 3, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 28, 32, 0, 0,
            2, 7, 0, 0, 0};
        ByteBuf buf = Unpooled.buffer();
        buf.writeBytes(b1);

        channel.writeInbound(buf);
        channel.finish();

        ByteBuf output = (ByteBuf) channel.readOutbound();
        byte[] result = new byte[output.readableBytes()];
        output.readBytes(result);
        int a = bytesToInt(ArrayUtils.subarray(result, 38, 42));
        int b2 = bytesToInt(new byte[]{-24, 3, 0, 0});
        System.out.println(b2 + "....." + a);
        Assert.assertEquals(b2, a);
    }

    /* 22  account id=8
     * 账户存在,账户状态(account_status):3-冻结,返回code=1000
     */
    @Test
    public void test_pointaccountstatus_3() {
        byte[] b1 = new byte[]{33, 0, 0, 0, 1, 3, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 28, 32, 0, 0,
            2, 8, 0, 0, 0};
        ByteBuf buf = Unpooled.buffer();
        buf.writeBytes(b1);

        channel.writeInbound(buf);
        channel.finish();

        ByteBuf output = (ByteBuf) channel.readOutbound();
        byte[] result = new byte[output.readableBytes()];
        output.readBytes(result);
        int a = bytesToInt(ArrayUtils.subarray(result, 38, 42));
        int b2 = bytesToInt(new byte[]{-24, 3, 0, 0});
        System.out.println(b2 + "....." + a);
        Assert.assertEquals(b2, a);
    }

    /* 23  account id=9
     * 账户存在,账户状态(account_status):4-停封,返回code=1000
     */
    @Test
    public void test_pointaccountstatus_4() {
        byte[] b1 = new byte[]{33, 0, 0, 0, 1, 3, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 28, 32, 0, 0,
            2, 9, 0, 0, 0};
        ByteBuf buf = Unpooled.buffer();
        buf.writeBytes(b1);

        channel.writeInbound(buf);
        channel.finish();

        ByteBuf output = (ByteBuf) channel.readOutbound();
        byte[] result = new byte[output.readableBytes()];
        output.readBytes(result);
        int a = bytesToInt(ArrayUtils.subarray(result, 38, 42));
        int b2 = bytesToInt(new byte[]{-24, 3, 0, 0});
        System.out.println(b2 + "....." + a);
        Assert.assertEquals(b2, a);
    }

    /* 24 account id=10
     * 账户存在,账户状态(account_status):9-删除,返回code=1000
     */
    @Test
    public void test_pointaccountstatus_9() {
        byte[] b1 = new byte[]{33, 0, 0, 0, 1, 3, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 28, 32, 0, 0,
            2, 10, 0, 0, 0};
        ByteBuf buf = Unpooled.buffer();
        buf.writeBytes(b1);

        channel.writeInbound(buf);
        channel.finish();

        ByteBuf output = (ByteBuf) channel.readOutbound();
        byte[] result = new byte[output.readableBytes()];
        output.readBytes(result);
        int a = bytesToInt(ArrayUtils.subarray(result, 38, 42));
        int b2 = bytesToInt(new byte[]{-24, 3, 0, 0});
        System.out.println(b2 + "....." + a);
        Assert.assertEquals(b2, a);
    }

    /* 25  account id=1
     * 正确返回
     */
    @Test
    public void test_pointsuccess() {
        byte[] b1 = new byte[]{33, 0, 0, 0, 1, 3, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 28, 32, 0, 0,
            2, 1, 0, 0, 0};
        ByteBuf buf = Unpooled.buffer();
        buf.writeBytes(b1);

        channel.writeInbound(buf);
        channel.finish();

        ByteBuf output = (ByteBuf) channel.readOutbound();
        byte[] result = new byte[output.readableBytes()];
        output.readBytes(result);
        int a = bytesToInt(ArrayUtils.subarray(result, 38, 42));

        int a1 = bytesToInt(ArrayUtils.subarray(result, 43, 47));
        System.out.println(a1);
        int b2 = bytesToInt(new byte[]{1, 0, 0, 0});
        System.out.println(b2 + "....." + a);
        Assert.assertEquals(b2, a);
    }
}
