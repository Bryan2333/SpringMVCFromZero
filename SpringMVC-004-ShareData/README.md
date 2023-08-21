# SpringMVC 域对象数据共享

## Request域对象

### `Model` `Map` `ModelMap` 三者的关系

1. 三者在控制器方法的形参的实际类型是 `BindingAwareModelMap`
2. 控制器方法执行之后会返回统一的 `ModelAndView` 对象

```
public interface Model {}
public class ModelMap extends LinkedHashMap<String, Object> implements Model {}
public class ExtendedModelMap extends ModelMap {}
public class BindingAwareModelMap extends ExtendedModelMap {}
```
