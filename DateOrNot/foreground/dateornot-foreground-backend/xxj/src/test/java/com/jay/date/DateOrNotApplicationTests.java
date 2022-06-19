package com.jay.date;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.locks.LockSupport;

@SpringBootTest
class DateOrNotApplicationTests {

    @Test
    void contextLoads() throws InterruptedException {
        Thread t1 = new Thread(()->{
            System.out.println("t1 start");
            LockSupport.park();
            System.out.println("t1 unPark");
        }, "t1");
        t1.start();

        Thread.sleep(5000);
        LockSupport.unpark(t1);

    }

}
