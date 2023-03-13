package tobyspring.hello;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class HelloController {
 private final HelloService helloService;
 public HelloController(HelloService helloService){
     this.helloService = helloService;
 }

    @GetMapping("/hello")
    @ResponseBody //값을 반환해줄 어노테이션이 필요함 RestController로 만들면 기본ㄷ적으로 Respons가 가능함
    public String hello(String name) {
        if(name==null||name.trim().length() == 0) throw new IllegalArgumentException();
        return helloService.sayHello(Objects.requireNonNull(name));
    }


}
