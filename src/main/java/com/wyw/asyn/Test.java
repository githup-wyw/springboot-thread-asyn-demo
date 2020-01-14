package com.wyw.asyn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springboot-thread-asyn-demo
 * @description: Test
 * @author: Mr.WYW
 * @create: 2020-01-14 17:
 */
@RestController
public class Test {

    private static final Logger log = LoggerFactory.getLogger(Test.class);

    @Autowired
    Asyn asyn;

    @GetMapping("againTest")
    public void againTest(){
        log.info("方法==start");
        asyn.againTest();
        log.info("方法==end");

        // 单元测试，主线程会快会执行完，而子线程的方法需要睡眠3秒，会报睡眠超时
        // 解决办法：主线程后加大于子线程执行时间的睡眠
        try {

            Thread.sleep(10*1000);

        } catch (InterruptedException e) {

            // TODO Auto-generated catch block

            e.printStackTrace();

        }
    }
}
