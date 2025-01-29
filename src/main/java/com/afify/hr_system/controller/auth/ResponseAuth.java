package com.afify.hr_system.controller.auth;



import com.afify.hr_system.mapper.user.UserDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseAuth {
private String token;
private UserDto user;
}
