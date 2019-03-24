#### SSM框架整合实例
开发一个简单的用户基本信息的管理网站，在数据库中存在的每一个用户都可以登录网站，然后在网站上进行用户的管理（增删改查）。

##### 项目目录结构

```
|--SSMTest
    |--src
        |--main
            |--java
                |--com.xf.ssm
                    |--controller
                        |--UserController.java
                    |--service
                        |--UserService.java
                        |--UserServiceImpl.java
                    |--dao
                        |--UserDao.java
                    |--model
                        |--User.java
            |--resources
                |--mappers
                    |--UserMapper.xml
                |--spring
                    |--applicationContext.xml
                    |--spring-mvc.xml
                |--log4j.properties
                |--mybatis-config.xml
            |--webapp
                |--WEB-INF
                    |--web.xml
                |--index.jsp
                |--login.jsp
                |--adduser.jsp
                |--updateuser.jsp
                |--userlist.jsp
        |--test
            |--java
                |--com.xf.ssm.test
                    |--UserDaoTest.java
                    |--UserServiceTest.java
    |--pom.xml
    |--ReadMe.md
```

##### 创建数据表

```sql
show databases ;
create database ssm;
use ssm;
create table user(
  id integer primary key auto_increment,
  name varchar(20),
  pwd varchar(20),
  sex varchar(10),
  age integer
);

insert into user(name, pwd, sex, age) values ("xf", "sfsf", "male", 23);

select * from user;
```

##### 配置相关文件

`web.xml`
```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
         version="4.0">

  <display-name>Archetype Created Web Application</display-name>

  <!-- 配置 Spring 核心监听器 -->
  <listener>
    <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
  </listener>

  <!-- 指定 Spring 的配置文件 -->
  <context-param>
    <param-name>contextConfigLocation</param-name>
    <param-value>classpath:spring/applicationContext.xml</param-value>
  </context-param>

  <!-- 定义 Spring MVC 前端控制器 -->
  <servlet>
    <servlet-name>spring-mvc</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>

    <init-param>
      <param-name>contextConfigLocation</param-name>
      <param-value>classpath:spring/spring-mvc.xml</param-value>
    </init-param>
    <load-on-startup>1</load-on-startup>
  </servlet>

  <!-- 为 DispatcherServlet 建立映射 -->
  <servlet-mapping>
    <servlet-name>spring-mvc</servlet-name>
    <url-pattern>/</url-pattern>
  </servlet-mapping>
  <listener>
    <listener-class>org.springframework.web.util.IntrospectorCleanupListener</listener-class>
  </listener>

  <!-- 编码过滤器 -->
  <filter>
    <filter-name>encodingFilter</filter-name>
    <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
    <init-param>
      <param-name>encoding</param-name>
      <param-value>UTF-8</param-value>
    </init-param>
    <init-param>
      <param-name>forceEncoding</param-name>
      <param-value>true</param-value>
    </init-param>
  </filter>

  <filter-mapping>
    <filter-name>encodingFilter</filter-name>
    <url-pattern>/*</url-pattern>
  </filter-mapping>

</web-app>
```

`applicationContext.xml`
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:tx="http://www.springframework.org/schema/tx"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx.xsd http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd">

    <!-- 自动扫描有 Spring 相关注解的类，并把这些类注册为 bean -->
    <context:component-scan base-package="com.xf.ssm" />

    <!-- 配置数据源 -->
    <bean id="dataSource"
          class="org.springframework.jdbc.datasource.DriverManagerDataSource">
        <property name="driverClassName" value="com.mysql.jdbc.Driver" />
        <property name="url" value="jdbc:mysql://localhost:3306/ssm" />
        <property name="username" value="root" />
        <property name="password" value="admin" />
    </bean>

    <!-- MyBatis 的 SqlSession 的工厂，并引用数据源，扫描 MyBatis 的配置文件 -->
    <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
        <property name="dataSource" ref="dataSource"/>
        <property name="configLocation" value="classpath:mybatis-config.xml" />
        <property name="mapperLocations" value="classpath*:mappers/**"/>
    </bean>

    <!-- MyBatis 自动扫描加载 Sql 映射文件/接口 -->
    <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
        <property name="basePackage" value="com.xf.ssm.dao"/>
        <property name="sqlSessionFactoryBeanName" value="sqlSessionFactory"/>
    </bean>

    <!-- JDBC 事务管理器 -->
    <bean id="txManager"
          class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <property name="dataSource" ref="dataSource"/>
    </bean>

    <!-- 启用支持 annotation 注解方式事务管理 -->
    <tx:annotation-driven transaction-manager="txManager" />

</beans>
```

`mybatis-config.xml`
```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <!-- 为JavaBean起类别名 -->
    <!--别名默认为 类名首字母小写-->
    <typeAliases>
        <package name="com.xf.ssm.model" />
    </typeAliases>

    <!-- 通过 mapper 接口包加载整个包的映射文件 -->
    <mappers>
        <package name="com.xf.ssm.mapper" />
    </mappers>
</configuration>
```

`spring-mvc.xml`
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:mvc="http://www.springframework.org/schema/mvc"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc.xsd">

    <!-- 自动扫描该包，Spring MVC 会将包下用 @Controller 注解的类注册为 Spring 的 controller -->
    <context:component-scan base-package="com.xf.ssm.controller" />
    <!-- 设置默认配置方案 -->
    <mvc:annotation-driven />
    <!-- 视图解析器 -->
    <bean id="viewResolver"
          class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="prefix" value="/" />
        <property name="suffix" value=".jsp" />
    </bean>
</beans>
```

`log4j.properties`
```xml
# Global logging configuration
log4j.rootLogger=DEBUG, stdout
# Console output...
log4j.appender.stdout=org.apache.log4j.ConsoleAppender
log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
log4j.appender.stdout.layout.ConversionPattern=%5p [%t] - %m%n
```

