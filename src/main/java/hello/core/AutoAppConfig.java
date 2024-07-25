package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

// AppConfig 클래스는 직접 자바 코드로 빈을 등록하는 설정 정보 클래스 였고 이번에는 컴포넌트 스캔을 통한 빈 등록
@Configuration
@ComponentScan(
        // member 패키지를 기준으로 하위 패키지를 모두 탐색 (모든 자바 클래스가 대상이면 시간이 오래걸린다.) 여러 시작 위치 지정도 가능 (Ex. basePackages = {"hello.core", "hello.service"})
        // 지정하지 않으면 `@ComponentScan` 이 붙은 설정 정보 클래스의 패키지가 시작 위치 (일반적으로 이 기본값으로 두고, 설정 정보 클래스 자체를 프로젝트 최상단인 시작 루트에 두는 것이 권장된다.)
        // 물론 @SpringBootApplication 어노테이션이 프로젝트 최상단 패키지(hello.core)에 위치하고 있으며, 이 어노테이션 안에 컴포넌트 스캔 기능이 포함되어 있다. 따라서 스프링 부트를 사용하면, 프로젝트 최상위 패키지부터 자동으로 컴포넌트 스캔이 시작되는거나 마찬가지.
        basePackages = "hello.core",


        // 이전 예제(AppConfig 클래스)를 유지하기 위해 설정 정보 클래스는 제외하고 스캔
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)

// `@Component` 애노테이션이 붙은 클래스를 스캔해서 스프링 빈으로 등록하게 됨 (RateDiscountPolicy, MemberServiceImpl, MemoryMemberRepository)
public class AutoAppConfig {

}
