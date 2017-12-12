/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rs.ocp.msg;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.embedded.EmbeddedChannel;
import java.util.Arrays;
import org.apache.commons.lang.ArrayUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author zhaoweixing
 */
public class MultiHandlerTester {

    EmbeddedChannel channel;

    @Before
    public void init() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:META-INF/spring/applicationContext.xml");
        channel = (EmbeddedChannel) ctx.getBean("embeddedchannel");
    }

    @Test
    public void testRegisterServer() {
        //注册服务器
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
        byte[] b = new byte[]{33, 0, 0, 0, 1, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 64, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 16, 0, 0, 2, 1, 0, 0, 0};
        Assert.assertEquals(Arrays.toString(result), Arrays.toString(b));
    }
    
    @Test
    public void testLogin() {
        //登陆
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
        byte[] resultFinal = ArrayUtils.subarray(result, 47, 51);
        byte[] b = new byte[]{ 1, 0, 0, 0};
        Assert.assertEquals(Arrays.toString(resultFinal), Arrays.toString(b));
    }
}
