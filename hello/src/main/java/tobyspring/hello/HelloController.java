package tobyspring.hello;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;

@RequestMapping("/hello")
@Component
public class HelloController {
    private final HelloService helloService;
    private final ApplicationContext applicationContext;

    public HelloController(HelloService helloService, ApplicationContext applicationContext) {
        this.helloService = helloService;
        this.applicationContext = applicationContext;

        System.out.println(applicationContext);
    }

    @GetMapping
    @ResponseBody //값을 반환해줄 어노테이션이 필요함 RestController로 만들면 기본ㄷ적으로 Respons가 가능함
    public String hello(String name) {
        return helloService.sayHello(Objects.requireNonNull(name));
    }


}
