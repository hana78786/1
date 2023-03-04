package tobyspring.hello;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class SimpleHelloService implements HelloService {
    @Override
    public String sayHello(String name){

        return "Hello "+name;
    }
}
