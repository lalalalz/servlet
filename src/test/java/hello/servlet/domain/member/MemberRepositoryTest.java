package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void saveTest() {
        // given
        Member member = new Member("lalalalz", 20);
        // when
        Member savedMember = memberRepository.save(member);
        // then
        assertThat(member).isSameAs(savedMember);
    }

    @Test
    void findByIdTest() {
        // given
        Member member = new Member("lalalalz", 20);
        // when
        Member savedMember = memberRepository.save(member);
        Member findMember = memberRepository.findById(member.getId());
        System.out.println("findMember.getId() = " + findMember.getId());
        // then
        assertThat(member).isSameAs(findMember);
    }

    @Test
    void findAllTest() {
        // given
        Member member1 = new Member("lalalalz", 20);
        Member member2 = new Member("hellWorld", 28);
        memberRepository.save(member1);
        memberRepository.save(member2);
        // when
        List<Member> members = memberRepository.findAll();
        // then
        assertThat(members.size()).isEqualTo(2);
    }
}
