package com.rs.ocp.service.app;

import com.rs.ocp.service.conf.MessageConfConst;
import com.rs.ocp.service.PpPassportService;
import com.rs.ocp.service.PpPassportServiceImpl;
import com.rs.ocp.service.dto.LoginRequestDTO;
import com.rs.ocp.service.dto.LoginResponseDTO;
import com.rs.ocp.service.dto.MsgHeader;
import com.rs.ocp.service.utils.Commons;
import org.apache.commons.lang.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {

    private static Logger logger = LoggerFactory
            .getLogger(com.rs.ocp.domain.app.App.class);

    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:META-INF/spring/applicationContext.xml");
        PpPassportService passportService = (PpPassportServiceImpl) ctx.getBean("passportService");

        byte[] result1 = new byte[]{96, 0, 0, 0, 1, 3, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 32, 0, 0,
            2, 1, 0, 0, 0,
            4, 116, 101, 115, 116, 48, 52, 49, 0,
            4, 101, 49, 48, 97, 100, 99, 51, 57, 52, 57, 98, 97, 53, 57, 97, 98, 98, 101, 53, 54, 101, 48, 53, 55, 102, 50, 48, 102, 56, 56, 51, 101, 0,
            4, 49, 57, 50, 46, 49, 54, 56, 46, 49, 46, 49, 49, 52, 0,
            2, 22, 29, 0, 0};

        LoginRequestDTO loginRequestDto = new LoginRequestDTO(result1);
        MsgHeader header = getRequestHeaderByMsg(result1);
        loginRequestDto.setHeader(header);
        loginRequestDto.setGameServerId(1);
        LoginResponseDTO loginResponseDto = passportService.login(loginRequestDto);
        
    }

    public static MsgHeader getRequestHeaderByMsg(byte[] msg) {
        MsgHeader requestHeader = new MsgHeader();
        if (msg.length >= 32) {
            requestHeader.setMessageLength(Commons.bytesToInt(ArrayUtils.subarray(msg, 0, 4)));
            requestHeader.setMessageVersion(Commons.bytesToInt(ArrayUtils.subarray(msg, 4, 8)));
            requestHeader.setMessageUserID(ArrayUtils.subarray(msg, 8, 24));
            requestHeader.setMessageReserved(Commons.bytesToInt(ArrayUtils.subarray(msg, 24, 28)));
            requestHeader.setMessageCode(Commons.bytesToInt(ArrayUtils.subarray(msg, 28, 32)));
        }
        return requestHeader;
    }
}
