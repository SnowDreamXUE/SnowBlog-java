package com.snow.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 跨域配置类 - 统一管理所有跨域设置
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    /**
     * WebMvcConfigurer方式配置跨域
     * 这是Spring MVC推荐的跨域配置方式
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                // 允许所有来源
                .allowedOriginPatterns("*")
                // 允许所有请求头
                .allowedHeaders("*")
                // 允许所有HTTP方法
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "PATCH")
                // 允许携带凭证（Cookie、Authorization等）
                .allowCredentials(true)
                // 预检请求的有效期，单位为秒（1小时）
                .maxAge(3600)
                // 暴露的响应头（前端可以访问的响应头）
                .exposedHeaders("Content-Disposition", "Content-Type", "Authorization", "X-Total-Count");
    }

    /**
     * CorsFilter方式配置跨域（备用方案）
     * 提供更底层的跨域控制
     */
    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();

        // 允许所有来源
        corsConfiguration.addAllowedOriginPattern("*");

        // 允许所有请求头
        corsConfiguration.addAllowedHeader("*");

        // 允许所有HTTP方法
        corsConfiguration.addAllowedMethod("*");

        // 允许携带凭证（如Cookie、Authorization等）
        corsConfiguration.setAllowCredentials(true);

        // 预检请求的有效期，单位为秒
        corsConfiguration.setMaxAge(3600L);

        // 暴露的响应头
        corsConfiguration.addExposedHeader("Content-Disposition");
        corsConfiguration.addExposedHeader("Content-Type");
        corsConfiguration.addExposedHeader("Authorization");
        corsConfiguration.addExposedHeader("X-Total-Count");
        corsConfiguration.addExposedHeader("Access-Control-Allow-Origin");

        // 配置路径映射
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);

        return new CorsFilter(source);
    }

    /**
     * CORS配置源（第三种配置方式）
     * 用于与Spring Security等框架集成时使用
     */
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        // 允许所有来源
        configuration.addAllowedOriginPattern("*");

        // 允许所有请求头
        configuration.addAllowedHeader("*");

        // 允许所有HTTP方法
        configuration.addAllowedMethod("*");

        // 允许携带凭证
        configuration.setAllowCredentials(true);

        // 预检请求缓存时间
        configuration.setMaxAge(3600L);

        // 暴露的响应头（前端可以访问的响应头）
        configuration.addExposedHeader("Content-Disposition");
        configuration.addExposedHeader("Content-Type");
        configuration.addExposedHeader("Authorization");
        configuration.addExposedHeader("X-Total-Count");
        configuration.addExposedHeader("Access-Control-Allow-Origin");
        configuration.addExposedHeader("Access-Control-Allow-Methods");
        configuration.addExposedHeader("Access-Control-Allow-Headers");

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        return source;
    }
}
