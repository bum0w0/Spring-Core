package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Autowired // 스프링 컨테이너가 빈(Bean)으로 등록된 객체들 중에서, 해당 타입에 맞는 빈을 찾아 주입 (여기서는 MemoryMemberRepository)
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // 테스트 용도로 코드 추가
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
