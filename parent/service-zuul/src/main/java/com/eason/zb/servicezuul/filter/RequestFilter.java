package com.eason.zb.servicezuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import static com.netflix.zuul.context.RequestContext.getCurrentContext;

@Component
public class RequestFilter extends ZuulFilter {
    private static Logger log = LoggerFactory.getLogger(RequestFilter.class);

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.PRE_DECORATION_FILTER_ORDER;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
//        HttpServletResponse response = ctx.getResponse();
        ctx.getResponse().setHeader("Access-Control-Allow-Origin", "*");

        log.info(String.format("%s —%s >>> %s",request.getRemoteAddr(), request.getMethod(), request.getRequestURL().toString()));
//        Enumeration e1 = request.getHeaderNames();
//        while (e1.hasMoreElements()) {
//            String headerName = (String) e1.nextElement();
//            String headValue = request.getHeader(headerName);
//            log.info(String.format("请求Head—>%s=%s",headerName,headValue));
//        }
        log.info(String.format("请求Head—>%s=%s","token",request.getHeader("api_token")));
        Map<String,Object> map = new HashMap();
        Enumeration<String> paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()) {
            String paramName =  paramNames.nextElement();
            String[] paramValues = request.getParameterValues(paramName);
            if (paramValues.length == 1) {
                String paramValue = paramValues[0];
                if (paramValue.length() != 0) {
                    map.put(paramName, paramValue);
                }
            }
        }
        log.info(String.format("请求—>Params=%s", map));
        return null;
    }
}
