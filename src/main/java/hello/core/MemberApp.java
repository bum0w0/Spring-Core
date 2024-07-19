package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        //ApplicationContext를 스프링 컨테이너라고 한다.
        // 컨테이너에 Bean으로 등록된 객체들을 applicationContext 객체가 다 관리함 (AppConfig 클래스에서 어노테이션으로 빈 등록을 헸으니 아래와 같이 생성)
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        // 관례적으로 객체명은 ac 라고 함, 파라미터 값에 이름은 메소드 이름이 들어감 (이 메소드의 객체를 찾겠다.) 두번째 파라미터는 타입
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}