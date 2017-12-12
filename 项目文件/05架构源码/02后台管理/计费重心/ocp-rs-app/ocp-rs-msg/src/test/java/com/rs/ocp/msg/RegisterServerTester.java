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
import java.util.Arrays;
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
public class RegisterServerTester {

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
     * 注册服务器测试
     */
    /* 1  serverid = 137    2, -119, 0, 0, 0，     -119---->-89
     * md5验证错误[md5(serverId + "110100")==password], 注册失败:返回code=50001
     */
    @Test
    public void test_nomd5() {
        byte[] b1 = new byte[]{89, 0, 0, 0, 1, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 64, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 16, 0, 0,
            2, 1, 0, 0, 0,
            2, -89, 0, 0, 0,
            4, 83, 75, 89, 95, 83, 69, 82, 86, 69, 82, 0,
            4, 53, 51, 48, 53, 102, 53, 54, 99, 98, 53, 49, 102, 101, 57, 102, 54, 56, 101, 50, 99, 54, 48, 49, 55, 99, 99, 100, 102, 56, 49, 101, 48, 0,
            2, 0, 0, 0, 0};
        ByteBuf buf = Unpooled.buffer();
        buf.writeBytes(b1);

        channel.writeInbound(buf);
        channel.finish();

        ByteBuf output = (ByteBuf) channel.readOutbound();
        byte[] result = new byte[output.readableBytes()];
        output.readBytes(result);
        int a = bytesToInt(ArrayUtils.subarray(result, 33, 38));
        int b2 = bytesToInt(new byte[]{81, -61, 0, 0});
        System.out.println(b2 + "....." + a);
        Assert.assertEquals(b2, a);
    }

    /* 2  serverid = 137
     * md5验证成功,服务器状态(表:game_server ,字段:server_status=1)正常, 注册成功:返回code=1
     */
    @Test
    public void test_serverstatus_1() {
        byte[] b1 = new byte[]{89, 0, 0, 0, 1, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 64, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 16, 0, 0,
            2, 1, 0, 0, 0,
            2, -119, 0, 0, 0,
            4, 83, 75, 89, 95, 83, 69, 82, 86, 69, 82, 0,
            4, 53, 51, 48, 53, 102, 53, 54, 99, 98, 53, 49, 102, 101, 57, 102, 54, 56, 101, 50, 99, 54, 48, 49, 55, 99, 99, 100, 102, 56, 49, 101, 48, 0,
            2, 0, 0, 0, 0};
        ByteBuf buf = Unpooled.buffer();
        buf.writeBytes(b1);

        channel.writeInbound(buf);
        channel.finish();

        ByteBuf output = (ByteBuf) channel.readOutbound();
        byte[] result = new byte[output.readableBytes()];
        output.readBytes(result);
        int a = bytesToInt(ArrayUtils.subarray(result, 33, 38));
        System.out.println(Arrays.toString(ArrayUtils.subarray(result, 33, 38)));
        int b2 = bytesToInt(new byte[]{1, 0, 0, 0});
        System.out.println(b2 + "....." + a);
        Assert.assertEquals(b2, a);
    }

    /* 3  serverid = 138
     * md5验证成功,服务器状态(表:game_server ,字段:server_status=2)关闭（服务器下线）, 注册失败:返回code=50002
     */
    @Test
    public void test_serverstatus_2() {
        byte[] b1 = new byte[]{89, 0, 0, 0, 1, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 64, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 16, 0, 0,
            2, 1, 0, 0, 0,
            2, -118, 0, 0, 0,
            4, 83, 75, 89, 95, 83, 69, 82, 86, 69, 82, 0,
            4, 98, 52, 48, 101, 50, 53, 51, 97, 101, 102, 101, 101, 54, 54, 52, 99, 50, 52, 56, 97, 98, 99, 53, 97, 101, 97, 54, 52, 50, 49, 55, 99, 0,
            2, 0, 0, 0, 0};
        ByteBuf buf = Unpooled.buffer();
        buf.writeBytes(b1);

        channel.writeInbound(buf);
        channel.finish();

        ByteBuf output = (ByteBuf) channel.readOutbound();
        byte[] result = new byte[output.readableBytes()];
        output.readBytes(result);
        int a = bytesToInt(ArrayUtils.subarray(result, 33, 38));
        System.out.println(Arrays.toString(ArrayUtils.subarray(result, 33, 38)));
        int b2 = bytesToInt(new byte[]{82, -61, 0, 0});
        System.out.println(b2 + "....." + a);
        Assert.assertEquals(b2, a);
    }

