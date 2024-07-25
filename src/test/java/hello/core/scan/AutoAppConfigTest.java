package hello.core.scan;

import hello.core.AutoAppConfig;
import hello.core.member.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class AutoAppConfigTest {

    // 테스트 시 설정 정보로 AutoAppConfig 클래스를 넘겨주고 컴포넌트 스캔이 잘 동작하는지 확인
    @Test
    void basicScan() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);
    }
    // 콘솔 확인 (빈이 잘 등록되고 있다.)
    // Creating shared instance of singleton bean 'rateDiscountPolicy'
    // Creating shared instance of singleton bean 'memberServiceImpl'
    // Creating shared instance of singleton bean 'memoryMemberRepository'
}
