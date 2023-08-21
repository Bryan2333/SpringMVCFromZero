# SpringMVC拦截器

请求流经服务器的顺序：

请求 ----> [过滤器] ----> 前断控制器 ----> [拦截器 (PreHandle)] ----> 控制器方法 ----> [拦截器 (PostHandle)]

## 拦截器的配置

SpringMVC中的拦截器用于拦截控制器方法的执行

拦截器类需要实现 `HandlerInterceptor`接口

拦截器必须要在SpringMVC的配置文件中进行配置, 一共有三种配置方式：

1. `bean`
2. `ref`
3. `mvc:interceptor`

**前两种会拦截前端控制器处理的所有请求，最后一种可以配置 `<mvc:mapping path>` 配置拦截路径，`<mvc:exclude-mapping path>` 配置放行路径**

```xml
<bean class="com.bryan.mvc.interceptor.FirstInterceptor"/>
<ref bean="firstInterceptor"/>
<!-- 只配置bean和ref会拦截所有请求 -->
<mvc:interceptor>
    <!-- 拦截所有请求 -->
    <mvc:mapping path="/**"/>
    <!-- 首页的请求 (/) 排除在外 -->
    <mvc:exclude-mapping path="/"/>
    <ref bean="firstInterceptor"/>
</mvc:interceptor>
```

## 拦截器的三个抽象方法

1. `preHandle`: 执行控制器方法前调用该方法，其返回值为布尔类型，表示是否放行当前请求。如果返回值为`true`则调用控制器方法，否则不调用控制器方法
2. `postHandle`: 控制器方法执行完后调用该方法
3. `afterCompletion`: 渲染视图完毕后执行该方法

## 拦截器的执行顺序

1. 拦截器的执行顺序是按照配置顺序的**正序**执行`preHandle`，然后按照**相反的倒序**执行`postHandle` 和 `afterCompletion`。
2. 如果有拦截器在`preHandle` 中返回`false`则会中断整个拦截器链的执行，而且只有之前的拦截器的 `afterCompletion`方法会被调用。后续拦截器的方法不会执行且所有拦截器的`postHandler`方法都不会执行
