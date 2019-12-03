## 麻匠社区


## 工具
[spring 文档](https://spring.io/guides)
[gitOAuth文档](https://developer.github.com/apps/building-oauth-apps/)
## 地址
视频第二十五讲


```sql
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `account_id` varchar(100) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `token` char(36) DEFAULT NULL,
  `gmt_create` bigint(19) DEFAULT NULL,
  `gmt_modified` bigint(19) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
```