package com.dntwk.user.service;

import com.dntwk.comm.ApiStatus;
import com.dntwk.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public ApiStatus checkEmailDuple(String userId){
        return userRepository.findByUserId(userId).isEmpty()?ApiStatus.SUCCESS:ApiStatus.FAIL;
    }

}
