package iducs.springboot.boot.domain;

import lombok.*;

@Data // @Getter, @Setter, @EqualsAndHash, @RequiredArgsConstructor 가 모두 내포
@Builder
public class Member { // DTO(data transfer object) Client ↔ Controller ↔ service
    private Long seq;
    private String id;
    private String name;
    private String pw;
    private String email;
    private String phone;
    private String address;
    // Date : 날짜 시간 관련
}
