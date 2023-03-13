package tobyspring.hello;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import tobyspring.hello.SimpleHelloService;

public class HelloServiceTest {
    @Test
    void simpleHelloService(){
        SimpleHelloService helloService = new SimpleHelloService();
        String ret = helloService.sayHello("test");

        Assertions.assertThat(ret).isEqualTo("Hello test");

    }

    @Test
    void helloDecorator(){
        HelloDecorator decorator = new HelloDecorator(name -> name);

        String ret = decorator.sayHello("Test");

        Assertions.assertThat(ret).isEqualTo("*Test*");
    }

}
