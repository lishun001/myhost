package com.eason.zb.servicezuul.filter;

import com.netflix.zuul.ZuulFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

@Component
public class ResponseFilter extends ZuulFilter {
    private static Logger log = LoggerFactory.getLogger(ResponseFilter.class);

    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
//        try {
//            RequestContext context = getCurrentContext();
//            InputStream stream = context.getResponseDataStream();
//            String body = StreamUtils.copyToString(stream, Charset.forName("UTF-8"));
//            log.info(String.format("响应—>Body=%s", body));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return null;
    }
}
