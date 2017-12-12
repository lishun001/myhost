/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rs.ocp.msg;

import static com.rs.ocp.msg.LoginTester.bytesToInt;
import com.rs.ocp.service.utils.Commons;
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
 * @author wangxinming
 */
public class DeductQointTest {

    EmbeddedChannel channel;

    @Before
    public void init() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:META-INF/spring/applicationContext.xml");
        channel = (EmbeddedChannel) ctx.getBean("embeddedchannel");
    }

//    CHA_FORW_RENEW = 0x2004,			// 更新帐户(游戏服务器发)（扣点,每隔60秒发一次）
//	Data:
//		accid			TYPE_INT	account id
//		logon_id 		TYPE_STRING 	登录成功后的session
//		gmlevel 		TYPE_INT 	gm等级
//		chargeinfo		TYPE_STRING    	计费信息（空）
//
//CHA_BACK_RENEW = 0x2005,			// 更新帐户(计费返回)
//	Data:
//		accid			TYPE_INT	account id
//		awake 			TYPE_INT		
//		points 			TYPE_INT 	游戏点数
//		limit 			TYPE_DOUBLE 	到期日期(暂未处理)
//（awake =1，表明点数即将用完，points为剩余点数）
//（awake =2，点数已经用完，直接断开客户端）
//（awake =3，帐号为防沉迷帐号，points为防沉迷累积秒数）
//（awake >3，扣款成功
    @Test
    public void testDeductQointSessionKey() {
        //26	sessionKey验证，不通过返回awake=0，points=0
        //测试所用sessionkey=eGZETGrqq3glTrtABxWI2RJAABUbk4vj
        byte[] b26 = new byte[]{81, 0, 0, 0, 45, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 32, 0, 0,
            2, 11, 0, 0, 0,
            4, 101, 71, 90, 69, 84, 7, 114, 113, 113, 51, 103, 108, 84, 114, 116, 65, 66, 120, 87, 73, 50, 82, 74, 65, 65, 66, 85, 98, 107, 52, 118, 106, 0,
            2, 2, 0, 0, 0,
            4, 97, 97, 97, 97, 0};
        ByteBuf buf = Unpooled.buffer();
        buf.writeBytes(b26);

        channel.writeInbound(buf);
        channel.finish();

        ByteBuf output = (ByteBuf) channel.readOutbound();
        byte[] result = new byte[output.readableBytes()];
        output.readBytes(result);
        System.out.println(Arrays.toString(result));
        byte[] b26_byt = new byte[]{52, 0, 0, 0, 45, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 32, 0, 0,
            2, 11, 0, 0, 0, //account_id
            2, 0, 0, 0, 0, //awake
            2, 0, 0, 0, 0, //points
            7, 64, 55, 2, -113, 92, 40, -11, -61};      //limit
        Assert.assertEquals(0, bytesToInt(ArrayUtils.subarray(result, 38, 42)));
        Assert.assertEquals(0, bytesToInt(ArrayUtils.subarray(result, 43, 47)));
    }

    //账户不存在account_pid=5874---->333  passport_name=test054
    @Test
    public void testDeductQointAccountNoExist() {
        //27	账户不存在(账户表:acc_account ), 返回awake=0，points=0
        //测试所用账号id=5874  前提:session表中存在sessionkey=DQKidoEyrA9YPtdKtOKiF15YvQpd8yId
        byte[] b27 = new byte[]{81, 0, 0, 0, 45, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 32, 0, 0,
            2, -14, 22, 0, 0,
            4, 68, 81, 75, 105, 100, 111, 69, 121, 114, 65, 57, 89, 80, 116, 100, 75, 116, 79, 75, 105, 70, 49, 53, 89, 118, 81, 112, 100, 56, 121, 73, 100, 0,
            2, 2, 0, 0, 0,
            4, 97, 97, 97, 97, 0};
        ByteBuf buf = Unpooled.buffer();
        buf.writeBytes(b27);

        channel.writeInbound(buf);
        channel.finish();

        ByteBuf output = (ByteBuf) channel.readOutbound();
        byte[] result = new byte[output.readableBytes()];
        output.readBytes(result);
        System.out.println(Arrays.toString(result));
        Assert.assertEquals(0, bytesToInt(ArrayUtils.subarray(result, 38, 42)));
        Assert.assertEquals(0, bytesToInt(ArrayUtils.subarray(result, 43, 47)));
    }

    //账户存在 passport_name=test055
    @Test
    public void testDeductQointAccountStatus_2() {
        //28	账户存在,账户状态(account_status):2-锁定,返回awake=0，points=0
        //测试所用账户id=3001  前提:session表中存在sessionkey=JSC2QJT8FuoDtneYsFpC6emocWv88Bus
        byte[] b28 = new byte[]{81, 0, 0, 0, 45, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 32, 0, 0,
            2, -71, 11, 0, 0,
            4, 74, 83, 67, 50, 81, 74, 84, 56, 70, 117, 111, 68, 116, 110, 101, 89, 115, 70, 112, 67, 54, 101, 109, 111, 99, 87, 118, 56, 56, 66, 117, 115, 0,
            2, 2, 0, 0, 0,
            4, 97, 97, 97, 97, 0};
        ByteBuf buf = Unpooled.buffer();
        buf.writeBytes(b28);

        channel.writeInbound(buf);
        channel.finish();

        ByteBuf output = (ByteBuf) channel.readOutbound();
        byte[] result = new byte[output.readableBytes()];
        output.readBytes(result);
        Assert.assertEquals(0, bytesToInt(ArrayUtils.subarray(result, 38, 42)));
        Assert.assertEquals(0, bytesToInt(ArrayUtils.subarray(result, 43, 47)));
    }

    //账户存在 passport_name=test056
    @Test
    public void testDeductQointAccountStatus_3() {
        //29	账户存在,账户状态(account_status):3-冻结,返回awake=0，points=0
        //测试所用账户id=3002  前提:session表中存在sessionkey=hmNZZQN1VusQVP54J4mhninRaYeIk0dB
        byte[] b29 = new byte[]{81, 0, 0, 0, 45, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 32, 0, 0,
            2, -70, 11, 0, 0,
            4, 104, 109, 78, 90, 90, 81, 78, 49, 86, 117, 115, 81, 86, 80, 53, 52, 74, 52, 109, 104, 110, 105, 110, 82, 97, 89, 101, 73, 107, 48, 100, 66, 0,
            2, 2, 0, 0, 0,
            4, 97, 97, 97, 97, 0};
        ByteBuf buf = Unpooled.buffer();
        buf.writeBytes(b29);

        channel.writeInbound(buf);
        channel.finish();

        ByteBuf output = (ByteBuf) channel.readOutbound();
        byte[] result = new byte[output.readableBytes()];
        output.readBytes(result);
        Assert.assertEquals(0, bytesToInt(ArrayUtils.subarray(result, 38, 42)));
        Assert.assertEquals(0, bytesToInt(ArrayUtils.subarray(result, 43, 47)));
    }

    //账户存在 passport_name=test057
    @Test
    public void testDeductQointAccountStatus_4() {
        //30	账户存在,账户状态(account_status):4-停封,返回awake=0，points=0
        //测试所用账户id=3003  前提:session表中存在sessionkey=tCeev1BD4nOyelZq44BZdEmCJWeM8EM3
        byte[] b30 = new byte[]{81, 0, 0, 0, 45, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 32, 0, 0,
            2, -69, 11, 0, 0,
            4, 116, 67, 101, 101, 118, 49, 66, 68, 52, 110, 79, 121, 101, 108, 90, 113, 52, 52, 66, 90, 100, 69, 109, 67, 74, 87, 101, 77, 56, 69, 77, 51, 0,
            2, 2, 0, 0, 0,
            4, 97, 97, 97, 97, 0};
        ByteBuf buf = Unpooled.buffer();
        buf.writeBytes(b30);

        channel.writeInbound(buf);
        channel.finish();

        ByteBuf output = (ByteBuf) channel.readOutbound();
        byte[] result = new byte[output.readableBytes()];
        output.readBytes(result);
        Assert.assertEquals(0, bytesToInt(ArrayUtils.subarray(result, 38, 42)));
        Assert.assertEquals(0, bytesToInt(ArrayUtils.subarray(result, 43, 47)));
    }

    //账户存在 passport_name=test058
    @Test
    public void testDeductQointAccountStatus_9() {
        //31	账户存在,账户状态(account_status):9-删除,返回awake=0，points=0
        //测试所用账户id=3004  前提:session表中存在sessionkey=T69mC3zupuXR3ItFvJNTo3KyeHLOHv8i
        byte[] b31 = new byte[]{81, 0, 0, 0, 45, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 32, 0, 0,
            2, -68, 11, 0, 0,
            4, 84, 54, 57, 109, 67, 51, 122, 117, 112, 117, 88, 82, 51, 73, 116, 70, 118, 74, 78, 84, 111, 51, 75, 121, 101, 72, 76, 79, 72, 118, 56, 105, 0,
            2, 2, 0, 0, 0,
            4, 97, 97, 97, 97, 0};
        ByteBuf buf = Unpooled.buffer();
        buf.writeBytes(b31);

        channel.writeInbound(buf);
        channel.finish();

        ByteBuf output = (ByteBuf) channel.readOutbound();
        byte[] result = new byte[output.readableBytes()];
        output.readBytes(result);
        Assert.assertEquals(0, bytesToInt(ArrayUtils.subarray(result, 38, 42)));
        Assert.assertEquals(0, bytesToInt(ArrayUtils.subarray(result, 43, 47)));
    }

    //账号不存在 passport_name=test059 返回code=51001  id = 4000----->6000
    @Test
    public void testDeductQointPassportNoExist() {
        //32	账号不存在, 返回awake=0，points=0
        //测试所用账号id=4000  前提:session表中存在sessionkey=D4V0onwj42KEdZnB22QTaSyuDbvFtKVE
        byte[] b32 = new byte[]{81, 0, 0, 0, 45, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 32, 0, 0,
            2, -96, 15, 0, 0,
            4, 68, 52, 86, 48, 111, 110, 119, 106, 52, 50, 75, 69, 100, 90, 110, 66, 50, 50, 81, 84, 97, 83, 121, 117, 68, 98, 118, 70, 116, 75, 86, 69, 0,
            2, 2, 0, 0, 0,
            4, 97, 97, 97, 97, 0};
        ByteBuf buf = Unpooled.buffer();
        buf.writeBytes(b32);

        channel.writeInbound(buf);
        channel.finish();

        ByteBuf output = (ByteBuf) channel.readOutbound();
        byte[] result = new byte[output.readableBytes()];
        output.readBytes(result);
        Assert.assertEquals(0, bytesToInt(ArrayUtils.subarray(result, 38, 42)));
        Assert.assertEquals(0, bytesToInt(ArrayUtils.subarray(result, 43, 47)));
    }

    //账户,账号存在,账号状态(账号表,字段:passport_status):2 passport_name=test060
    @Test
    public void testDeductQointPassportStatus_2() {
        //33	账户,账号存在,账号状态(账号表,字段:passport_status):2 - 锁定,返回awake=0，points=0
        //测试所用账号id=3010  前提:session表中存在sessionkey=owpJ5w7XuAqIORAqMZnIZLv49pWlnyTJ
        byte[] b33 = new byte[]{81, 0, 0, 0, 45, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 32, 0, 0,
            2, -62, 11, 0, 0,
            4, 111, 119, 112, 74, 53, 119, 55, 88, 117, 65, 113, 73, 79, 82, 65, 113, 77, 90, 110, 73, 90, 76, 118, 52, 57, 112, 87, 108, 110, 121, 84, 74, 0,
            2, 2, 0, 0, 0,
            4, 97, 97, 97, 97, 0};
        ByteBuf buf = Unpooled.buffer();
        buf.writeBytes(b33);

        channel.writeInbound(buf);
        channel.finish();

        ByteBuf output = (ByteBuf) channel.readOutbound();
        byte[] result = new byte[output.readableBytes()];
        output.readBytes(result);
        Assert.assertEquals(0, bytesToInt(ArrayUtils.subarray(result, 38, 42)));
        Assert.assertEquals(0, bytesToInt(ArrayUtils.subarray(result, 43, 47)));
    }

    //账户,账号存在,账号状态(账号表,字段:passport_status):3 passport_name=test061
    @Test
    public void testDeductQointPassportStatus_3() {
        //34	账户,账号存在,账号状态(账号表,字段:passport_status):3 - 冻结,返回awake=0，points=0
        //测试所用账号id=3011  前提:session表中存在sessionkey=tUfgDKcwYnmH7tiDIksAyr2uxXXDbKXm
        byte[] b34 = new byte[]{81, 0, 0, 0, 45, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 32, 0, 0,
            2, -61, 11, 0, 0,
            4, 116, 85, 102, 103, 68, 75, 99, 119, 89, 110, 109, 72, 55, 116, 105, 68, 73, 107, 115, 65, 121, 114, 50, 117, 120, 88, 88, 68, 98, 75, 88, 109, 0,
            2, 2, 0, 0, 0,
            4, 97, 97, 97, 97, 0};
        ByteBuf buf = Unpooled.buffer();
        buf.writeBytes(b34);

        channel.writeInbound(buf);
        channel.finish();

        ByteBuf output = (ByteBuf) channel.readOutbound();
        byte[] result = new byte[output.readableBytes()];
        output.readBytes(result);
        Assert.assertEquals(0, bytesToInt(ArrayUtils.subarray(result, 38, 42)));
        Assert.assertEquals(0, bytesToInt(ArrayUtils.subarray(result, 43, 47)));
    }

    //账户,账号存在,账号状态(账号表,字段:passport_status):4  passport_name=test062
    @Test
    public void testDeductQointPassportStatus_4() {
        //35	账户,账号存在,账号状态(账号表,字段:passport_status):4 - 停封,返返回awake=0，points=0
        //测试所用账号id=3012  前提:session表中存在sessionkey=vfuCvxJYPnAWRVhbeCElsqRTBG62jdmt
        byte[] b35 = new byte[]{81, 0, 0, 0, 45, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 32, 0, 0,
            2, -60, 11, 0, 0,
            4, 118, 102, 117, 67, 118, 120, 74, 89, 80, 110, 65, 87, 82, 86, 104, 98, 101, 67, 69, 108, 115, 113, 82, 84, 66, 71, 54, 50, 106, 100, 109, 116, 0,
            2, 2, 0, 0, 0,
            4, 97, 97, 97, 97, 0};
        ByteBuf buf = Unpooled.buffer();
        buf.writeBytes(b35);

        channel.writeInbound(buf);
        channel.finish();

        ByteBuf output = (ByteBuf) channel.readOutbound();
        byte[] result = new byte[output.readableBytes()];
        output.readBytes(result);
        Assert.assertEquals(0, bytesToInt(ArrayUtils.subarray(result, 38, 42)));
        Assert.assertEquals(0, bytesToInt(ArrayUtils.subarray(result, 43, 47)));
    }

    //账户,账号存在,账号状态(账号表,字段:passport_status):9  passport_name=test063
    @Test
    public void testDeductQointPassportStatus_9() {
        //36	账户,账号存在,账号状态(账号表,字段:passport_status):9 - 删除,返回awake=0，points=0
        //测试所用账号id=3013  前提:session表中存在sessionkey=aLkDNu9MF7q29dUbFoh9mxgw7oeuQzDo
        byte[] b36 = new byte[]{81, 0, 0, 0, 45, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 32, 0, 0,
            2, -59, 11, 0, 0,
            4, 97, 76, 107, 68, 78, 117, 57, 77, 70, 55, 113, 50, 57, 100, 85, 98, 70, 111, 104, 57, 109, 120, 103, 119, 55, 111, 101, 117, 81, 122, 68, 111, 0,
            2, 2, 0, 0, 0,
            4, 97, 97, 97, 97, 0};
        ByteBuf buf = Unpooled.buffer();
        buf.writeBytes(b36);

        channel.writeInbound(buf);
        channel.finish();

        ByteBuf output = (ByteBuf) channel.readOutbound();
        byte[] result = new byte[output.readableBytes()];
        output.readBytes(result);
        Assert.assertEquals(0, bytesToInt(ArrayUtils.subarray(result, 38, 42)));
        Assert.assertEquals(0, bytesToInt(ArrayUtils.subarray(result, 43, 47)));
    }

    //获取防沉迷数据失败  passport_name=test068
    @Test
    public void testDeductQointPpFcmTotaltime() {
        //42    获取防沉迷数据失败，返回awake=0，points=0
        //测试所用账号id=3018  前提:session表中存在sessionkey=gLiCuTIxS4p1XafqFOSt3HFmDrAOKXSG
        byte[] b43 = new byte[]{81, 0, 0, 0, 45, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 32, 0, 0,
            2, -54, 11, 0, 0,
            4, 103, 76, 105, 67, 117, 84, 73, 120, 83, 52, 112, 49, 88, 97, 102, 113, 70, 79, 83, 116, 51, 72, 70, 109, 68, 114, 65, 79, 75, 88, 83, 71, 0,
            2, 2, 0, 0, 0,
            4, 97, 97, 97, 97, 0};
        ByteBuf buf = Unpooled.buffer();
        buf.writeBytes(b43);

        channel.writeInbound(buf);
        channel.finish();

        ByteBuf output = (ByteBuf) channel.readOutbound();
        byte[] result = new byte[output.readableBytes()];
        output.readBytes(result);
        System.out.println(Arrays.toString(result));
        Assert.assertEquals(0, bytesToInt(ArrayUtils.subarray(result, 38, 42)));
        Assert.assertEquals(0, bytesToInt(ArrayUtils.subarray(result, 43, 47)));
    }

    /*-------------------------------单独测------------------------------------
     * 需单独测试
     */
    //@Test
    public void testDeductQointServerStatus_2() {
        //37	服务器状态(表:game_server ,字段:server_status=2)关闭（服务器下线）, 返回awake=0，points=0
        //测试所用账号id=3014  前提:session表中存在sessionkey=bHiFXpwdmNEupvsQWmcJmVITyDb9zFIy
        byte[] b38 = new byte[]{81, 0, 0, 0, 45, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 32, 0, 0,
            2, -58, 11, 0, 0,
            4, 98, 72, 105, 70, 88, 112, 119, 100, 109, 78, 69, 117, 112, 118, 115, 81, 87, 109, 99, 74, 109, 86, 73, 84, 121, 68, 98, 57, 122, 70, 73, 121, 0,
            2, 2, 0, 0, 0,
            4, 97, 97, 97, 97, 0};
        ByteBuf buf = Unpooled.buffer();
        buf.writeBytes(b38);

        channel.writeInbound(buf);
        channel.finish();

        ByteBuf output = (ByteBuf) channel.readOutbound();
        byte[] result = new byte[output.readableBytes()];
        output.readBytes(result);
        System.out.println(Arrays.toString(result));
        Assert.assertEquals(0, bytesToInt(ArrayUtils.subarray(result, 38, 42)));
        Assert.assertEquals(0, bytesToInt(ArrayUtils.subarray(result, 43, 47)));
    }

    //@Test
    public void testDeductQointServerStatus_3() {
        //38	服务器状态(表:game_server ,字段:server_status=3)冻结（官方暂时冻结）, 返回awake=0，points=0
        //测试所用账号id=3014  前提:session表中存在sessionkey=bHiFXpwdmNEupvsQWmcJmVITyDb9zFIy
        byte[] b39 = new byte[]{81, 0, 0, 0, 45, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 32, 0, 0,
            2, -58, 11, 0, 0,
            4, 98, 72, 105, 70, 88, 112, 119, 100, 109, 78, 69, 117, 112, 118, 115, 81, 87, 109, 99, 74, 109, 86, 73, 84, 121, 68, 98, 57, 122, 70, 73, 121, 0,
            2, 2, 0, 0, 0,
            4, 97, 97, 97, 97, 0};
        ByteBuf buf = Unpooled.buffer();
        buf.writeBytes(b39);

        channel.writeInbound(buf);
        channel.finish();

        ByteBuf output = (ByteBuf) channel.readOutbound();
        byte[] result = new byte[output.readableBytes()];
        output.readBytes(result);
        Assert.assertEquals(0, bytesToInt(ArrayUtils.subarray(result, 38, 42)));
        Assert.assertEquals(0, bytesToInt(ArrayUtils.subarray(result, 43, 47)));
    }

    //@Test
    public void testDeductQointServerStatus_4() {
        //39	服务器状态(表:game_server ,字段:server_status=4)维护中, 返回awake=0，points=0
        //测试所用账号id=3014  前提:session表中存在sessionkey=bHiFXpwdmNEupvsQWmcJmVITyDb9zFIy
        byte[] b40 = new byte[]{81, 0, 0, 0, 45, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 32, 0, 0,
            2, -58, 11, 0, 0,
            4, 98, 72, 105, 70, 88, 112, 119, 100, 109, 78, 69, 117, 112, 118, 115, 81, 87, 109, 99, 74, 109, 86, 73, 84, 121, 68, 98, 57, 122, 70, 73, 121, 0,
            2, 2, 0, 0, 0,
            4, 97, 97, 97, 97, 0};
        ByteBuf buf = Unpooled.buffer();
        buf.writeBytes(b40);

        channel.writeInbound(buf);
        channel.finish();

        ByteBuf output = (ByteBuf) channel.readOutbound();
        byte[] result = new byte[output.readableBytes()];
        output.readBytes(result);
        Assert.assertEquals(0, bytesToInt(ArrayUtils.subarray(result, 38, 42)));
        Assert.assertEquals(0, bytesToInt(ArrayUtils.subarray(result, 43, 47)));
    }

    //@Test
    public void testDeductQointServerStatus_5() {
        //40	服务器状态(表:game_server ,字段:server_status=5)合服, 返回awake=0，points=0
        //测试所用账号id=3014  前提:session表中存在sessionkey=bHiFXpwdmNEupvsQWmcJmVITyDb9zFIy
        byte[] b41 = new byte[]{81, 0, 0, 0, 45, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 32, 0, 0,
            2, -58, 11, 0, 0,
            4, 98, 72, 105, 70, 88, 112, 119, 100, 109, 78, 69, 117, 112, 118, 115, 81, 87, 109, 99, 74, 109, 86, 73, 84, 121, 68, 98, 57, 122, 70, 73, 121, 0,
            2, 2, 0, 0, 0,
            2, 2, 0, 0, 0,
            4, 97, 97, 97, 97, 0};
        ByteBuf buf = Unpooled.buffer();
        buf.writeBytes(b41);

        channel.writeInbound(buf);
        channel.finish();

        ByteBuf output = (ByteBuf) channel.readOutbound();
        byte[] result = new byte[output.readableBytes()];
        output.readBytes(result);
        Assert.assertEquals(0, bytesToInt(ArrayUtils.subarray(result, 38, 42)));
        Assert.assertEquals(0, bytesToInt(ArrayUtils.subarray(result, 43, 47)));
    }

    //@Test
    public void testDeductQointServerStatus_9() {
        //41	服务器状态(表:game_server ,字段:server_status=9)删除, 返回awake=0，points=0
        //测试所用账号id=3014  前提:session表中存在sessionkey=bHiFXpwdmNEupvsQWmcJmVITyDb9zFIy
        byte[] b42 = new byte[]{81, 0, 0, 0, 45, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 32, 0, 0,
            2, -58, 11, 0, 0,
            4, 98, 72, 105, 70, 88, 112, 119, 100, 109, 78, 69, 117, 112, 118, 115, 81, 87, 109, 99, 74, 109, 86, 73, 84, 121, 68, 98, 57, 122, 70, 73, 121, 0,
            2, 2, 0, 0, 0,
            4, 97, 97, 97, 97, 0};
        ByteBuf buf = Unpooled.buffer();
        buf.writeBytes(b42);

        channel.writeInbound(buf);
        channel.finish();

        ByteBuf output = (ByteBuf) channel.readOutbound();
        byte[] result = new byte[output.readableBytes()];
        output.readBytes(result);
        Assert.assertEquals(0, bytesToInt(ArrayUtils.subarray(result, 38, 42)));
        Assert.assertEquals(0, bytesToInt(ArrayUtils.subarray(result, 43, 47)));
    }

    //账户,账号存在,是防沉迷用户,正确返回 防沉迷累计秒数  passport_name=test064  
    //@Test
    public void testDeductQointPpFcmTotaltimeSuccess() {
        //43    账户,账号存在,是防沉迷用户,正确返回，返回awake=3，points=防沉迷累积秒数
        //测试所用账号id=3014  前提:session表中存在sessionkey=2MbuBlrLpmsZbnJJW5b1JemTGjsPKlOo
        byte[] b43 = new byte[]{81, 0, 0, 0, 45, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 32, 0, 0,
            2, -58, 11, 0, 0,
            4, 98, 72, 105, 70, 88, 112, 119, 100, 109, 78, 69, 117, 112, 118, 115, 81, 87, 109, 99, 74, 109, 86, 73, 84, 121, 68, 98, 57, 122, 70, 73, 121, 0,
            2, 2, 0, 0, 0,
            4, 97, 97, 97, 97, 0};
        ByteBuf buf = Unpooled.buffer();
        buf.writeBytes(b43);

        channel.writeInbound(buf);
        channel.finish();
        ByteBuf output = (ByteBuf) channel.readOutbound();
        byte[] result = new byte[output.readableBytes()];
        output.readBytes(result);
        System.out.println(Arrays.toString(result));
        //awake
        int result1 = Commons.bytesToInt(ArrayUtils.subarray(result, 38, 42));
        System.out.println(Arrays.toString(ArrayUtils.subarray(result, 38, 42)));
        //防沉迷累计秒数
        int result2 = Commons.bytesToInt(ArrayUtils.subarray(result, 43, 47));
        System.out.println(Arrays.toString(ArrayUtils.subarray(result, 43, 47)));
        System.out.println(result2);
        Assert.assertEquals(result1, 3);
    }

    //点数余额不足用  test071
    //@Test
    public void test_DeductQointPointEnough() {
        //44    账户,账号存在,是防沉迷用户, 点数余额不足用10点，返回awake=2，points=剩余点数
        //测试所用账号id=3021  前提:session表中存在sessionkey=xYgmn81yOumPXe81ofNnubsgn6iIdOIR
        byte[] b43 = new byte[]{81, 0, 0, 0, 45, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 32, 0, 0,
            2, -51, 11, 0, 0,
            4, 120, 89, 103, 109, 110, 56, 49, 121, 79, 117, 109, 80, 88, 101, 56, 49, 111, 102, 78, 110, 117, 98, 115, 103, 110, 54, 105, 73, 100, 79, 73, 82, 0,
            2, 2, 0, 0, 0,
            4, 97, 97, 97, 97, 0};
        ByteBuf buf = Unpooled.buffer();
        buf.writeBytes(b43);

        channel.writeInbound(buf);
        channel.finish();
        ByteBuf output = (ByteBuf) channel.readOutbound();
        byte[] result = new byte[output.readableBytes()];
        output.readBytes(result);
        System.out.println(Arrays.toString(result));
        //awake
        int result1 = Commons.bytesToInt(ArrayUtils.subarray(result, 38, 42));
        System.out.println(Arrays.toString(ArrayUtils.subarray(result, 38, 42)));
        //剩余点数
        int result2 = Commons.bytesToInt(ArrayUtils.subarray(result, 43, 47));
        System.out.println(Arrays.toString(ArrayUtils.subarray(result, 43, 47)));
        System.out.println(result2);
        Assert.assertEquals(result1, 2);
    }

    //点数即将用完 test072
    //@Test
    public void test_DeductQointPointImmediatelyEnough() {
        //45    账户,账号存在,是防沉迷用户 点数即将用完，返回awake=1，points=剩余点数
        //测试所用账号id=3022  前提:session表中存在sessionkey=CEiKu212sLLUIjpXdIvulCPLIwbxK9m5
        byte[] b46 = new byte[]{81, 0, 0, 0, 45, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 32, 0, 0,
            2, -50, 11, 0, 0,
            4, 106, 84, 69, 107, 106, 105, 113, 102, 108, 102, 116, 115, 101, 97, 109, 76, 77, 109, 87, 105, 115, 110, 99, 81, 87, 49, 106, 52, 84, 81, 121, 53, 0,
            2, 2, 0, 0, 0,
            4, 97, 97, 97, 97, 0};
        ByteBuf buf = Unpooled.buffer();
        buf.writeBytes(b46);

        channel.writeInbound(buf);
        channel.finish();
        ByteBuf output = (ByteBuf) channel.readOutbound();
        byte[] result = new byte[output.readableBytes()];
        output.readBytes(result);
        System.out.println(Arrays.toString(result));
        int result1 = Commons.bytesToInt(ArrayUtils.subarray(result, 38, 42));
        //剩余点数
        int result2 = Commons.bytesToInt(ArrayUtils.subarray(result, 43, 47));
        System.out.println(result1);
        System.out.println(result2);
        Assert.assertEquals(result1, 1);
    }

    //@Test
    public void testDeductQointPointEnough() {
        //46    账户,账号存在,不是防沉迷用户 点数余额不足用，返回awake=2，points=剩余点数
        //测试所用账号id=3015  前提:session表中存在sessionkey=q6ASlyiqHUmIjlmTggVpT1I0U9PXnLGn
        byte[] b45 = new byte[]{81, 0, 0, 0, 45, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 32, 0, 0,
            2, -57, 11, 0, 0,
            4, 113, 54, 65, 83, 108, 121, 105, 113, 72, 85, 109, 73, 106, 108, 109, 84, 103, 103, 86, 112, 84, 49, 73, 48, 85, 57, 80, 88, 110, 76, 71, 110, 0,
            2, 2, 0, 0, 0,
            4, 97, 97, 97, 97, 0};
        ByteBuf buf = Unpooled.buffer();
        buf.writeBytes(b45);

        channel.writeInbound(buf);
        channel.finish();
        ByteBuf output = (ByteBuf) channel.readOutbound();
        byte[] result = new byte[output.readableBytes()];
        output.readBytes(result);
        System.out.println(Arrays.toString(result));
        //awake
        int result1 = Commons.bytesToInt(ArrayUtils.subarray(result, 38, 42));
        System.out.println(Arrays.toString(ArrayUtils.subarray(result, 38, 42)));
        //剩余点数
        int result2 = Commons.bytesToInt(ArrayUtils.subarray(result, 43, 47));
        System.out.println(Arrays.toString(ArrayUtils.subarray(result, 43, 47)));
        System.out.println(result2);
        Assert.assertEquals(result1, 2);
    }

    //账户,账号存在,不是防沉迷用户 点数即将用完 passport_name=test066  
    //@Test
    public void testDeductQointPointImmediatelyEnough() {
        //47    账户,账号存在,不是防沉迷用户 点数即将用完，返回awake=1，points=剩余点数
        //测试所用账号id=3016  前提:session表中存在sessionkey=ERLRw4N05QSDktBBx6tIbaDfnIVJyuEN
        byte[] b46 = new byte[]{81, 0, 0, 0, 45, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 32, 0, 0,
            2, -56, 11, 0, 0,
            4, 69, 82, 76, 82, 119, 52, 78, 48, 53, 81, 83, 68, 107, 116, 66, 66, 120, 54, 116, 73, 98, 97, 68, 102, 110, 73, 86, 74, 121, 117, 69, 78, 0,
            2, 2, 0, 0, 0,
            4, 97, 97, 97, 97, 0};
        ByteBuf buf = Unpooled.buffer();
        buf.writeBytes(b46);

        channel.writeInbound(buf);
        channel.finish();
        ByteBuf output = (ByteBuf) channel.readOutbound();
        byte[] result = new byte[output.readableBytes()];
        output.readBytes(result);
        System.out.println(Arrays.toString(result));
        int result1 = Commons.bytesToInt(ArrayUtils.subarray(result, 38, 42));
        //剩余点数
        int result2 = Commons.bytesToInt(ArrayUtils.subarray(result, 43, 47));
        System.out.println(result1);
        System.out.println(result2);
        Assert.assertEquals(result1, 1);
    }

    //账户,账号存在,不是防沉迷用户 返回剩余点数 passport_name=test067   awake =4
    //@Test
    public void testDeductQointPointSuccess() {
        //48    账户,账号存在,不是防沉迷用户 返回剩余点数，返回awake=4，points=剩余点数
        //测试所用账号id=3017 前提:session表中存在sessionkey=pOrQpJG10uONrafoldq9q8TzooaiYcoY
        byte[] b47 = new byte[]{81, 0, 0, 0, 45, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 32, 0, 0,
            2, -55, 11, 0, 0,
            4, 112, 79, 114, 81, 112, 74, 71, 49, 48, 117, 79, 78, 114, 97, 102, 111, 108, 100, 113, 57, 113, 56, 84, 122, 111, 111, 97, 105, 89, 99, 111, 89, 0,
            2, 2, 0, 0, 0,
            4, 97, 97, 97, 97, 0};
        ByteBuf buf = Unpooled.buffer();
        buf.writeBytes(b47);

        channel.writeInbound(buf);
        channel.finish();
        ByteBuf output = (ByteBuf) channel.readOutbound();
        byte[] result = new byte[output.readableBytes()];
        output.readBytes(result);
        System.out.println(Arrays.toString(result));
        //awake
        int result1 = Commons.bytesToInt(ArrayUtils.subarray(result, 38, 42));
        int result2 = Commons.bytesToInt(ArrayUtils.subarray(result, 43, 47));
        //剩余点数
        System.out.println(Arrays.toString(ArrayUtils.subarray(result, 43, 47)));
        System.out.println(result2);
        Assert.assertEquals(result1, 4);
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
