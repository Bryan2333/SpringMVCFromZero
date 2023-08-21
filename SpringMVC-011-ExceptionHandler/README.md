# SpringMVC异常处理

SpringMVC提供了一个处理控制器方法执行时异常的接口 `HandlerExceptionResolver`

该接口有两个实现类 `DefaultHandlerExceptionResolver` 和 `SimpleMappingExceptionResovler`

## 基于配置文件的异常处理

```xml
<!-- 配置异常处理 -->
<bean class="org.springframework.web.servlet.handler.SimpleMappingExceptionResolver">
    <!-- 异常-视图名映射-->
    <property name="exceptionMappings">
        <props>
            <!-- key是异常名称，value是遇到该异常时要转跳到的视图的名称 -->
            <prop key="java.lang.ArithmeticException">error</prop>
        </props>
    </property>
    <!-- 设置将异常信息共享到请求域中的键 -->
    <property name="exceptionAttribute" value="exKey"/>
</bean>
```

## 基于注解的异常处理

```java
@ControllerAdvice
public class CustomExceptionHandler {
    // 通过@ExceptionHandler注解标记该方法要处理的异常
    @ExceptionHandler(value = {ArrayIndexOutOfBoundsException.class})
    public String testCustomExceptionHandler(Exception e, Model model) {
        // 将异常信息共享到请求域中
        model.addAttribute("exKey", e);
        return "error";
    }
}
```

