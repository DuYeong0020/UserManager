package kr.flab.usermanager.interfaces.user;

import kr.flab.usermanager.domain.user.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String name;
    private Gender gender;
    private LocalDateTime joinDate;
}
