package com.bryan.mvc.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;



/**
 * 代替SpringMVC的配置文件
 * 1. 扫描组建
 * 2. 配置视图解析器
 * 3. 配置视图控制器 view-controller
 * 4. 默认servlet处理器 default-servlet-handler
 * 5. mvc注解驱动
 * 6. 文件上传解析器
 * 7. 异常处理
 * 8. 拦截器
 */

@Configuration // 将当前类标识为配置类
@EnableWebMvc  // 开启MVC的注解驱动
@ComponentScan("com.bryan.mvc") // 扫描组建
public class WebConfig implements WebMvcConfigurer {
    private final ApplicationContext applicationContext = ContextLoader.getCurrentWebApplicationContext();

    // 生成模板解析器
    @Bean(value = "templateResolver")
    public ITemplateResolver templateResolver() {
        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
        if (applicationContext != null) {
            resolver.setApplicationContext(applicationContext);
        }
        resolver.setPrefix("/WEB-INF/templates/");
        resolver.setSuffix(".html");
        resolver.setTemplateMode(TemplateMode.HTML);
        resolver.setCharacterEncoding("UTF-8");
        return resolver;
    }

    // 生成模板引擎并注入模板解析器
    @Bean(value = "templateEngine")
    public SpringTemplateEngine templateEngine(ITemplateResolver templateResolver) {
        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.setTemplateResolver(templateResolver);
        return engine;
    }

    // 生成视图解析器并注入模板引擎
    @Bean(value = "viewResolver")
    public ViewResolver viewResolver(SpringTemplateEngine templateEngine) {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setOrder(1);
        resolver.setCharacterEncoding("UTF-8");
        resolver.setTemplateEngine(templateEngine);
        return resolver;
    }
}
