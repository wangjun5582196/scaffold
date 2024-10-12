package com.business.program.cross.border.trade.utils;


import org.slf4j.MDC;

import static com.business.program.cross.border.trade.common.constant.MDCConstants.*;


public class MDCUtil {

    /**
     * 没有消息
     */
    public static final String NO_MESSAGE = "N/A";

    /**
     * 设置mdc信息
     * @param traceId
     */
    public static void set(String traceId){

        MDC.put(MDC_TRACE_ID,traceId);
        MDC.put(MDC_TENANT_NAME,NO_MESSAGE);
        MDC.put(MDC_USER_NAME,NO_MESSAGE);
        MDC.put(MDC_CLIENT_INFO,NO_MESSAGE);
    }

    /**
     * 设置mdc信息
     * @param traceId
     * @param tenantName
     * @param userName
     * @param clientInfo
     */
    public static void set(String traceId,String tenantName,String userName,String clientInfo){

        MDC.put(MDC_TRACE_ID,traceId);
        MDC.put(MDC_TENANT_NAME,tenantName);
        MDC.put(MDC_USER_NAME,userName);
        MDC.put(MDC_CLIENT_INFO,clientInfo);
    }

    /**
     * 设置mdc信息
     * @param traceId 追踪id
     * @param tenantName 租户名称
     * @param userName 用户名称
     */
    public static void set(String traceId, String tenantName, String userName) {

        MDC.put(MDC_TRACE_ID,traceId);
        MDC.put(MDC_TENANT_NAME,tenantName);
        MDC.put(MDC_USER_NAME,userName);
        MDC.put(MDC_CLIENT_INFO,NO_MESSAGE);
    }

    /**
     * 清除mdc信息
     */
    public static void release() {

        MDC.remove(MDC_TRACE_ID);
        MDC.remove(MDC_TENANT_NAME);
        MDC.remove(MDC_USER_NAME);
        MDC.remove(MDC_CLIENT_INFO);
    }
}
