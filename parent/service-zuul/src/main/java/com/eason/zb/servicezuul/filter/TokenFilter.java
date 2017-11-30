package com.eason.zb.servicezuul.filter;

import com.netflix.zuul.ZuulFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;

@Component
public class TokenFilter extends ZuulFilter {
    private static Logger log = LoggerFactory.getLogger(TokenFilter.class);


    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return PRE_DECORATION_FILTER_ORDER+1;
    }

    @Override
    public boolean shouldFilter() {
        return false;
    }

    @Override
    public Object run() {
//        try {
//            RequestContext ctx = getCurrentContext();
//            InputStream in = (InputStream) ctx.get(FilterConstants.REQUEST_ENTITY_KEY);
//            if (in == null) {
//                in = ctx.getRequest().getInputStream();
//            }
//            HttpServletRequest request = ctx.getRequest();
//            String accessToken=request.getHeader("api_token");
//            if (StringUtils.isEmpty(accessToken)){
//                 accessToken = request.getParameter("token");
//            }
//            if (StringUtils.isEmpty(accessToken)){
//                ctx.setSendZuulResponse(false);
//                ctx.setResponseStatusCode(401);
//                ctx.setResponseBody("{ \"status\": 500, \"massgae\": \"请求失败\", \"data\":\"api_token is empty\"}");
//                ctx.getResponse().setContentType("text/html;charset=UTF-8");
//            }else{
//                BoundHashOperations<String, String, String> ops = stringRedisTemplate.boundHashOps("user_api_token");
//                String id=ops.get(accessToken);
//                if (id==null){
//                    ctx.setSendZuulResponse(false);
//                    ctx.setResponseStatusCode(401);
//                    ctx.setResponseBody("{ \"status\": 500, \"massgae\": \"请求失败\", \"data\":\"api_token is error\"}");
//                    ctx.getResponse().setContentType("text/html;charset=UTF-8");
//                }else{
////                    String body = StreamUtils.copyToString(in, Charset.forName("UTF-8"));
//                    Object originalRequestPath = ctx.get(FilterConstants.REQUEST_URI_KEY);
//                    String modifiedRequestPath = originalRequestPath+"?token="+accessToken+"&userId="+id;
//                    ctx.put(FilterConstants.REQUEST_URI_KEY, modifiedRequestPath);
//                    log.info("转换后的URL：" + modifiedRequestPath);
//                    ctx.setSendZuulResponse(true);//会进行路由，也就是会调用api服务提供者
//                    ctx.setResponseStatusCode(200);
                    // context.set("requestEntity", new
                    // ByteArrayInputStream(body.getBytes("UTF-8")));
//                    final byte[] reqBodyBytes = body.getBytes();
//                    ctx.setRequest(new HttpServletRequestWrapper(getCurrentContext().getRequest()) {
//                        @Override
//                        public ServletInputStream getInputStream() throws IOException {
//                            return new ServletInputStreamWrapper(reqBodyBytes);
//                        }
//
//                        @Override
//                        public int getContentLength() {
//                            return reqBodyBytes.length;
//                        }
//
//                        @Override
//                        public long getContentLengthLong() {
//                            return reqBodyBytes.length;
//                        }
//                    });
//                    return null;
//                }
//            }
//            if (responseHandler != null) {
//                ctx.getResponse().setCharacterEncoding("UTF-8");
//                ctx.setResponseStatusCode(responseHandler.getResponseCode());
//                ctx.setResponseBody(responseHandler.getResponseBody(null, null));
//            }
//            context.setSendZuulResponse(false);
//        } catch (Exception e) {
//            rethrowRuntimeException(e);
//        }
        return null;
    }
}
