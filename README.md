
# 核心微服务
提供基于Spring Cloud开发

## 核心微服务说明
- spring boot包版本
 ```
 <parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.0.8.RELEASE</version>
    <relativePath/> <!-- lookup parent from repository -->
</parent>
 ```
- spring cloud包版本
```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-dependencies</artifactId>
    <version>Finchley.SR2</version>
    <type>pom</type>
    <scope>import</scope>
</dependency>
```
## 相关服务说明
- microservice-api

      公共接口，提供公共请求及返回VO  
- microservice-utils

      工具类，提供如http，json，date，rsa，base64等统一处理工具类。
- springcloud-eureka/springcloud-eureka-apollo

      微服务注册中心。    
- microservice-feign

      微服务核心feign接口。      
- microservice-gateway

      微服务统一网关 ，实现基于gateway的统一验证，授权，限流等。        
- microservice-log

      统一log工具类封装。             
- microservice-mongodb-provider

      微服务服提供方提供springboot，springcloud 及 mongodb支持。             
- microservice-nodb-provider

      微服务服提供方提供springboot，springcloud支持。
- microservice-provider

      微服务服提供方提供springboot，springcloud，oracle，mybatis，druid支持。
- microservice-redis

      微服务核心redis，提供redis缓存及redisson分布式锁支持。
- microservice-security

      微服务核心security，统一auth支持。
- microservice-sleuth

      微服务核心sleuth，链路追踪。
- microservice-apollo

      微服务核心apollo，分布式配置中心。