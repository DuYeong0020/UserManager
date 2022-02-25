package kr.flab.usermanager.interfaces.user;

import kr.flab.usermanager.domain.user.Gender;
import kr.flab.usermanager.domain.user.User;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;

@Getter
@ToString
public class JoinUserDto {  // DTO 는 bean 이 아니다... 스프링이 싱글톤으로 의존성을 주입해가면서 관리할 대상이 아니다...

    // http body ... text ... java 의 객체로 받아서 변환 <-- 언마샬링, 파싱...

    @NotEmpty(message = "name 은 필수값입니다 ")
    private String name; // 이름

    @NotEmpty(message = "userId 은 필수값입니다 ")
    private String userId; // 유저 아이디

    @NotEmpty(message = "password 은 필수값입니다 ")
    private String password; // 비밀번호

    @NotEmpty(message = "gender 은 필수값입니다 ")
    private Gender gender; // 성별

    // 추상화는 왜 하는가? 언제 추상화를 하면 좋은가?
        // 변화할 수 있는 부분을 추상화하는 것이 추후의 개발 유지보수에 좋다
        // 의존관계... 코드 구현을 하다보면, [다른 클래스에게 참조가 많이 되는 클래스] 가 있음... <-- 이런 클래스는 한 번 바뀌면, 영향 받는 클래스들이 많아짐
        // [다른 클래스에게 참조가 많이 되는 클래스]
            // O Service
            // X Controller

    // 구체화에 의존하고 있다 <-- 이게 과연 맞는 말일까?
    public User convert(String password) {
//        var passwordEncoder = new BCryptPasswordEncoder();  // var 키워드를 붙여서 암시적으로 변수 형태를 자바의 컴파일러가 처리하게 해도 됨
        return User.builder()
                .userId(this.userId)
                .gender(this.gender)
                .name(this.name)
                .password(password)
                .build();
    }
}
