package com.javareact.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.javareact.springboot.interceptor.CustomRateLimiterInterceptor;

@Configuration
public class WebConfigForResisterInterceptor implements WebMvcConfigurer{
	
	@Autowired
	CustomRateLimiterInterceptor customRateLimiterInterceptor;

	@Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(customRateLimiterInterceptor).addPathPatterns("/api/openweathermap/getweather/**");
    }
	
	@Bean
    public RestTemplate restTemplate() {
		return new RestTemplate();
    }
	
}
