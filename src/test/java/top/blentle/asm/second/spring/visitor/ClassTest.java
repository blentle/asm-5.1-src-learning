package top.blentle.asm.second.spring.visitor;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.jws.WebService;
import javax.management.MXBean;
import java.util.HashMap;

/**
 * @author :  renhuan
 * @email : blentle.huan.ren@gmail.com
 * @time :  2017/12/4 0004
 * @description :
 * @since : 1.0
 */
@MXBean
@WebService
@Configuration
public class ClassTest extends HashMap implements Runnable {

    @Resource
    @PostConstruct
    public void run() {
        System.err.println(".....");
    }


    class A {
        private int a;

    }

    class B {
        private int B;
    }
}
