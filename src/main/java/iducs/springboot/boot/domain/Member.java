package iducs.springboot.boot.domain;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class MemberDTO {
    private Long seq;
    private String id;
    private String name;
    private String pw;
    private String email;
    private String phone;
    private String address;
}
