# SpringMVC注解配置

初始化类查找顺序


```mermaid
flowchart TD
    javax.servlet.ServletContainerInitializer --> SpringServletContainerInitializer --> WebApplicationInitializer --> AbstractAnnotationConfigDispatcherServletInitializer --> 开发者编写的类
```
