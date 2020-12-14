package com.zmy.spring.AspectJ;

/*import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;*/

/*@Configuration
@EnableAspectJAutoProxy // 启动AspectJ自动代理
@ComponentScan*/
public class ConcertConfig {

    public Audience audience(){  // 声明Audience bean
        return new Audience();
    }
}
