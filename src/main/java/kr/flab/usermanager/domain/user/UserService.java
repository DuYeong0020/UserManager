package kr.flab.usermanager.domain.user;


import kr.flab.usermanager.infrastructure.user.UserRepository;
import kr.flab.usermanager.interfaces.user.JoinUserDto;
import kr.flab.usermanager.interfaces.user.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;
    // service layer... Entity 가 서비스 메서드의 파라미터로 직접 사용되는 케이스는 적은게 좋다

    // 회원가입
    @Transactional
    public Long joinUser(JoinUserDto userDto) {  // Command, Criteria

        var password = passwordEncoder.encode(userDto.getPassword());
        User initUser = userDto.convert(password);  // 데이터베이스에 저장된 유저일까? 저장 안된 대기 상태의 유저일까?

        User findUser = userRepository.findByUserId(initUser.getUserId());
        if (findUser != null) {
            throw new RuntimeException("이미 아이디가 존재합니다.");
        }
        return userRepository.saveUser(initUser);
    }

    // 이름으로 회원 조회
    public List<UserDto> findUserByName(String name) {
        return userRepository.findByUserName(name);
    }

    // 전체 회원 조회
    public List<UserDto> findAllUser() {
        return userRepository.findAll();
    }
}
