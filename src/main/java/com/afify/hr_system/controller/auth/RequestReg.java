package com.afify.hr_system.controller.auth;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestReg {
private String email;
private String fullname;
private String password;
}
