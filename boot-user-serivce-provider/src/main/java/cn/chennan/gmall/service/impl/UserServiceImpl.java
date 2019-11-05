package cn.chennan.gmall.service.impl;

import cn.chennan.gmall.bean.UserAddress;
import cn.chennan.gmall.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@com.alibaba.dubbo.config.annotation.Service //暴露服务
public class UserServiceImpl implements UserService {

    @HystrixCommand
    public List<UserAddress> getUserAddressList(String userId) {
        System.out.println("UserServiceImpl.....old...");
        // TODO Auto-generated method stub
        UserAddress address1 = new UserAddress(1, "北京市昌平区宏福科技园综合楼3层", "1", "李老师", "010-56253825", "Y");
        UserAddress address2 = new UserAddress(2, "深圳市宝安区西部硅谷大厦B座3层（深圳分校）", "1", "王老师", "010-56253825", "N");
        if(Math.random() > 0.5){
            throw new RuntimeException();
        }
		//try {
		//	Thread.sleep(2000);
		//} catch (InterruptedException e) {
		//	// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
        return Arrays.asList(address1, address2);
    }

}
