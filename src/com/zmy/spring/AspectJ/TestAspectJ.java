package com.zmy.spring.AspectJ;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestAspectJ {
    public static void main(String[] args) {
        /*TalkShow talkShow = new TalkShow();
        talkShow.perform();*/
        Audience audience = (Audience) new AnnotationConfigApplicationContext().getBean("audience");
        System.out.println(audience);
    }
}
