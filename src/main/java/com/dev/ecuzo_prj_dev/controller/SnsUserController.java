package com.dev.ecuzo_prj_dev.controller;


import com.dev.ecuzo_prj_dev.config.oauth2.PrincipalDetails;
import com.dev.ecuzo_prj_dev.config.oauth2.PrincipalOauth2UserService;
import com.dev.ecuzo_prj_dev.config.oauth2.provider.KakaoUserInfoImpl;
import com.dev.ecuzo_prj_dev.config.oauth2.provider.OAuth2UserInfo;
import com.dev.ecuzo_prj_dev.dto.SnsUserDto;
import com.dev.ecuzo_prj_dev.entity.SnsUsers;
import com.dev.ecuzo_prj_dev.service.SnsUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.Principal;
import java.util.Map;
import java.util.Optional;

@RequestMapping("/")
@RestController
@Slf4j
public class SnsUserController {
    private SnsUserService snsUserService;
    private PrincipalOauth2UserService service;

    @Autowired
    public SnsUserController(SnsUserService snsUserService,PrincipalOauth2UserService service) {
        this.snsUserService = snsUserService;
        this.service=service;

    }
    @GetMapping("snsUserInfo")
    public ResponseEntity<?> kakaoProfile(@AuthenticationPrincipal Authentication authentication){

        log.warn(authentication.getName());
//        String email = oAuth2User.getName();
        SnsUserDto snsUserDto =null;
//        log.info("email: "+email);
//        Optional<SnsUsers> snsUsers =snsUserService.findByEmail(email);
//        if(snsUsers.isPresent()){
//            snsUserDto=snsUsers.get().toDto();
//            return ResponseEntity.ok(snsUserDto);
//        }
//        else
//            return ResponseEntity.ok("정보가 없습니다.");
        return null;
    }

    @GetMapping("kakaoinfo")
    public ResponseEntity<?> kakaoEmail(@RequestParam String code) throws Exception{
        System.out.println("code = " + code);
        String email=snsUserService.searchKakaoUser(snsUserService.getKakaoAccessToken(code));
        return ResponseEntity.ok(email);
    }

//    @GetMapping("/snsUser")
//    public ResponseEntity<?> kakaoInfo(@AuthenticationPrincipal UserDetails userDetails){
//        String email = userDetails.getUsername();
//        snsUserService.findByEmail()
//        return ResponseEntity.ok()
//    }

}
