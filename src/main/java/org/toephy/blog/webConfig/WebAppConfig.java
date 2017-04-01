package org.toephy.blog.webConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.toephy.blog.filter.BasePathFilter;

/**
 * Created by Toephy on 2017.4.1 17:35
 */
@Configuration
public class WebAppConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        System.out.println("=======================================");
        System.out.println("addInterceptors...");
        System.out.println("=======================================");
        registry.addInterceptor(new BasePathFilter()).addPathPatterns("/**");
    }

}
