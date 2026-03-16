package org.xinrui.common.util;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.slf4j.MDC;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class TaskLogInterceptor implements HandlerInterceptor {

    /**
     * 在请求开始时设置任务标识
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {

        String uri = request.getRequestURI();
        String method = request.getMethod();

        // 根据URL路径自动识别任务
        String task = extractTaskFromUri(uri);
        MDC.put("task", task);

        // 可选：添加更多上下文信息
        MDC.put("path", uri);
        MDC.put("method", method);
        MDC.put("ip", getClientIp(request));

        return true;
    }

    /**
     * 从URI中提取任务标识
     */
    private String extractTaskFromUri(String uri) {
        if (uri.contains("/wuchuang/") || uri.startsWith("/wuchuang")) {
            return "wuchuang";
        } else if (uri.contains("/kangyun/") || uri.startsWith("/kangyun")) {
            return "kangyun";
        } else if (uri.contains("/api/wuchuang")) {
            return "wuchuang";
        } else if (uri.contains("/api/kangyun")) {
            return "kangyun";
        } else if (uri.contains("/wuchuang-api")) {
            return "wuchuang";
        } else if (uri.contains("/kangyun-api")) {
            return "kangyun";
        }
        return "common";
    }

    /**
     * 获取客户端IP
     */
    private String getClientIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    /**
     * 请求完成后清理MDC
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {
        // 清理所有MDC中的值
        MDC.clear();
    }
}
