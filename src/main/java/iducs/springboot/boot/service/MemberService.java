package iducs.springboot.boot.service;

import iducs.springboot.boot.entity.MemberEntity;

import java.util.List;
import java.util.Optional;

public interface MemberService {
    int create(MemberEntity member);

    Optional<MemberEntity> readById(Long seq);

    Optional<MemberEntity> readId(String id);

    List<MemberEntity> readAll();

    int update(MemberEntity member);

    int delete(MemberEntity member);
}
