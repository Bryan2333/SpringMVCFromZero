# @RequestMapper 注解

## 1. 作用

`@RequestMapping` 注解的作用是将请求和处理请求的控制器方法关联起来，建立映射关系

SpringMVC接收到请求后，会从映射关系中到找对应的控制器来处理请求

## 2. 位置

1. `@RequestMapping`标识一个类: 设置映射请求的请求路径的**初始信息**
2. `@RequestMapping`标识一个方法: 设置映射请求的请求路径的**具体信息**

## 3. value属性

1. `@RequestMapping`注解的`value`属性通过请求的**请求地址**来匹配请求映射
2. 该属性是一个`String[]`, 表示请求映射可以**匹配多个请求地址**所对应的请求
3. 该属性是**必须填写的**

## 4. method属性

1. `@RequestMapping`注解的`method`属性通过请求的**请求方式**来匹配请求映射
2. 该属性是一个`RequestMethod[]`，表示请求映射可以**匹配多种请求方法的请求**
3. 如果没有设置该属性，则表示请求映射可以**匹配任意请求方法**的请求
4. 对于处理指定请求方式的控制器方法，SpringMVC提供了`@RequestMapping`的派生注解
    1. `@GetMapping`: 处理GET请求的映射
    2. `@PostMapping`: 处理POST请求的映射
    3. `@PutMapping`: 处理PUT请求的映射
    4. `@DeleteMapping`: 处理DELETE请求的映射
5. 如果请求没有满足要求，则服务端会返回405

## 5. params属性

1. `@RequestMapping`注解的`params`属性通过请求的**请求参数**来匹配请求映射
2. 该属性是一个`String[]`，可以通过以下四种表达式设置请求参数和请求映射间的匹配关系
    1. `"param"`: 要求请求映射所匹配的请求**必须带有`param`参数**
    2. `"!param"`: 要求请求映射所匹配的请求**不能带有`param`参数**
    3. `"param=value"`: 要求请求映射所匹配的请求必须带有`param`参数且**数值等于value**
    4. `"param=!value"`: 要求请求映射所匹配的请求必须带有`param`参数且**数值不等于value**
3. 如果请求没有满足要求，则服务端会返回400

## 6. headers属性

1. `@RequestMapping`注解的`headers`属性通过请求的**请求头信息**来匹配映射关系
2. 该属性是一个`String[]`，可以通过以下四种表达式设置请求头信息和请求映射间的匹配关系
    1. `"header"`: 要求请求映射所匹配的请求**必须带有`header`请求头信息**
    2. `"!header"`: 要求请求映射所匹配的请求**不能带有`header`请求头信息**
    3. `"header=value"`: 要求请求映射所匹配的请求必须带有`header`请求头信息且**数值等于value**
    4. `"header=!value"`: 要求请求映射所匹配的请求必须带有`header`请求头信息且**数值不等于value**
3. 如果请求没有满足要求，则服务端会返回404

## 7. Ant风格路径

1. `?`: 表示任意单个字符
2. `*`: 表示任意0个或多个字符
3. `**`: 表示任意的一层或多层目录 (Spring5.3起只能放在pattern最后)

## 8. 路径中的占位符

1. 原始方式: `/deleteUser?id=1`
2. Restful: `/deleteUser/1`
3. 当请求路径中将某些数据通过路径的方式传输给服务器中，就可以在相应的`@RequestMapping`中的`value`属性中使用占位符`{xxx}`表示传输的数据。可以通过`@PathVariable`注解将占位符中的数值赋给控制器方法的形参
```
@RequestMapping("/testPath/{id}/{username}")
public String testPath(@PathVariable Integer id, @PathVariable String username) {
    System.out.println("id = " + id + ", username = " + username);
    return "success";
}
```
