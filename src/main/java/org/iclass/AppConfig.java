package org.iclass;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer {
    private String urlPath = "/upload/**";
    private String location = "file:///C:/upload/";

//수정 123123123
//    제대로 된 수정

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry resourceHandlerRegistry){
        resourceHandlerRegistry.addResourceHandler(urlPath)
                .addResourceLocations(location);

    }

}
