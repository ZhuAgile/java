package com.zmy.spring.soundsystem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) // 使用了spring的SpringJUnit4ClassRunner，以便在测试的开始的时候自动创建Spring应用上下文
@ContextConfiguration(classes=CDPlayerConfig.class) // @ContextConfiguration会告诉它需要在CDPlayConfig中加载配置。
public class CDPlayerTest {
    @Autowired
    private CompactDisc cd;

    @Test
    public void CDShouldNotBeNull(){
        if (cd == null) {
            System.out.println("cd is null");
        }else {
            System.out.println("cd is not null");
        }
    }
}
