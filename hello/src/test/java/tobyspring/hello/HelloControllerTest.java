package tobyspring.hello;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class HelloControllerTest {


    @Test
    void HelloController(){
        HelloController helloController = new HelloController(name -> name);
       String ret =  helloController.hello("test");

        Assertions.assertThat(ret).isEqualTo("test");
    }

    @Test
    void failHelloController(){
        HelloController helloCotroller = new HelloController(name -> name);

            Assertions.assertThatThrownBy(()->{
                 helloCotroller.hello(null);

            }).isInstanceOf(IllegalArgumentException.class);

        Assertions.assertThatThrownBy(()->{
            helloCotroller.hello("");

        }).isInstanceOf(IllegalArgumentException.class);
        }
}


