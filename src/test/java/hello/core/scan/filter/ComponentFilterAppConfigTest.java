package hello.core.scan.filter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ComponentFilterAppConfigTest {

    @Test
    void filterScan() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ComponentFilterAppConfig.class);
        BeanA beanA = ac.getBean("beanA", BeanA.class);
        assertThat(beanA).isNotNull();

        assertThrows(NoSuchBeanDefinitionException.class, () -> ac.getBean("beanB", BeanB.class));
    }

    @Configuration
    @ComponentScan(
            // BeanA는 스프링 빈에 등록되지만 BeanB는 스프링 빈에 등록되지 않음. excludeFilters에 내가 만든 MyExcludeComponent 애노테이션을 추가했기 때문에 제외된 것
            includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = MyIncludeComponent.class),
            excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = MyExcludeComponent.class)
            // FilterType은 5가지 옵션 존재
            // ANNOTATION: 기본값, 어노테이션을 인식해서 동작
            // ASSIGNABLE_TYPE: 지정한 타입과 자식 타입을 인색해서 동작
            // ASPECTJ: AspectJ 패턴 사용
            // REGEX: 정규 표현식
            // CUSTOM: TypeFilter라는 인터페이스를 구현해서 처리
    )
    static class ComponentFilterAppConfig {

    }
}
