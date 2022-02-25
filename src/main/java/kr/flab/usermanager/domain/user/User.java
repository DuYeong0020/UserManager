package kr.flab.usermanager.domain.user;

import kr.flab.usermanager.domain.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "users")
@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID", nullable = false)
    private Long id; // USER PK

    @Column(name = "USER_NAME", length = 50, nullable = false)
    private String name; // 이름

    @Column(name = "LOGIN_ID", nullable = false)
    private String userId; // 유저 아이디

    @Column(name = "USER_PW", nullable = false)
    private String password; // 비밀번호

    @Column(name = "USER_GENDER", nullable = false)
    private Gender gender; // 성별

    @Column(name = "USER", nullable = false)
    private LocalDateTime joinDate; // 회원 가입 일자

    @Override
    public void prePersist(){
        super.prePersist();
        joinDate = LocalDateTime.now();

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(getId(), user.getId()) && Objects.equals(getName(), user.getName()) && Objects.equals(getUserId(), user.getUserId()) && Objects.equals(getPassword(), user.getPassword()) && getGender() == user.getGender() && Objects.equals(getJoinDate(), user.getJoinDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getUserId(), getPassword(), getGender(), getJoinDate());
    }
}
