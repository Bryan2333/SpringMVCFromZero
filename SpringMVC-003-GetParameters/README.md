# SpringMVC获取请求参数

## 1. 通过Servlet原生API

```
@RequestMapping("/testServletAPI")
// 形参位置的request表示当前请求
public String testServletAPI(HttpServletRequest request) {
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    System.out.println("username = " + username + ", password = " + password);
    return "test_param";
}
```

## 2. 通过前端控制器形参获取参数

1. 需要确保请求参数名和控制器方法的形参名称一致
2. 当请求参数中存在同名的请求参数，控制器方法的形参类型应该为**数组**

```
@RequestMapping("/testServletAPI")
// 形参位置的request表示当前请求
public String testServletAPI(HttpServletRequest request) {
    System.out.println("username = " + username + ", password = " + password);
    return "test_param";
}

@RequestMapping("/testParam")
public String testParam(String username, String password, String[] hobby) {
    System.out.println("username = " + username + ", password = " + password + ", hobbies = " + Arrays.toString(hobby));
    return "test_param";
}
```
## 3. @RequestParam

1. `@RequestParam`: 将请求参数和控制器方法形参建立映射关系
    1. `value`: 指定该形参数值的请求参数名称
    2. `required`: 表示该请求参数是否必须传输，默认为true
    3. `defaultValue`: 不管`required`为true还是false，当指定的`value`所指定的请求参数没有被传输时，则使用默认值给形参赋值

```
@RequestMapping("/testParam")
public String testParam(
        @RequestParam(value = "user_name", defaultValue = "呵呵") String username,
        @RequestParam("password") String password,
        @RequestParam("hobby") String[] hobby) {
    System.out.println("username = " + username + ", password = " + password + ", hobbies = " + Arrays.toString(hobby));
    return "test_param";
}
```

## 4. @RequestHeader

1. `@RequestHeader`: 将请求头信息和控制器方法的形参建立映射关系
2. 用法和`@RequestParam`大致相同

## 5. @CookieValue

1. `@CookieValue`: 将Cookie信息和控制器方法的形参建立映射关系
2. 用法和`@RequestParam`大致相同

## 6. 使用实体类对象接受参数

1. 当请求参数的名称和实体类的属性名一致时，会赋值给控制器方法的实体类形参
