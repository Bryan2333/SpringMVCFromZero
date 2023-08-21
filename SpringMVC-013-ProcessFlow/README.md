# SpringMVC执行流程

## 常用组件

1. `DispatcherServlet`：前端控制器，统一处理请求和响应，整个流程控制的中心，由该组件调用其他组件处理用户的请求
2. `HandlerMapping`：处理器映射器，根据请求的URL和请求方式等信息查找对于的Handler，即处理器
3. `Handler`：处理器，在前端控制器的控制下`Handler`对具体的用户请求进行处理
4. `HandlerAdapter`：处理器适配器，前端控制器通过该适配器调用处理器方法
5. `ViewResolver`：进行视图解析，得到相应的视图
6. `View`：将模型数据通过页面展示给用户

## DispatcherServlet处理请求

1. `processRequest`
2. `doService`
3. `doDispatcher`
   1. `getHandler`
   2. `getHandlerAdapter`
   3. `applyPreHandle`
   4. `handle`
   5. `applyPostHandle`
4. `processDispatcherResult`
   1. `render`
   2. `triggerAfterCompletion`


