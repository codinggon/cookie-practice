package hello.login.domain.login;

import hello.login.domain.item.Item;
import hello.login.domain.item.ItemRepository;
import hello.login.domain.member.Member;
import hello.login.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class TestDataInit {

    private final ItemRepository itemRepository;
    private final MemberRepository memberRepository;

    //TestDataInit 클래스 빈이 주입될 때
    // init 메소드가 실행되면서 초기화 된다.
    @PostConstruct
    public void init(){
        itemRepository.save(new Item("itemA",1000,10));
        itemRepository.save(new Item("itemB",2000,20));

        Member member = new Member();
        member.setLoginId("gon");
        member.setPassword("123");
        member.setName("tester");
        memberRepository.save(member);
    }


}
