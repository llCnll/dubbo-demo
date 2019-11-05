package cn.chennan.gmall.config;

import cn.chennan.gmall.service.UserService;
import com.alibaba.dubbo.config.*;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

/**
 * @author ChenNan
 * @date 2019-10-30 下午1:13
 **/
public class MyDubboConfig {
/*
    dubbo.application.name=boot-user-service-provider
    dubbo.registry.address=127.0.0.1:2181
    dubbo.registry.protocol=zookeeper

    dubbo.protocol.name=dubbo
    dubbo.protocol.port=20880

    dubbo.monitor.protocol=registry
*/
    @Bean
    public ApplicationConfig applicationConfig(){
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("boot-user-service-provider");
        return applicationConfig;
    }

    @Bean
    public RegistryConfig registryConfig(){
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("127.0.0.1:2181");
        registryConfig.setProtocol("zookeeper");
        return registryConfig;
    }

    @Bean
    public MonitorConfig monitorConfig(){
        MonitorConfig monitorConfig = new MonitorConfig();
        monitorConfig.setProtocol("registry");
        return monitorConfig;
    }
/*
<dubbo:service interface="cn.chennan.gmall.service.UserService" ref="userServiceImpl01" version="1.0.0">
        <dubbo:method name="getUserAddressList" timeout="3000"></dubbo:method>
    </dubbo:service>
*/
    @Bean
    public ServiceConfig<UserService> userServiceServiceConfig(UserService userService){
        ServiceConfig<UserService> userServiceServiceConfig = new ServiceConfig<>();
        userServiceServiceConfig.setInterface("cn.chennan.gmall.service.UserService");
        userServiceServiceConfig.setRef(userService);
        userServiceServiceConfig.setVersion("1.0.0");

        //配置每一个method的信息
        MethodConfig methodConfig = new MethodConfig();
        methodConfig.setName("getUserAddressList");
        methodConfig.setTimeout(1000);
        ArrayList<MethodConfig> objects = new ArrayList<>();

        objects.add(methodConfig);
        userServiceServiceConfig.setMethods(objects);

        return userServiceServiceConfig;
    }

}