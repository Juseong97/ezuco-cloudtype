package com.dev.ecuzo_prj_dev.service;

import com.dev.ecuzo_prj_dev.dto.SnsUserDto;
import com.dev.ecuzo_prj_dev.entity.SnsUsers;

import java.util.Optional;

public interface SnsUserService {
    public Optional<SnsUsers> findByEmail(String email);
    public String searchKakaoUser(String code) throws Exception;
    public String getKakaoAccessToken (String code)throws Exception;
}
