package cn.chennan.gmall.controller;

import cn.chennan.gmall.bean.UserAddress;
import cn.chennan.gmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author ChenNan
 * @date 2019-10-29 下午7:54
 **/
@Controller
public class OrderController {

    @Autowired
    OrderService orderService;

    @ResponseBody
    @RequestMapping("/initOrder")
    public List<UserAddress> initOrder(@RequestParam("uid")String uid){
        return orderService.initOrder(uid);
    }
}
