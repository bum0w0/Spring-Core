package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    // 스프링 컨테이너가 빈(Bean)으로 등록된 객체들 중에서, 해당 타입에 맞는 빈을 찾아 주입 (MemoryMemberRepository, RateDiscountPolicy)
    // `@Autowired` 를 사용하면 생성자에서 여러 의존관계도 한번에 주입받을 수 있다.

    /*
        기존의 생성자 코드를 롬복 라이브러리가 제공하는 `@RequiredArgsConstructor` 기능을 사용하여 final이 붙은 필드를 모아서 생성자를 자동으로 생성 하는것으로 대체
    */


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // 테스트 용도로 코드 추가
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}