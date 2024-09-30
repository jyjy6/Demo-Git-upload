package org.iclass;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer {
    public String URL_PATH = "/upload/**";
    // 파일시스템 위치
    public String LOCATION ="file:///C:/upload/";

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {


        //위의 2개 값을 매핑
        registry.addResourceHandler(URL_PATH)
                .addResourceLocations(LOCATION);

    }

}
