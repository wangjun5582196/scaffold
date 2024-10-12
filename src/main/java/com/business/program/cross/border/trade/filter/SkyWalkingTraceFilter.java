package com.business.program.cross.border.trade.filter;


import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.business.program.cross.border.trade.utils.MDCUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@Component
@Order(1)
@WebFilter(filterName = "SkyWalkingTraceFilter", urlPatterns = "/*")
@Slf4j
public class SkyWalkingTraceFilter implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        String traceId = String.valueOf(IdWorker.getId());
        try {
            MDCUtil.set(traceId);
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            MDCUtil.release();
        }
    }
}
