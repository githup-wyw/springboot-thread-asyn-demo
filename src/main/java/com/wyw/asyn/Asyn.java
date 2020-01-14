package com.wyw.asyn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @program: springboot-thread-asyn-demo
 * @description: Again
 * @author: Mr.WYW
 * @create: 2020-01-14 16:异步方法
 */
@Component
public class Asyn {

    /**
     * 注意：异步方法不能和上层处在同一类下，否则失效
     */

    private static final Logger log = LoggerFactory.getLogger(Asyn.class);

    @Async
    public void againTest(){
        log.info("异步的方法==start");
        try {
            Thread.sleep(1000 * 3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("异步的方法==end");
    }


}
