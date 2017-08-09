# Shik

Shik包含的所有module(非util)都支持分布式管理

启动顺序：RA -> config -> other (其中我把 RA config zuul 放在了服务器上)

## 项目结构
``` lua
shik
├── shik-common -- 公共模块
├── shik-RA -- 注册中心
|    ├── shik-RA-common -- shik-RA 公共模块
|    ├── shik-RA-1 -- spring cloud eureka server 1 [port:1111]
|    └── shik-RA-2 -- spring cloud eureka server 1 [port:1112]
├── shik-config -- 配置中心
|    ├── shik-config-common -- shik-config 公共模块
|    └── shik-config-1 -- git仓(shik-common.config-repo)公共配置文件 [port:8881]
├── shik-zuul -- 网管路由, 对外统一入口
|    ├── shik-zuul-common -- shik-zuul 公共模块
|    └── shik-zuul-1 -- 路由转发 [port:5551]
├── shik-jdbc -- util jar
|    ├── shik-jdbc-common -- shik-jdbc 公共模块
|    ├── shik-jdbc-jpa -- 整合jpa
|    └── shik-jdbc-mybatis -- 整合mybatis
├── shik-redis -- util jar
|    ├── shik-redis-commong -- shik-redis 公共模块
|    └── shik-redis-jedis -- 整合jedis
├── shik-quartz -- util jar
|    ├── shik-quartz-commong -- shik-quartz 公共模块
|    ├── shik-quartz-config -- 自定义配置方式
|    └── shik-quartz-annotation -- 注解方式
├── shik-freemarker -- util jar
|    ├── shik-freemarker-commong -- shik-freemarker 公共模块
|    └── shik-freemarker-config -- 整合freemarker
├── shik-dao -- dao层
|    ├── shik-dao-common -- shik-dao 公共模块
|    ├── shik-dao-upms -- upms模块dao [port:4441]
|    ├── shik-dao-web -- web模块dao [port:4442]
|    └── shik-dao-admin -- admin模块dao [port:4443]
├── shik-pay -- 支付
|    ├── shik-pay-common -- shik-pay 公共模块
|    └── shik-pay-1 -- 支付 [port:9991]
├── shik-login -- 登录
|    ├── shik-login-common -- shik-login 公共模块
|    └── shik-login-1 -- 登录 [port:7771]
├── shik-upms -- 权限管理
|    ├── shik-upms-common -- shik-upms 公共模块
|    └── shik-upms-1 -- 权限管理 [port:2221]
├── shik-web -- web网站
|    ├── shik-web-common -- shik-web 公共模块
|    └── shik-web-1 -- web网站 [port:3331]
└── shik-admin -- 后台管理
     ├── shik-admin-common -- shik-admin 公共模块
     └── shik-admin-1 -- 后台管理 [port:6661]
```

## 模块介绍
### shik-RA
- 注册中心

### shik-zuul
- 路由网关
- 负载均衡
- 请求转发

### shik-config
- 公共配置中心
- 集成spring cloud bus, 实现公共配置的热更新并向eureka实例发送通知

### shik-common (util jar包)
- shik-common为shik项目公共部分，提供pom依赖、config-repo和util等

### shik-jdbc (util jar包)
- mysql操作工具
- jpa
- mybatis

### shik-redis (util jar包)
- redis操作工具
- jedis

### shik-pay
- 支付module
- Alipay
- WeChat

### shik-upms
- 权限管理

### shik-login
- 登录系统

### shik-admin
- 后台管理

### shik-web
- 网站