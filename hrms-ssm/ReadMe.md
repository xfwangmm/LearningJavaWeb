### SSM 搭建简易的人事管理系统
无前端页面，使用MockMvc进行web测试

参考
- [实验楼 SSM + easyUI 搭建简易的人事管理系统](https://www.shiyanlou.com/courses/824)
- [ZHENFENG13/ssm-demo](https://github.com/ZHENFENG13/ssm-demo)

#### 系统架构
```
                  人事管理系统
                       |
      -----------------------------------
     |        |        |        |        |
 系统管理  部门管理  职位管理  员工管理  公告管理
```
##### 功能
1. 系统管理：添加管理员、删除管理员、修改管理员和查询管理员（全部查询和按用户名模糊查询）
2. 部门管理：添加部门、删除部门、修改部门和查询部门（全部查询和按部门名称模糊查询）
3. 职位管理：添加职位、删除职位、修改职位和查询职位（全部查询和按职位名称模糊查询）
4. 员工管理：添加员工、删除员工、修改员工和查询员工（全部查询和按员工编号、员工姓名、部门、职位和性别模糊查询）
5. 公告管理：添加公告、删除公告、修改公告和查询公告（全部查询和按公告标题模糊查询）

##### 实现
1. 表现层：MockMvc模拟测试
2. MVC 控制器层：Spring MVC 技术，由一系列控制器组成。
3. 业务逻辑层：Spring 技术，由一系列的业务逻辑对象组成。
4. DAO 层：MyBatis 框架，由一系列的 DAO 组件组成，这些 DAO 实现了对数据库的创建、查询、更新和删除（CRUD）等原子操作。
5. Domain Object 层：由一系列的 POJO（Plain Old Java Object，即普通的、传统的Java对象）组成，是一些简单的 Java Bean 类。
6. 数据库：MySQL 数据库，存储持久化数据。

#### 创建数据表
```sql
show databases ;
create database hrms;
use hrms;
show databases ;

# 创建管理员表
create table admin(
  admin_id int primary key auto_increment not null ,
  username varchar(20) not null ,
  password varchar(20) not null ,
  user_role varchar(20) not null
);

insert into admin (username, password, user_role)
values ("admin_test", "test", "test");

# 创建公告表
create table post(
  post_id int auto_increment not null ,
  post_title varchar(50) not null ,
  post_content text,
  admin_id int not null ,
  create_date date not null ,
  primary key (post_id),
  foreign key (admin_id) references admin(admin_id)
);

insert into post (post_title, post_content, admin_id, create_date)
values ("post test", "hello this is post test", 1, "2019-2-23 16:00:12");

# 创建部门表
create table department(
  dept_id int auto_increment not null ,
  dept_name varchar(30) not null ,
  dept_desc text,
  primary key (dept_id)
);

insert into department (dept_name, dept_desc)
values ("dept_name_test", "this is dept test");

# 创建职位表
create table postion(
  pos_id int primary key auto_increment not null ,
  pos_name varchar(20) not null ,
  pos_desc text
);

insert into postion (pos_name, pos_desc)
values ("pos name" , "pos desc");

# 创建员工表
create table employee(
  emp_id int auto_increment not null ,
  emp_name varchar(20) not null ,
  emp_sex varchar(20) not null ,
  emp_phone varchar(20) not null ,
  emp_email varchar(30) not null,
  emp_address varchar(30) not null ,
  emp_education varchar(30) not null ,
  emp_birthday varchar(20) not null ,
  dept_id int not null ,
  pos_id int not null ,
  primary key (emp_id),
  foreign key (dept_id) references department(dept_id),
  foreign key (pos_id) references postion(pos_id)
);

insert into employee (emp_name, emp_sex, emp_phone, emp_email, emp_address, emp_education, emp_birthday, dept_id,
                      pos_id)
values ("emp name", "emp sex", "emp phone", "emp email", "emp address", "emp_education", "emp_birthday", 1, 1);
```

#### 项目结构
```
+-hrms
|   +-src
|   |   +-main
|   |   |   +-java
|   |   |   |   +-com.xf.hrms
|   |   |   |   |   +-controller
|   |   |   |   |   |   --AdminController.java
|   |   |   |   |   +-service
|   |   |   |   |   |   --AdminService.java
|   |   |   |   |   |   --AdminServiceImpl.java
|   |   |   |   |   +-dao
|   |   |   |   |   |   --AdminDao
|   |   |   |   |   +-domain
|   |   |   |   |   |   --Admin.java
|   |   |   |   |   |   --Post.java
|   |   |   |   |   |   --Depertment.java
|   |   |   |   |   |   --Position.java
|   |   |   |   |   |   --Emplloyee.java
|   |   |   |   |   +-interceptor
|   |   |   |   |   +-utils
|   |   |   |   |   |   --DateUtils.java
|   |   |   |   |   |   --IntegrateObject.java
|   |   |   |   |   |   --JsonDateValueProcessor.java
|   |   |   |   |   |   --ResponseUtils.java
|   |   |   +-resources
|   |   |   |   +-mappers
|   |   |   |   |   --AdminMapper.xml
|   |   |   |   --spring.xml
|   |   |   |   --spring-mvc.xml
|   |   |   |   --mybatis-config.xml
|   |   |   |   --jdbc.properties
|   |   |   |   --log4j.properties
|   |   |   +-webapp
|   |   |   |   +-WEB-INF
|   |   |   |   |   --web.xml
|   |   |   |   --index.jsp
|   |   +-test
|   |   |   +-java
|   |   |   |   +-com.xf.hrms.test
|   |   |   |   |   --AdminDaoTest.java
|   |   |   |   |   --AdminServiceTest.java
|   |   |   |   |   --AdminControllerTest.java
```

###### domain

