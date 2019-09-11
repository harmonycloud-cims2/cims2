本地安装ojdbc jar包：
进入lib目录找到ojdbc8

```
mvn install:install-file -DgroupId=com.oracle -DartifactId=ojdbc8 -Dversion=12.2.0.1 -Dpackaging=jar -Dfile=ojdbc8-12.2.0.1.jar
```

#### 项目结构
```text
├── codeGenerate: 代码生成项目
├── common: 作为项目公共依赖项目，放一些通用的工具类
├── framework: 示例项目，包含技术点的使用说明
├── gateway: API Gateway项目
├── starter: 项目框架层通用配置的starter，简化代码配置
|  ├── mybatis-oracle-starter：集成mybatis-plus、druid、oracle
```

#### framework包结构
```text
├── adapter：内部包含出站适配器（对其他外部服务的调用）和入站适配器（暴露controller或者消息调用接口）
|  ├── inbound：入站适配器
|  ├──  controller
|  ├──  message
├── outbound：出站适配器
|  ├──  database：数据库操作
|  ├──  message：消息发生
|  ├──  rest：rest接口调用
|  ├──  webservice：webservice接口调用
├── config：项目配置类  
├── domain：领域实体，包含业务   
```
   
#### 使用代码生成
项目：codeGenerate
运行CodeGenerate类，根据提示输入信息，项目名称目前只支持一级项目，如 framework
输入后会生成代码，可以生成entity、mapper、service、serviceImpl、controller

使用场景：
- 新建表：生成全部模版代码
- 更新表：更新entity实体类


#### Oracle读写分离
在配置文件application.yml中配置动态数据源
```
dynamic:
      primary: write
      datasource:
        write:
          url: jdbc:oracle:thin:@10.1.11.111:1521:XE
          username: ROOT
          password: 123456
        read:
          url: jdbc:oracle:thin:@10.1.11.111:1521:XE
          username: XJOB
          password: xjob
```
其中primary属性指定默认数据源，在代码中使用@DS 切换数据源。
@DS 可以注解在方法上和类上，同时存在方法注解优先于类上注解。
没有@DS时，使用默认数据源，@DS("dsName")来指定使用哪个数据源，
dsName可以为组名也可以为具体某个库的名称
注解在service实现或mapper接口方法上，但强烈不建议同时在service和mapper注解。 (可能会有问题)

