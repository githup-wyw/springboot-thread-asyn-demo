package com.wyw;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootThreadAsynDemoApplicationTests {

    @Autowired
    com.wyw.asyn.Test test;

    @Test
    public void contextLoads() {
        test.againTest();
    }

}
