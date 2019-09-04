本地安装ojdbc jar包：
进入lib目录找到ojdbc8

```
mvn install:install-file -DgroupId=com.oracle -DartifactId=ojdbc8 -Dversion=12.2.0.1 -Dpackaging=jar -Dfile=ojdbc8-12.2.0.1.jar
```

#### 项目结构
common: 作为项目公共依赖项目，放一些通用的工具类
framework: 示例项目，包含技术点的使用说明
gateway: API Gateway项目
starter: 项目框架层通用配置的starter，简化代码配置
    mybatis-oracle-starter：集成mybatis-plus、druid、oracle

#### framework包结构
adapter：内部包含出站适配器（对其他外部服务的调用）和入站适配器（暴露controller或者消息调用接口）
    inbound：入站适配器
        controller
        message
    outbound：出站适配器
        database：数据库操作
        message：消息发生
        rest：rest接口调用
        webservice：webservice接口调用
config：项目配置类  
domain：领域实体，包含业务      