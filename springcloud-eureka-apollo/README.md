
# 核心微服务-注册中心（eureka）
提供基于Spring Cloud开发的微服务注册与服务发现功能。

## 核心配置
```
server:
  port: 8101
spring:
  profiles: dev-8101
  security:
    user:
      name: yrz_eureka
      password: yrz_eureka
      roles:
        - USER
eureka:
  instance:
    hostname: 10.168.96.41                                #eureka实例名称
  environment: dev                                         #指定eureka当前环境
  server:
    enable-self-preservation: true                         #自我保护模式是否可用(仅测试时使用)
    eviction-interval-timer-in-ms: 3000                    #清理无效节点的时间间隔(ms)
    response-cache-update-interval-ms: 3000                #eureka server刷新readCacheMap的时间(默认30s)
  client:
    register-with-eureka: false                            #是否将自己注册到Eureka Server
    fetch-registry: false                                  #不通过eureka获取注册信息
    service-url:
      defaultZone: http://yrz_eureka:yrz_IDC18@10.168.96.41:8102/eureka/,http://yrz_eureka:yrz_IDC18@10.168.96.41:8103/eureka/
```
## 项目启动
 - maven打包：
 进入父目录下执行以下操作：
 ```
 mvn clean install
 ```
 - 启动服务：
  ```
nohup java -Xms512m -Xmx1024m -jar -Denv=dev -Didc=eureka-8101 microservice-eureka.jar &
nohup java -Xms512m -Xmx1024m -jar -Denv=dev -Didc=eureka-8102 microservice-eureka.jar &
nohup java -Xms512m -Xmx1024m -jar -Denv=dev -Didc=eureka-8103 microservice-eureka.jar &
 ```
