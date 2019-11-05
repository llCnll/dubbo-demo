package cn.chennan.gmall;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * 导入依赖
 *     1) 导入 dubbo-starter
 *     2) 导入 dubbo 的其他依赖
 *
 *     springBoot与dubbo整合的三种方式
 *     1) 导入dubbo-starter 在application.properties配置属性, 使用@Service暴露服务和使用@Reference 前提要开启@EnableDubbo
 *     2) 保留dubboxml配置文件 导入dubbo-starter 使用@ImportResource(locations="classpath:provider.xml") //就不需要用注解了
 *     3) 使用注解api 将每一个组件手动创建到容器中
 */
@EnableDubbo//开启基于注释的dubbo功能
@SpringBootApplication
@EnableHystrix
public class BootUserSerivceProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootUserSerivceProviderApplication.class, args);
    }

}
