package cn.chennan.gmail;

import cn.chennan.gmall.bean.UserAddress;
import cn.chennan.gmall.service.OrderService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.List;

/**
 * @author ChenNan
 * @date 2019-10-29 下午6:47
 **/
public class MainApplication {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("consumer.xml");

        System.in.read();
        OrderService orderService = ioc.getBean(OrderService.class);
        List<UserAddress> addresses = orderService.initOrder("1");

        for (UserAddress address : addresses) {
            System.out.println(address);
        }
        System.in.read();
    }
}
