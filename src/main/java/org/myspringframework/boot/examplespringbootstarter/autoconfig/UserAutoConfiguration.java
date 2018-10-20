package org.myspringframework.boot.examplespringbootstarter.autoconfig;

import org.myspringframework.boot.examplespringbootstarter.service.UserService;
import org.myspringframework.boot.examplespringbootstarter.entity.User;
import org.myspringframework.boot.examplespringbootstarter.property.UserProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author guojianfeng.
 * @Date Created in  2018/10/19
 * @Description：
 */
@Configuration
@EnableConfigurationProperties({UserProperties.class})
@ConditionalOnClass(UserService.class)
public class UserAutoConfiguration {

    @Autowired
    private UserProperties userProperties;
    @Bean
    @ConditionalOnMissingBean(UserService.class)
    public UserService userService(){
        UserService userService = new UserService();
        User user = new User();
        user.setAge(userProperties.getAge());
        user.setBirthday(userProperties.getBirthday());
        user.setBoss(userProperties.getBoss());
        user.setFeature(userProperties.getFeature());
        user.setPhone(userProperties.getPhone());
        user.setUsername(userProperties.getUsername());
        userService.setUser(user);
        System.out.println("**********************************");
        System.out.println(" i have a user");
        System.out.println("**********************************");
        return userService;
    }

}
