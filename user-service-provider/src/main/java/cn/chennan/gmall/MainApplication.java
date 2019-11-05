package cn.chennan.gmall;

import javafx.application.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author ChenNan
 * @date 2019-10-29 下午6:47
 **/
public class MainApplication {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("provider.xml");


        ioc.start();

        System.in.read();

    }
}
