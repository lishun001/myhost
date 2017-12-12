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
public class LogoutTester {

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
     * 登出测试 测试每条数据要对应相关参数
     *
     * @param bytes
     * @return
     */
    /* 17 passport_name = test041
     * 登陆sessin验证失败, 返回code=0
     */
    @Test
    public void test_nosession() {
        byte[] b1 = new byte[]{115, 0, 0, 0, 1, 3, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 32, 0, 0,
            2, 1, 0, 0, 0,
            4, 84, 78, 112, 113, 78, 103, 74, 105, 87, 102, 49, 83, 88, 65, 117, 90, 66, 111, 115, 105, 86, 57, 70, 67, 107, 48, 70, 102, 74, 98, 116, 51, 0,
            2, 2, 0, 0, 0,
            4, 116, 101, 115, 116, 48, 52, 49, 0,
            4, 101, 49, 48, 97, 100, 99, 51, 57, 52, 57, 98, 97, 53, 57, 97, 98, 98, 101, 53, 54, 101, 48, 53, 55, 102, 50, 48, 102, 56, 56, 51, 101, 0};
        ByteBuf buf = Unpooled.buffer();
        buf.writeBytes(b1);

        channel.writeInbound(buf);
        channel.finish();

        ByteBuf output = (ByteBuf) channel.readOutbound();
        byte[] result = new byte[output.readableBytes()];
        output.readBytes(result);
        System.out.println(Arrays.toString(result));
        int a = bytesToInt(ArrayUtils.subarray(result, 38, 43));
        System.out.println(Arrays.toString(ArrayUtils.subarray(result, 38, 43)));
        int b2 = bytesToInt(new byte[]{0, 0, 0, 0});
        System.out.println(b2 + "....." + a);
        Assert.assertEquals(b2, a);
    }

    /* 18  passport_name = test041
     * 4, 65, 56, 104, 103, 89, 88,...---->数据库session-key数组
     *  2, 1, 0, 0, 0, ------>2, 50, 0, 0, 0,
     * 无对应账号,返回code=51001
     */
    @Test
    public void test_notaccountid() {
        byte[] b1 = new byte[]{115, 0, 0, 0, 1, 3, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 32, 0, 0,
            2, 50, 0, 0, 0,
            4, 70, 115, 73, 82, 104, 117, 98, 107, 121, 117, 70, 107, 49, 49, 116, 106, 98, 118, 57, 70, 56, 111, 110, 116, 121, 80, 117, 78, 99, 65, 79, 76, 0,
            2, 2, 0, 0, 0,
            4, 116, 101, 115, 116, 48, 52, 49, 0,
            4, 101, 49, 48, 97, 100, 99, 51, 57, 52, 57, 98, 97, 53, 57, 97, 98, 98, 101, 53, 54, 101, 48, 53, 55, 102, 50, 48, 102, 56, 56, 51, 101, 0};
        ByteBuf buf = Unpooled.buffer();
        buf.writeBytes(b1);

        channel.writeInbound(buf);
        channel.finish();

        ByteBuf output = (ByteBuf) channel.readOutbound();
        byte[] result = new byte[output.readableBytes()];
        output.readBytes(result);
        System.out.println(Arrays.toString(result));
        int a = bytesToInt(ArrayUtils.subarray(result, 38, 43));
        System.out.println(Arrays.toString(ArrayUtils.subarray(result, 38, 43)));
        int b2 = bytesToInt(new byte[]{57, -57, 0, 0});
        System.out.println(b2 + "....." + a);
        Assert.assertEquals(b2, a);
    }

    /*   -----------------------------单独测--------------------------------
     * 19  取对应的session值 
     * 登出成功code=1
     */
    //@Test
    public void test_loginoutsuccess() {
        byte[] b1 = new byte[]{115, 0, 0, 0, 1, 3, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 32, 0, 0,
            2, -50, 11, 0, 0,
            4, 106, 84, 69, 107, 106, 105, 113, 102, 108, 102, 116, 115, 101, 97, 109, 76, 77, 109, 87, 105, 115, 110, 99, 81, 87, 49, 106, 52, 84, 81, 121, 53, 0,
            2, 2, 0, 0, 0,
            4, 116, 101, 115, 116, 48, 55, 50, 0,
            4, 101, 49, 48, 97, 100, 99, 51, 57, 52, 57, 98, 97, 53, 57, 97, 98, 98, 101, 53, 54, 101, 48, 53, 55, 102, 50, 48, 102, 56, 56, 51, 101, 0};
        ByteBuf buf = Unpooled.buffer();
        buf.writeBytes(b1);

        channel.writeInbound(buf);
        channel.finish();

        ByteBuf output = (ByteBuf) channel.readOutbound();
        byte[] result = new byte[output.readableBytes()];
        output.readBytes(result);
        System.out.println(Arrays.toString(result));
        int a = bytesToInt(ArrayUtils.subarray(result, 38, 43));
        System.out.println(Arrays.toString(ArrayUtils.subarray(result, 38, 43)));
        int b2 = bytesToInt(new byte[]{1, 0, 0, 0});
        System.out.println(b2 + "....." + a);
        Assert.assertEquals(b2, a);
    }
}
