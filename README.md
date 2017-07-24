# Shik

Shik包含的所有module(非util)都支持分布式管理
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