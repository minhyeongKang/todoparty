package com.sparta.todoparty.user.service;

import com.sparta.todoparty.user.dto.request.LoginRequestDto;
import com.sparta.todoparty.user.dto.request.SignUpRequestDto;
import com.sparta.todoparty.user.dto.response.LoginResponseDto;
import com.sparta.todoparty.user.dto.response.SignUpResponseDto;
import com.sparta.todoparty.user.dto.response.UserResponseDto;
import com.sparta.todoparty.user.entity.User;

public interface UserService {

    SignUpResponseDto signUp(SignUpRequestDto requestDto);
    LoginResponseDto login(LoginRequestDto requestDto);
    UserResponseDto getUserData(User user);
}