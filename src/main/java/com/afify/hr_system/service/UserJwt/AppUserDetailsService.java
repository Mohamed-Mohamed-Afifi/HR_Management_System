package com.afify.hr_system.service.UserJwt;

import java.security.Principal;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.afify.hr_system.error.RecordNotFoundException;
import com.afify.hr_system.mapper.user.UserDto;
import com.afify.hr_system.mapper.user.UserMapper;
import com.afify.hr_system.mapper.user.userPageMapper;
import com.afify.hr_system.model.appUser.AppUser;
import com.afify.hr_system.model.appUser.Role;
import com.afify.hr_system.model.appUser.dto.UserPageDto;
import com.afify.hr_system.repo.userAuth.TokenRepo;
import com.afify.hr_system.repo.userAuth.UserRepo;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AppUserDetailsService {
    private final UserRepo userRepo;
    private final UserMapper userMapper;
    private final userPageMapper userPageMapper;
    private final TokenRepo tokenRepo;
    public UserDetails loadByUserName(String userName) {
        return userRepo.findByEmail(userName);
    }
    public UserPageDto getAllusers(int pageNum,int pageSize){
        Pageable pageable=PageRequest.of(pageNum, pageSize);
        Page<AppUser> allUsers=userRepo.findAll(pageable);
        UserPageDto userPageDto=userPageMapper.map(allUsers);
        return userPageDto;
    }
    public ResponseEntity<?> updateUser(UserDto user){
        if(!userRepo.existsById(user.getId())) {
            throw new RecordNotFoundException("user is not exist");
        }
        AppUser appUser=userMapper.unmap(user);
        userRepo.save(appUser);
        return ResponseEntity.ok(null);
    }
    public ResponseEntity<?> editUser(UserDto user,Principal connectedUser){
        AppUser conectUser=(AppUser) ((UsernamePasswordAuthenticationToken)connectedUser).getPrincipal();
        if(conectUser.getId()!=user.getId()) {
            throw new RecordNotFoundException("you can only edit your data");
        }
        AppUser oldUser=userRepo.findById(user.getId()).get();
        Role oldRole=oldUser.getRole();
        byte[] imgBytes=null;
        if(user.getProfileimg()!=null) {
            imgBytes=Base64.getDecoder().decode(user.getProfileimg());
        }
        String pass=oldUser.getPassword();
        AppUser appUser=userMapper.unmap(user);
        appUser.setRole(oldRole);
        appUser.setPassword(pass);
        appUser.setImage(imgBytes);
        UserDto usrDto=userMapper.map(appUser);
        userRepo.save(appUser);
        return ResponseEntity.ok(usrDto);
    }
    @Transactional
    public ResponseEntity<?> deleteUser(int id) {
        if(!userRepo.existsById(id)) {
            throw new RecordNotFoundException("user is not exist");
        }
        tokenRepo.deleteByUserId(id);
        userRepo.deleteById(id);
        return ResponseEntity.ok(null);
    }
}
