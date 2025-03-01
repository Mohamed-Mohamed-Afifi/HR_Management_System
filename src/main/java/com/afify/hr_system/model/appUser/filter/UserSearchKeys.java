package com.afify.hr_system.model.appUser.filter;

import com.afify.hr_system.model.appUser.Role;
import lombok.Data;

@Data
public class UserSearchKeys {
    private String fullName;
    private String email;
    private Role role;
}
