# AnnotationCase
注解使用案例

注解使用案例
1：规定类似webapps的服务存放包查找service包
2：取得包下类的所有注解
3：按照注解将服务名与Class放入Map中
4：请求时按照URI抓存储的服务对象出来使用

准备工作：
注解类是：com.kaige123.daomu.annotation.Servlet注解

使用案例：
使用注解的类是：com.kaige123.daomu.service.server类

基础框架：
查找service包的类是：com.kaige123.daomu.FindRegService.FindService
扫描service包类上注解的类是(扫描类)：com.kaige123.daomu.FindRegService.ScanningAnnotation
配置类是：com.kaige123.daomu.FindRegService.ParamterConfig

将service包下要管理的类全部加载上来，得到类上注解，按照注解存储起来供客户端访问服务

附加动态代理：
代理处理类：com.kaige123.daomu.FindRegService.InvokePrint

测试案例：test.java.com.kaige123.daomu.FindServiceTest类

在当前案例中，有一类似servle的注册服务。将服务通过注解注册在池中，有访问时按URI抓服务对象。在测试中还有对动态代理的使用
