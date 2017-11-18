package pl.kodolamacz.mvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Created by acacko on 05.11.17
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "pl.kodolamacz.mvc.controllers")
public class WebConfig extends WebMvcConfigurerAdapter {

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setExposeContextBeansAsAttributes(true);
        return resolver;
    }

    // static resources handling
    @Override
    public void configureDefaultServletHandling (DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

   // mechanizm internacjonalizacji powiązany z plikami message_pl_PL.properties
  @Bean("messageSource")
  public ResourceBundleMessageSource getMessageSource(){
    ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
    resourceBundleMessageSource.setBasename("messages");
    resourceBundleMessageSource.setDefaultEncoding("UTF-8");
    return resourceBundleMessageSource;
  }

}
