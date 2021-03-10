这个是我博客的后端，采用springboot来写的。
我之前用ssm写了一个[博客](https://github.com/circle111/khole_blog)。
现在又要重构，之前的ssm博客是重构我之前的用node.js写的一个简单的博客后台。
这次会写的更多一点，增加类型管理，添加标签和评论等功能。

这次会用到的技术栈是：springboot、maven、mybatis、mysql、druid、shiro、swagger、pagehelper分页助手、fastJSON、JSR303校验

依旧采用前后端分离的方式来写我的博客。接口风格采用RESTful风格。

SpringBoot开启事务用注解，笨

SpringBoot整合MyBatis分页助手

引入分页助手依赖
```xml
<!-- SpringBoot整合MyBatis分页助手 -->
 <dependency>
     <groupId>com.github.pagehelper</groupId>
     <artifactId>pagehelper-spring-boot-starter</artifactId>
     <version>1.2.12</version>
 </dependency>
```
查询前设置分页，最后将将查询结果封装为PageInfo即可
```
/**
 * 测试接口：http://localhost:8080/queryListPersonPage
 * 请求方式：GET      返回值：查询结果集，分页查询
 */
@RequestMapping(value = "/queryListPersonPage",method = RequestMethod.GET)
public PageInfo<Person> queryListPersonPage() {
    //1.执行分页
    PageHelper.startPage( 1, 2) ;
    //2.执行查询
    List<Person> list = personService.queryListPersonPage();
    //3.封装PageInfo对象
    PageInfo<Person> pageInfo = new PageInfo<Person> (list);
    return pageInfo;
}
```