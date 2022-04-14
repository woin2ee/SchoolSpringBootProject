package iducs.springboot.boot.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="tbl_memo")

@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mno;

    @Column(length = 50, nullable = false)
    private String memoText;
}

