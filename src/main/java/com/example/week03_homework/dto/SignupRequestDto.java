package com.example.week03_homework.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupRequestDto {
	private String username;
	private String password;
	private String password2;
}