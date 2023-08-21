# HttpMessageConverter

`HttpMessageConverter`，报文信息转换器，可以将Http的请求报文转换为Java对象，也可以将Java对象转换为Http的响应报文

`HttpMessageConverter` 提供两个注解，两个实体类

- `@RequestBody`
- `@ResponseBody`
- `RequestEntity`
- `ResponseEntity`

## @RequestBody

`@RequestBody`可以用于**获取请求体**，使用时需要在控制器方法中设置一个形参，并使用该注解标注

```
@RequestMapping("/testRequestBody")
public String testRequestBody(@RequestBody String requestBody) {
    System.out.println(requestBody);
    return "success";
}
```

## RequestEntity

`RequestEntity`是一种**封装请求报文**的类型，使用时需要在控制器方式中设置该类型的形参。

具有的方法：

- `getHeaders()` : 获取请求头信息
- `getBody()` : 获取请求体信息

示例：

```
@RequestMapping("/testRequestEntity")
public String testRequestEntity(RequestEntity<String> requestEntity) {
    System.out.println("请求头 = " + requestEntity.getHeaders());
    System.out.println("请求体 = " + requestEntity.getBody());
    System.out.println("整个报文 = " + requestEntity);
    return "success";
}
```

## @ResponseBody

被 `@ResponseBody` 注解标记的方法，其返回值会被写入到响应体中返回给浏览器，而不会被视图解析器解析。

示例：

```
@RequestMapping("/testResponseBody")
@ResponseBody
public String testResponseBody() {
    // 此时return的内容会被写入到响应体中返回给服务器，而不是被视图解析器解析
    return "<h1>success</h1>";
}
```

如果返回值是一个Java对象，则需要引入Jackson包，并在SpringMVC的配置文件中开启注解驱动，此时Java对象会被自动转换成Json字符串

示例：

```
@RequestMapping("/testResponseUser")
@ResponseBody
public User testResponseUser() {
    return new User(1, "张三", "1111", 111, "男");
}
```

浏览器输出：`{"id":1,"username":"张三","password":"1111","age":111,"sex":"男"}`

## @RestController

`@RestController`是一个复合注解，标记在控制器的类上。被标记的类相当于具有了被`@Controller`标记，同时类中的每个控制器方法被`@ResponseBody`标记的效果

## ResponseEntity

`ResponseEntity`用于控制器的返回值类型，该控制器方法的返回值就是响应到浏览器的响应报文
