# seata1.7 nacos2.0.2 springboot

MAIN SAMPLE REPO - https://gitee.com/fuyan_u/seata1.7-nacos2.0.2-springboot?_from=gitee_search
GRPC INTERCEPTOR - https://gitee.com/oschinajungle/springboot-grpc-seata-starter/tree/master

#### introduce
seata integrates nacos small demo

#### Software Architecture
Software architecture description


#### Code

Configure seata-AT related snapshots/global locks/snapshot table database

**Configuration Database**

TM database-seata

Source sql: seata-server-1.7.0/script/server/db
![Enter picture description](https://foruda.gitee.com/images/1701220753915106373/575e3d76_10767404.png "Screenshot")

Each RM database

Source sql: https://seata.io/zh-cn/docs/dev/mode/at-mode.html

![Enter picture description](https://foruda.gitee.com/images/1701220766608726288/cf9c4384_10767404.png "Screenshot")
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

**Configuration File**

Configure in the application.yml file, each microservice must

```yaml
#seata client configuration
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

#### test

Normal: http://localhost:8088/businesses/purchase?rollback=false&count=2

Overstock: http://localhost:8088/businesses/purchase?rollback=false&count=12

Excess balance: http://localhost:8088/businesses/purchase?rollback=false&count=8

#### Advantages and Disadvantages

**advantage**

-Complete direct transaction submission in one stage, release resources, and have better performance
- Use global locks to achieve read and write isolation
- No code intrusion, the framework automatically completes rollback and submission

shortcoming

- There is data inconsistency between the two stages, and only the final consistency can be guaranteed
- The snapshot function of the framework affects performance, but it is much better than XA mode
