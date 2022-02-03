# JavaSpringBoot-MySqlDemo
喵喵尝试配置了SpringBoot并连接自己本地的MySql，尝试学习的朋友一定要记得改好application.properties

## quick-start

1. 点击`Code`,下载本项目..喵.....
   - 注意`git remote set-url origin https://<your_token>@github.com/<USERNAME>/<REPO>.git`

2. 启动本地Mysql，进入自己任一数据库执行一下sql文件建表

   ``` sql
   -- ----------------------------
   -- Table structure for user_info 是否使用utf8mb4自己决定
   -- ----------------------------
   DROP TABLE IF EXISTS `user_info`;
   CREATE TABLE `user_info`  (
     `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
     `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
     `sex` int(1) NULL DEFAULT NULL COMMENT '性别',
     `create_date` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建日期',
     PRIMARY KEY (`id`) USING BTREE
   ) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户信息表' ROW_FORMAT = Dynamic;
   
   -- ----------------------------
   -- Records of user_info
   -- ----------------------------
   INSERT INTO `user_info` VALUES (1, '小王', 0, '2019-11-05 10:06:36');
   INSERT INTO `user_info` VALUES (2, '小明', 0, '2019-11-05 10:06:36');
   INSERT INTO `user_info` VALUES (4, '小红', 1, '2019-11-05 10:06:36');
   INSERT INTO `user_info` VALUES (8, '小孙', 0, '2019-11-05 10:02:20');
   INSERT INTO `user_info` VALUES (9, '三叶', 1, '2019-11-05 10:06:36');
   INSERT INTO `user_info` VALUES (10, '梨花', 1, '2019-11-05 10:47:52');
   ```

3. 根据自己的Mysql配置填写项目文件`application_example.properties`最后重命名为`application.properties`

   - **要注意驱动配置**mysql 5.X版本使用com.mysql.jdbc.Driver，6以后使用com.mysql.cj.jdbc.Driver
   
4. 启动服务（在`SpringbootMysqlMybatisDemoApplication.java`文件处）

5. 使用如像PostMan等程序 测试接口 Code 如下，结果获得小明信息

   ```shell
   curl --location --request GET 'http://localhost:8066/user/getUserInfoById?id=2
   '
   ```
6. 完成喵，自己可以根据需要进行魔改喵 

## 可能的问题

- 如果报错 Public Key Retrieval is not allowed，要在application.properties文件中的spring.datasource.url的内容后添加`&allowPublicKeyRetrieval=true`

## 参考

- Springboot整合mysql和mybatis步骤  
  文章地址：https://blog.csdn.net/weixin_43841693/article/details/102921770

