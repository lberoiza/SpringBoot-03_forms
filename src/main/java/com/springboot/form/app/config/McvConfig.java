package com.springboot.form.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class McvConfig implements WebMvcConfigurer {

  @Autowired
  @Qualifier("ElapsedTimeInterceptor")
  private HandlerInterceptor elapsedTimeInterceptor;
  
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    // Se llamará en todas las rutas a no ser que se personalice
    registry.addInterceptor(elapsedTimeInterceptor);
    
    // personalizacion, solo para la ruta form
    // registry.addInterceptor(elapsedTimeInterceptor).addPathPatterns("/form/**");
    
  }

}
