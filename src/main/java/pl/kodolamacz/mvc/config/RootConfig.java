package pl.kodolamacz.mvc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by acacko on 05.11.17
 */
@Configuration
@ImportResource("classpath:application.xml")
@Import(WebSecurityConfig.class)
public class RootConfig {

}
