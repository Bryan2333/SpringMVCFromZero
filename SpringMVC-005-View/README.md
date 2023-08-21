# SpringMVC 视图

## ThymeleafView

当控制器方法中所设置的试图名称**没任何前缀**时，视图名称会被SpringMVC配置文件中的视图解析器解析，视图名称拼接视图前缀和后缀所得到的最终路径，会通过视图转发实现跳转

```
@RequestMapping("/testThymeleafView")
public String testThymeleafView() {
    return "success";
}
```

## 转发视图

SpringMVC中默认的转发视图是 `InternalResourceView`

SpringMVC创建视图转发的情况：

当控制器方法配置的视图名称以 `forward:` 为前缀时，创建 `InternalResourceView` 视图，此时的视图并不会被SpringMVC配置文件中所配置的视图解析器解析，而是会将 `forward:` 前缀去掉，剩余的部分作为最终路径通过**转发**实现跳转 

```
@RequestMapping("/testForwardView")
public String testForwardView() {
    return "forward:/testThymeleafView";
}
```

## 重定向视图

SpringMVC中默认的重定向视图是 `RedirectView`

当控制器方法配置的视图名称以 `redirect:` 为前缀时，创建 `RedirectView` 视图，此时的视图并不会被SpringMVC配置文件中所配置的视图解析器解析，而是会将 `redirect:` 前缀去掉，剩余的部分作为最终路径通过**重定向方式**实现跳转 

```
@RequestMapping("/testRedirectView")
public String testRedirectView() {
    return "redirect:/testThymeleafView";
}
```

## 视图控制器

当控制器方法仅仅是实现页面跳转，即只设置了视图名称时，可以使用视图控制器标签 `mvc:view-controller` 代替控制器方法

```
<mvc:view-controller path="/" view-name="index" />
<mvc:annotation-driven />
```

1. `path` 表示请求路径
2. `view-name` 表示视图名称

注意：

在SpringMVC配置文件配置了视图控制器后，其他控制器的请求映射将会全部失效，此时需要手动开启MVC的注解驱动
