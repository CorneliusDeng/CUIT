package com.dateme.demo;

import com.dateme.demo.bean.BlogBean;
import com.dateme.demo.service.BlogService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    BlogService blogService;

    @Test
    void contextLoads() {

    }

}
