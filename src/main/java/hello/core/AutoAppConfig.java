package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

// AppConfig 클래스는 직접 자바 코드로 빈을 등록하는 설정 정보 클래스 였고 이번에는 컴포넌트 스캔을 통한 빈 등록
@Configuration
@ComponentScan(
        // 이전 예제(AppConfig 클래스)를 유지하기 위해 설정 정보 클래스는 제외하고 스캔
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)

// `@Component` 애노테이션이 붙은 클래스를 스캔해서 스프링 빈으로 등록하게 됨 (RateDiscountPolicy, MemberServiceImpl, MemoryMemberRepository)
public class AutoAppConfig {

}
