package com.eason.api.zb.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.hystrix.exception.HystrixBadRequestException;
import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;

public class ZbServiceErrorDecoder implements ErrorDecoder {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public Exception decode(String methodKey, Response response) {
        try {
            String info=Util.toString(response.body().asReader());
            logger.error(info);
            ObjectMapper objectMapper = new ObjectMapper();
            //{"timestamp":1511754739849,"status":500,"error":"Internal Server Error","exception":"com.eason.api.zb.exception.ServiceException","message":"主播(userId=17)不存在，请您先申请主播","path":"/zhubo/getReadyPlayInfo"
            Map<String, Object> resultMap =objectMapper.readValue(info, Map.class);
            return new HystrixBadRequestException((String) resultMap.get("message"));
        } catch (IOException e) {
            logger.error(methodKey,e.getMessage());
            return new HystrixBadRequestException(e.getMessage());
        }
    }
}
