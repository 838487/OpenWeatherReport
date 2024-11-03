package com.javareact.springboot.interceptor;

import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.javareact.springboot.exceptionhandler.CustomRateLimitException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Component
public class CustomRateLimiterInterceptor implements HandlerInterceptor{
	
	   private final Map<String, RateLimitAttributeInner> clientRequestMap = new ConcurrentHashMap<>();
	    private static final int MAX_API_CALL_ALLOWED = 5;
	    private static final long TIME_WINDOW = 60_000L;
	    
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		StringBuilder clientIp = new StringBuilder(request.getRemoteAddr());
        String apiKey = request.getParameter("appid");
        clientIp.append(apiKey);
        RateLimitAttributeInner rateLimitInfo = clientRequestMap.computeIfAbsent(clientIp.toString(), k -> new RateLimitAttributeInner());
        synchronized (rateLimitInfo) {
            long currentTime = Instant.now().toEpochMilli();
            if (currentTime - rateLimitInfo.startTime > TIME_WINDOW) {
                rateLimitInfo.startTime = currentTime;
                rateLimitInfo.requestCount = 1;
            } else {
                rateLimitInfo.requestCount++;
            }

            if (rateLimitInfo.requestCount > MAX_API_CALL_ALLOWED) {
                response.setStatus(HttpServletResponse.SC_SERVICE_UNAVAILABLE);
                throw new CustomRateLimitException("429", "Limit Exceeded!! Only 5 requests are allowed in one minute.");
            }
        }

        return true;
    }

    private static class RateLimitAttributeInner {
        long startTime = Instant.now().toEpochMilli();
        int requestCount = 0;
    }
}