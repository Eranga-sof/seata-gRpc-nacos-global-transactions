# seata1.7 nacos2.0.2 springboot

MAIN SAMPLE REPO - https://gitee.com/fuyan_u/seata1.7-nacos2.0.2-springboot?_from=gitee_search
GRPC INTERCEPTOR - https://gitee.com/oschinajungle/springboot-grpc-seata-starter/tree/master

#### 介绍
seata整合nacos小Demo

#### 软件架构
软件架构说明


#### 代码

配置seata-AT相关快照/全局锁/快照表数据库

**配置数据库**

TM数据库-seata

源sql： seata-server-1.7.0/script/server/db 中
![输入图片说明](https://foruda.gitee.com/images/1701220753915106373/575e3d76_10767404.png "屏幕截图")

各个RM数据库

源sql： https://seata.io/zh-cn/docs/dev/mode/at-mode.html

![输入图片说明](https://foruda.gitee.com/images/1701220766608726288/cf9c4384_10767404.png "屏幕截图")
```sql
CREATE TABLE `undo_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `branch_id` bigint(20) NOT NULL,
  `xid` varchar(100) NOT NULL,
  `context` varchar(128) NOT NULL,
  `rollback_info` longblob NOT NULL,
  `log_status` int(11) NOT NULL,
  `log_created` datetime NOT NULL,
  `log_modified` datetime NOT NULL,
  `ext` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ux_undo_log` (`xid`,`branch_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

```

**配置文件**

在application.yml文件中配置， 每个微服务都要

```yaml
#seata客户端配置
seata:
  enabled: true
  application-id: seata_tx
  tx-service-group: seata_tx_group
  service:
    vgroup-mapping:
      seata_tx_group: default
  registry:
    type: nacos
    nacos:
      application: seata-server
      server-addr: 127.0.0.1:8848
      namespace:
      group: DEFAULT_GROUP
  data-source-proxy-mode: AT
```

#### 测试

正常：http://localhost:8088/businesses/purchase?rollback=false&count=2

超库存：http://localhost:8088/businesses/purchase?rollback=false&count=12

超余额：http://localhost:8088/businesses/purchase?rollback=false&count=8

#### 优缺点

**优点**

- 一阶段完成直接提交事务，释放资源，性能较好
- 利用全局锁实现读写隔离
- 没有代码侵入，框架自动完成回滚与提交

缺点

- 两阶段之间存在数据不一致情况，只能保证最终一致
- 框架的快照功能影响性能，但比XA模式要好很多



