package com.sparta.todoparty.user.service.impl;

import com.sparta.todoparty.user.dto.request.SignUpRequestDto;
import com.sparta.todoparty.user.dto.response.SignUpResponseDto;
import com.sparta.todoparty.user.dto.response.UserResponseDto;
import com.sparta.todoparty.user.entity.User;
import com.sparta.todoparty.user.entity.UserRole;
import com.sparta.todoparty.user.exception.AlreadyExistEmailException;
import com.sparta.todoparty.user.exception.AlreadyExistNicknameException;
import com.sparta.todoparty.user.exception.AlreadyExistUsernameException;
import com.sparta.todoparty.user.repository.UserRepository;
import com.sparta.todoparty.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public SignUpResponseDto signUp(final SignUpRequestDto signUpRequestDto) {
        String username = signUpRequestDto.getUsername();
        String password = passwordEncoder.encode(signUpRequestDto.getPassword());

        // 회원 중복 확인
        Optional<User> checkUsername = userRepository.findByUsername(username);
        if (checkUsername.isPresent()) {
            throw new AlreadyExistUsernameException();
        }

        // email 중복확인
        String email = signUpRequestDto.getEmail();
        Optional<User> checkEmail = userRepository.findByEmail(email);
        if (checkEmail.isPresent()) {
            throw new AlreadyExistEmailException();
        }

        String nickname = signUpRequestDto.getNickname();
        Optional<User> checkNickname = userRepository.findByNickname(nickname);
        if (checkNickname.isPresent()) {
            throw new AlreadyExistNicknameException();
        }

        // 사용자 등록
        User user = User.builder()
                .username(username)
                .password(password)
                .email(email)
                .nickname(signUpRequestDto.getNickname())
                .role(UserRole.USER)
                .build();
        user = userRepository.save(user);

        return SignUpResponseDto.builder()
                .id(user.getId())
                .username(username)
                .nickname(nickname)
                .email(email)
                .build();
    }

    @Override
    public UserResponseDto getUserData(final User user) {
        return UserResponseDto.builder()
                .nickname(user.getNickname())
                .build();
    }
}
