package com.elearning.configuration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

    	
    	registry.addResourceHandler("/Projects/E-Learning/Elearnings/src/main/resources/images/course/banner/**")
                .addResourceLocations("file:D:/Projects/E-Learning/Elearnings/src/main/resources/images/course/banner"); 
    }
}
