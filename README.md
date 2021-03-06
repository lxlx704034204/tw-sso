

## boot-java-study
[ifelse.no.strategy3]
    https://blog.csdn.net/liuchang840302/article/details/83894907  if-else重构解决：卫语句、策略模式、状态模式等 
        1.卫语句   
        2.策略模式：
        3.状态模式
    状态模式 与 策略模式 代码形式相似，但是状态模式会影响后续行为。
    
[ifelse.no.statepattern] 
    https://blog.csdn.net/u012401711/article/details/52675873 Java设计模式——状态模式（STATE PATTERN） statepattern图解.png
    其他：
    https://blog.csdn.net/laner0515/article/details/7383872         你还在用if else吗？——状态模式、职责链模式
    https://blog.csdn.net/liuyukuan/article/details/27378259        使用状态模式(state pattern)替代if else 



## 如何交流、反馈、参与贡献？
- Git仓库：https://gitee.com/theodo/jeefast
- QQ交流群：583154815
- 如需关注项目最新动态，请Watch、Star项目

## 效果图
![输入图片说明]( //gitee.com/uploads/images/2017/1106/212319_6de26405_718698.jpeg "登录.jpg")



# 项目简介
    本项目核心设计目的是提供企业级的单点登录,会话管理,权限认证。
    子应用只需依赖sso-common,简单配置后项目中即可调用sso-server提供的主数据,权限,日志等服务；
    优点：开发迅速、学习简单、轻量级、易扩展，支持与Spring-Cloud无缝集成。
    
    登录账户：admin  密码：1234

# 环境要求
    1.jdk1.8 +
    2.redis mysql
    3.maven
    4.开发工具:eclipse/idea
    5.采用技术SpringBoot,Spring-Session,Redis,Mysql,sso-server端前端采用easyui


# Features
    1.提供企业级组织架构(公司/部门/岗位),主数据管理,RBAC权限设计
    2.统一会话管理,统一配置权限/子应用菜单
    3.应用横向拓展,支持nginx,spring-cloud负载均衡,支持docker
    4.Redis异步汇集日志(LogUtil)
    5.简单的鉴权操作(AuthUtil,注解,jsp标签)
    6.可以很方便的在此基础上开发更多通用功能
    7.10万用户同时在线时,redis内存占用大约为300M

# 预览
<p align="center">
        用户管理
    <img src='https://github.com/yzgod/tw-sso/blob/master/docs/images/1.png' />
        菜单管理
    <img src='https://github.com/yzgod/tw-sso/blob/master/docs/images/3.png' />
        授权管理
    <img src='https://github.com/yzgod/tw-sso/blob/master/docs/images/5.png' />
        基础服务
    <img src='https://github.com/yzgod/tw-sso/blob/master/docs/images/7.png' />
        应用管理
    <img src='https://github.com/yzgod/tw-sso/blob/master/docs/images/8.png' />
</p>

