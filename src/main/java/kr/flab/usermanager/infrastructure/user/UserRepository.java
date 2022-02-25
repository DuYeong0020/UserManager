package kr.flab.usermanager.infrastructure.user;


import kr.flab.usermanager.domain.user.User;
import kr.flab.usermanager.interfaces.user.UserDto;

import java.util.List;

public interface UserRepository {

    Long saveUser(User user);

    User findById(Long id);

    User findByUserId(String userId);

    List<UserDto> findByUserName(String name);

    List<UserDto> findAll();
}
