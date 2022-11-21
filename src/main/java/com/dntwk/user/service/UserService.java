package com.dntwk.user.service;

import com.dntwk.comm.ApiStatus;
import com.dntwk.comm.converter.usergrade.UserGrade;
import com.dntwk.user.dto.CreateUserDTO;
import com.dntwk.user.entity.User;
import com.dntwk.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public ApiStatus createUser(CreateUserDTO createUserDTO){
        if(userRepository.findByUserId(createUserDTO.getUserId())==null){
            userRepository.save(createUserDTO.toEntity());
            return ApiStatus.SUCCESS;
        };
        return ApiStatus.FAIL;
    }
}
