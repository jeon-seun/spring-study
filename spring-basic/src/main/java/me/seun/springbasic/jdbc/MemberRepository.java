package me.seun.springbasic.jdbc;

import java.util.Optional;

public interface MemberRepository {

    void save(Member member);

    Optional<Member> findById(Long id);
}
