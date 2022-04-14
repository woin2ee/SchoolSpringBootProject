package iducs.springboot.boot.repository;

import iducs.springboot.boot.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

}
