package hello.servlet.domain.member;

import lombok.val;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepository {

    private Long sequence = 0L;
    private final Map<Long, Member> store = new HashMap<>();
    private static final MemberRepository instance = new MemberRepository();

    private  MemberRepository() {}

    public static MemberRepository getInstance() {
        return instance;
    }

    public Member save(Member member) {
         member.setId(++sequence);
        this.store.put(sequence, member);
        return this.store.get(sequence);
    }

    public Member findById(Long id) {
        return this.store.get(id);
    }

    public List<Member> findAll() {
        return new ArrayList<>(this.store.values());
    }

    public void clearStore() {
        this.store.clear();
    }
}
