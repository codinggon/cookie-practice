package hello.login.domain.member;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotBlank;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Predicate;

@Slf4j
@Repository
public class MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();

    private static long sequence = 0L;

    public Member save(Member member) {
        member.setId(++sequence);
        System.out.println("save member = " + member);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id) {
        Member member = store.get(id);
        System.out.println("get member = " + member);
        return member;
    }

    public Optional<Member> findByLoginId(String loginId) {
        return findAll().stream().filter(member -> member.getLoginId().equals(loginId)).findFirst();
    }

    public List<Member> findAll(){
        return new ArrayList<>(store.values()); //linked는 들어온 순서로 되어있으니 자동 정렬을 이용해서 arrayList 이용
    }

    public void clearStore(){
        store.clear();
    }










}
