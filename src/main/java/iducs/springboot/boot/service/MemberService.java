package iducs.springboot.boot.service;

import iducs.springboot.boot.domain.Member;
import iducs.springboot.boot.entity.MemberEntity;

import java.util.List;
import java.util.Optional;

public interface MemberService {
    void create(Member member);
    Member readById(Long seq);
    List<Member> readAll();
    void update(Member member);
    void delete(Member member);

    Member readByName(Member member);
    Member readByEmail(String email);
}
