package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

    @Test
    void join(){
        //given ~가 수행될 때
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when ~할 때
        memberService.join(member); //memberService에 join했을 때
        Member findMember = memberService.findMember(1L);

        //then ~가 수행됨
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
