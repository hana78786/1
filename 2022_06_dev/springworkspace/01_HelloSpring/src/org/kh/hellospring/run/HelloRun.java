package org.kh.hellospring.run;

import org.kh.hellospring.MessageBean;
import org.kh.hellospring.MessageBeanHello;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloRun {
	
public static void main(String[] args) {
	ApplicationContext ctx= new GenericXmlApplicationContext("spring-context.xml");
	//ApplicationContext : BeanFactory Bean들을 관리함
	//빈 목록들이 xml파일에 들어가있기때문에 GenericXmlApplicationContext가 xml과 연결함
	MessageBean bean = (MessageBeanHello)ctx.getBean("messageBean");
	//getBean은 messagBean이라는 id를 오브젝트를 가지고 옴 그래서 messageBeanHello 메소드를 사용할 것이기때문에 형변환해줌
	//bean은 spring컨테이너에 있는 객체 xml을 통해서 빈으로 등록한다
	bean.sayHellow("spring ^^");
}
}
