package cn.chennan.gmall.service.impl;

import cn.chennan.gmall.bean.UserAddress;
import cn.chennan.gmall.service.OrderService;
import cn.chennan.gmall.service.UserService;
import com.alibaba.dubbo.config.annotation.Reference;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.callback.Callback;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1. 犟服务提供者注册到注册中心
 *      1) 导入dubbo依赖 操作zk的客户端
 *      2) 配置服务提供者
 * 2. 让服务消费者去注册中心订阅服务地供着的服务地址
 * @author ChenNan
 * @date 2019-10-29 下午5:59
 **/
@Service
public class OrderServiceImpl implements OrderService {

    //@Autowired
    @Reference(loadbalance = "random")/*(url="127.0.0.1:20880")*/
    UserService userService;

    @HystrixCommand(fallbackMethod = "hello")
    public List<UserAddress> initOrder(String userId) {
        System.out.println("用户Id = "+ userId);
        List<UserAddress> addressesList = userService.getUserAddressList(userId);
        return addressesList;
    }

    public List<UserAddress> hello(String userId) {
        return Arrays.asList(new UserAddress(1, "ceshi", "ceshi","ceshi", "ceshi", "ceshi"));
    }
}
