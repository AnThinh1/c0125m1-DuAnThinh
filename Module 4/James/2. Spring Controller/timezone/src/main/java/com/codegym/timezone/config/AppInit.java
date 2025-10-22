package com.codegym.timezone.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null; // Không cần cấu hình root context
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { WebConfig.class }; // Gắn với file WebConfig
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" }; // Map toàn bộ request cho DispatcherServlet
    }
}