package com.afify.hr_system.controller.auth;

import com.afify.hr_system.model.appUser.Role;

import jakarta.validation.constraints.Email;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestReg {
@Email
private String email;
private String fullname;
private String password;
private Role role;
}
