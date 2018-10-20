Spring Boot中的自定义start pom

在平时的开发中，我们有时候可以自定义springboot启动器，达到自动配置的效果，比如，shiro框架，其中有许多的一些配置，如果自定义规范之后，无非都是重复相同的配置，此时我们就可以自定义启动器，达到自动配置的效果了

此代码只是实现了一个简单的自定义启动器的demo，用于学习springboot自动配置的原理

---

SpringBoot 自动配置主要通过 @EnableAutoConfiguration, @Conditional, @EnableConfigurationProperties 或者 @ConfigurationProperties 等几个注解来进行自动配置完成的。

@EnableAutoConfiguration 开启自动配置，主要作用就是调用 Spring-Core 包里的 loadFactoryNames()，将 autoconfig 包里的已经写好的自动配置加载进来。

@Conditional 条件注解，通过判断类路径下有没有相应配置的 jar 包来确定是否加载和自动配置这个类。

@EnableConfigurationProperties 的作用就是，给自动配置提供具体的配置参数，只需要写在application.properties 中，就可以通过映射写入配置类的 POJO 属性中。

---

@EnableAutoConfiguration

@Enable*注释并不是SpringBoot新发明的注释，Spring 3框架就引入了这些注释，用这些注释替代XML配置文件。比如：

@EnableTransactionManagement注释，它能够声明事务管理

@EnableWebMvc注释，它能启用Spring MVC

@EnableScheduling注释，它可以初始化一个调度器。

这些注释事实上都是简单的配置，通过@Import注释导入。

从启动类的@SpringBootApplication进入，在里面找到了@EnableAutoConfiguration









找到selectImports()方法，他调用了getCandidateConfigurations()方法，在这里，这个方法又调用了Spring Core包中的loadFactoryNames()方法。这个方法的作用是，会查询META-INF/spring.factories文件中包含的JAR文件。	









下面我们看看自动配置的代码：



1）@ConditionOnClass激活一个配置，当类路径中存在这个类时才会配置该类

2）@EnableConfigurationProperties自动映射一个POJO到Spring Boot配置文件（默认是application.properties文件）的属性集。

3）@ConditionalOnMissingBean启用一个Bean定义，但必须是这个Bean之前未定义过才有效。

还可以使用@ AutoConfigureBefore注释、@AutoConfigureAfter注释来定义这些配置类的载入顺序

着重了解@Conditional注释，Spring 4框架的新特性

此注释使得只有在特定条件满足时才启用一些配置。SrpingBoot的AutoConfig大量使用了@Conditional，它会根据运行环境来动态注入Bean。这里介绍一些@Conditional的使用和原理，并自定义@Conditional来自定义功能。

@Conditional是SpringFramework的功能，SpringBoot在它的基础上定义了

@ConditionalOnClass，@ConditionalOnProperty等一系列的注解来实现更丰富的内容。

具体几个@Conditon*注解的含义

@ConditionalOnBean

仅仅在当前上下文中存在某个对象时，才会实例化一个Bean

@ConditionalOnClass

某个class位于类路径上，才会实例化一个Bean)，该注解的参数对应的类必须存在，否则不解析该注解修饰的配置类

@ConditionalOnExpression

当表达式为true的时候，才会实例化一个Bean

@ConditionalOnMissingBean

仅仅在当前上下文中不存在某个对象时，才会实例化一个Bean，该注解表示，如果存在它修饰的类的bean，则不需要再创建这个bean，可以给该注解传入参数例如@ConditionOnMissingBean(name = "example")，这个表示如果name为“example”的bean存在，这该注解修饰的代码块不执行

@ConditionalOnMissingClass

某个class类路径上不存在的时候，才会实例化一个Bean

@ConditionalOnNotWebApplication

不是web应用时，才会执行

---

Properties系列注释

@ConfigurationProperties(prefix = "example.user")

在需要注入配置的类上加上这个注解，prefix的意思是，以该前缀打头的配置，以下是例子


---

总结

	好好学习	，天天向上