package fr.ws.config;

import org.jtwig.environment.EnvironmentConfigurationBuilder;
import org.jtwig.spring.JtwigViewResolver;
import org.jtwig.spring.boot.config.JtwigViewResolverConfigurer;
import org.jtwig.web.servlet.JtwigRenderer;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JtwigConfig implements JtwigViewResolverConfigurer {

    @Override
    public void configure(JtwigViewResolver viewResolver) {
        viewResolver.setRenderer(new JtwigRenderer(EnvironmentConfigurationBuilder.configuration().build()));
        viewResolver.setSuffix(".html");
        viewResolver.setPrefix("classpath:/templates/");
    }
}