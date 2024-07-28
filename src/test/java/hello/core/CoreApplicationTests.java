package hello.core;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
/*
  CoreApplicationTests는 스프링 부트를 찾아서 실행하게 된다. 테스트 위에 @SpringBootTest라는 애노테이션이 있는데 스프링 부트로 실행하게 되면
  @SpringBootApplication 애노테이션이 있는 CoreApplication을 찾아서 설정 파일로 사용하게 됨. 그런데 SpringBootApplication 내부에는 @ComponentScan 코드가
  있음 @ComponentScan은 별도의 코드를 제공하지 않으면 현재 클래스가 있는 패키지 부터 하위 패키지를 모두 컴포넌트 스캔하기 때문에 @SpringBootApplication 애노테이션이 있는 곳의
  패키지 부터 모든 빈들을 컴포넌트 스캔함 결과적으로 스프링 부트를 통해서 실행하는 경우 이미 @ComponentScan을 통해서 모든 빈들을 읽어버리기 때문에 AutoAppConfig의 컴포넌트 스캔의
  excludeFilter 설정이 적용되지 않음
 */

class CoreApplicationTests {

	@Test
	void contextLoads() {
	}

}