    /* 4  serverid = 139
     * md5验证成功,服务器状态(表:game_server ,字段:server_status=3)冻结（官方暂时冻结）, 注册失败:返回code=1000(log_code:5007)
     */
    @Test
    public void test_serverstatus_3() {
        byte[] b1 = new byte[]{89, 0, 0, 0, 1, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 64, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 16, 0, 0,
            2, 1, 0, 0, 0,
            2, -117, 0, 0, 0,
            4, 83, 75, 89, 95, 83, 69, 82, 86, 69, 82, 0,
            4, 98, 55, 97, 55, 54, 51, 97, 54, 49, 51, 98, 57, 100, 50, 49, 56, 99, 99, 55, 102, 97, 51, 51, 101, 53, 54, 98, 50, 98, 54, 98, 57, 0,
            2, 0, 0, 0, 0};
        ByteBuf buf = Unpooled.buffer();
        buf.writeBytes(b1);

        channel.writeInbound(buf);
        channel.finish();

        ByteBuf output = (ByteBuf) channel.readOutbound();
        byte[] result = new byte[output.readableBytes()];
        output.readBytes(result);
        int a = bytesToInt(ArrayUtils.subarray(result, 33, 38));
        System.out.println(Arrays.toString(ArrayUtils.subarray(result, 33, 38)));
        int b2 = bytesToInt(new byte[]{-24, 3, 0, 0});
        System.out.println(b2 + "....." + a);
        Assert.assertEquals(b2, a);
    }

    /* 5  serverid = 140
     * md5验证成功,服务器状态(表:game_server ,字段:server_status=4)维护中, 注册失败:返回code=1000(log_code:5005)
     */
    @Test
    public void test_serverstatus_4() {
        byte[] b1 = new byte[]{89, 0, 0, 0, 1, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 64, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 16, 0, 0,
            2, 1, 0, 0, 0,
            2, -116, 0, 0, 0,
            4, 83, 75, 89, 95, 83, 69, 82, 86, 69, 82, 0,
            4, 54, 54, 49, 55, 51, 55, 52, 102, 52, 102, 51, 52, 50, 99, 54, 51, 97, 53, 98, 98, 101, 102, 99, 99, 98, 48, 49, 102, 54, 56, 51, 53, 0,
            2, 0, 0, 0, 0};
        ByteBuf buf = Unpooled.buffer();
        buf.writeBytes(b1);

        channel.writeInbound(buf);
        channel.finish();

        ByteBuf output = (ByteBuf) channel.readOutbound();
        byte[] result = new byte[output.readableBytes()];
        output.readBytes(result);
        int a = bytesToInt(ArrayUtils.subarray(result, 33, 38));
        System.out.println(Arrays.toString(ArrayUtils.subarray(result, 33, 38)));
        int b2 = bytesToInt(new byte[]{-24, 3, 0, 0});
        System.out.println(b2 + "....." + a);
        Assert.assertEquals(b2, a);
    }

    /* 6  serverid = 141
     * md5验证成功,服务器状态(表:game_server ,字段:server_status=5)合服, 注册失败:返回code=1000(log_code-50006)
     */
    @Test
    public void test_serverstatus_5() {
        byte[] b1 = new byte[]{89, 0, 0, 0, 1, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 64, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 16, 0, 0,
            2, 1, 0, 0, 0,
            2, -115, 0, 0, 0,
            4, 83, 75, 89, 95, 83, 69, 82, 86, 69, 82, 0,
            4, 53, 99, 56, 55, 48, 50, 54, 102, 51, 53, 54, 101, 100, 98, 49, 51, 49, 99, 99, 102, 102, 50, 98, 49, 99, 50, 97, 99, 49, 57, 52, 55, 0,
            2, 0, 0, 0, 0};
        ByteBuf buf = Unpooled.buffer();
        buf.writeBytes(b1);

        channel.writeInbound(buf);
        channel.finish();

        ByteBuf output = (ByteBuf) channel.readOutbound();
        byte[] result = new byte[output.readableBytes()];
        output.readBytes(result);
        int a = bytesToInt(ArrayUtils.subarray(result, 33, 38));
        System.out.println(Arrays.toString(ArrayUtils.subarray(result, 33, 38)));
        int b2 = bytesToInt(new byte[]{-24, 3, 0, 0});
        System.out.println(b2 + "....." + a);
        Assert.assertEquals(b2, a);
    }

    /* 7  serverid = 142  
     * md5验证成功,服务器状态(表:game_server ,字段:server_status=9)删除, 注册失败:返回code=1000(log_code-50008)
     */
    @Test
    public void test_serverstatus_9() {
        byte[] b1 = new byte[]{89, 0, 0, 0, 1, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 64, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 16, 0, 0,
            2, 1, 0, 0, 0,
            2, -114, 0, 0, 0,
            4, 83, 75, 89, 95, 83, 69, 82, 86, 69, 82, 0,
            4, 99, 53, 57, 97, 57, 52, 50, 54, 52, 51, 101, 48, 98, 55, 49, 52, 100, 97, 98, 53, 50, 55, 57, 57, 56, 52, 97, 53, 98, 97, 50, 56, 0,
            2, 0, 0, 0, 0};
        ByteBuf buf = Unpooled.buffer();
        buf.writeBytes(b1);

        channel.writeInbound(buf);
        channel.finish();

        ByteBuf output = (ByteBuf) channel.readOutbound();
        byte[] result = new byte[output.readableBytes()];
        output.readBytes(result);
        int a = bytesToInt(ArrayUtils.subarray(result, 33, 38));
        System.out.println(Arrays.toString(ArrayUtils.subarray(result, 33, 38)));
        int b2 = bytesToInt(new byte[]{-24, 3, 0, 0});
        System.out.println(b2 + "....." + a);
        Assert.assertEquals(b2, a);
    }
}
