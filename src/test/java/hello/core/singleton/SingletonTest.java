package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;



public class SingletonTest {
    @Test
    @DisplayName("스프링이 없는 순수 DI 컨테이너")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();

        // 회원 서비스를 호출할 때 마다 객체를 생성하게됨. (클라이언트가 요청하는만큼 객체가 생성되면 메모리를 많이 차지)
        // 중복되는 로직을 구현하는 객체가 딱 1개 생성되고 공유하도록 설계하는것 -> 싱글톤 패턴

        MemberService memberService1 = appConfig.memberService();

        MemberService memberService2 = appConfig.memberService();

        // 출력하면 참조값이 다름 (매번 다른 객체가 생성된다는 의미)
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        // 출력문 찍어서 눈으로 확인하기보다 JUnit이 제공하는 메소드를 사용하자 (시스템이 판단하도록)
        // memberService1 != memberService2
        assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest() {
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        // 같은 참조값을 가진다. 호출할 때 마다 같은 객체를 반환
        System.out.println("singletonService1 = " + singletonService1);
        System.out.println("singletonService2 = " + singletonService2);

        assertThat(singletonService1).isSameAs(singletonService2);
        singletonService1.logic();
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer() {

//        AppConfig appConfig = new AppConfig();
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService1 = ac.getBean("memberService", MemberService.class);

        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        // 참조값 같음
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        assertThat(memberService1).isSameAs(memberService2);
    }

}