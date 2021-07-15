package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class StatefulServiceTest {
    @Test
    void statefulServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class); //스프링 컨테이너
        StatefulService statefulService1 = ac.getBean(StatefulService.class); // 빈 조회
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

//        statefulService1.order("userA", 10000); //A사용자가 만원 주문
        int userAPrice = statefulService1.order("userA", 10000); //객체 공유하지 않고 지역변수로

//        statefulService2.order("userB", 20000); //B사용자가 이만원 주문
        int userBPrice = statefulService2.order("userB", 20000);

//        int price = statefulService1.getPrice(); //A 주문 금액 조회
        System.out.println("A price = " + userAPrice);
        System.out.println("B price = " + userBPrice);

//        Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);
    }

    static class TestConfig{

        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }
}
