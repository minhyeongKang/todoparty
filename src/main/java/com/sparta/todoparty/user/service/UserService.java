package com.sparta.todoparty.user.service;

import com.sparta.todoparty.user.dto.request.SignUpRequestDto;
import com.sparta.todoparty.user.dto.response.SignUpResponseDto;
import com.sparta.todoparty.user.dto.response.UserResponseDto;
import com.sparta.todoparty.user.entity.User;

public interface UserService {

    SignUpResponseDto signUp(SignUpRequestDto requestDto);
    UserResponseDto getUserData(User user);
}