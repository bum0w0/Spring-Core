package hello.core.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

class StatefulServiceTest {

    // 싱글톤 방식의 주의점
    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        int userA_price = statefulService1.order("userA", 10000);
        int userB_price = statefulService2.order("userB", 20000);

        // userA의 주문금액 10000원이 아닌 20000원이 반환되는 문제가 발생
//        int userA_price = statefulService1.getPrice();
        System.out.println("userA_price = " + userA_price);

//        assertThat(statefulService1.getPrice()).isEqualTo(20000);
    }

    static class TestConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }

}