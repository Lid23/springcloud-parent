
# 核心微服务-网关（gateway）
提供基于Spring Cloud Gateway开发，提供数据方服务统一入口。

## 核心类说明
基于gateway的GlobalFilter实现相关验证。
- RequestFilter

      对数据流进行处理（通过redis实现请求流的存储）。
- RequestAuthFilter

      对请求方式进行过滤，只允许POST请求。      
- MerchantAuthFilter

      提供商户验证功能。
- OAuthSignatureFilter

      统一认证（请求方只有通过网关才能访问后端数据方服务，否则401）。      

提供商户验证功能。
## 项目启动
 - maven打包：
 进入父目录下执行以下操作：
 ```
 mvn clean install
 ```
 - 启动服务：
  ```
  microservice-gateway.sh start
  ```
