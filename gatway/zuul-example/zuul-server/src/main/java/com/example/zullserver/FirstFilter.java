package com.example.zullserver;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


public class FirstFilter extends ZuulFilter {
    private static Logger log = LoggerFactory.getLogger(FirstFilter.class);


    @Override
    public String filterType() {
        log.info("####################");

        System.out.println("########################3 filter type");
        return "pre";
    }

    @Override
    public int filterOrder() {
        log.info("####################");
        System.out.println("########################3 filter order");
        return 1;
    }

    @Override
    public boolean shouldFilter() {

        log.info("####################");
        System.out.println("########################3  shouldFilter");
        System.out.println("Here is shouldFilter method");
        RequestContext requestContext = RequestContext.getCurrentContext();
        /*String requestParam  = requestContext.getRequest().getParameter("source");
        if(requestParam != null && requestParam.equals("dev")){
            //return true;
        }else{
            //return false;
        }
*/
        return true;


    }

    @Override
    public Object run() throws ZuulException {
        log.info("####################");
        System.out.println("########################3  run");
        return null;
    }
}
