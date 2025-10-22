package com.codegym.sandwich.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null; // Không có cấu hình gốc
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { WebConfig.class }; // Kết nối tới file WebConfig
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" }; // Mọi request đều đi qua DispatcherServlet
    }
}