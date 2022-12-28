package com.dntwk.comm.auth;

import com.dntwk.comm.converter.usergrade.UserGrade;
import com.dntwk.comm.exception.BizException;
import com.dntwk.comm.exception.MemberExceptionType;
import com.dntwk.jwt.dto.TokenDTO;
import com.dntwk.jwt.repository.RefreshTokenRepository;
import com.dntwk.user.dto.CreateUserDTO;
import com.dntwk.user.dto.LoginDTO;
import com.dntwk.user.entity.Authority;
import com.dntwk.user.entity.User;
import com.dntwk.user.repository.AuthorityRepository;
import com.dntwk.user.repository.UserRepository;
import com.dntwk.user.service.AuthService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SecurityTest {
    @Autowired
    AuthService authService;

    @Autowired
    UserRepository memberRepository;

    @Autowired
    AuthorityRepository authorityRepository;

    @Autowired
    RefreshTokenRepository refreshTokenRepository;

    @Autowired
    EntityManager em;

    /**
     * 각 테스트 실행전에 실행
     */
    @BeforeEach
    public void beforeEach() {
        authorityRepository.save(new Authority(UserGrade.USER));
        authorityRepository.save(new Authority(UserGrade.ADMIN));

        CreateUserDTO dto = new CreateUserDTO();
        dto.setUserNickname("normalUser");
        dto.setUserId("normalUser@normalUser.com");
        dto.setUserPwd("1234");

        authService.signup(dto);
    }

    @DisplayName("회원가입이 정상적으로 된다")
    @Test
    @Transactional
    public void signup(){
        CreateUserDTO dto = new CreateUserDTO();
        dto.setUserNickname("user1");
        dto.setUserId("test@test.com");
        dto.setUserPwd("1234");
        authService.signup(dto);

        // 영속성 컨텍스트 플러쉬
        em.flush();
        em.clear();

        Optional<User> ret = memberRepository.findByUserId("test@test.com");
        assertEquals(ret.get().getUserNickname(),"user1");
    }

    @DisplayName("이미 존재하는 회원인 경우 회원가입 불가")
    @Test
    @Transactional
    public void signupDuplicateMember() {
        CreateUserDTO dto = new CreateUserDTO();
        dto.setUserNickname("normalUser");
        dto.setUserId("normalUser@normalUser.com");
        dto.setUserPwd("1234");

        BizException bizException = assertThrows(BizException.class, () -> {
            authService.signup(dto);
        });

        // 이미 존재하는 사용자 입니다.
        assertEquals(bizException.getBaseExceptionType().getErrorCode(),"DUPLICATE_USER");
    }

    @DisplayName("이메일이 존재하지 않아 로그인에 실패한다.")
    @Test
    @Transactional
    public void loginFailBecauseNotFoundEmail() {
        //given
        LoginDTO dto = LoginDTO.builder().email("abc@abc.com").build();

        //when
        BizException bizException = assertThrows(BizException.class, () -> {
            authService.login(dto);
        });

        //then
        // 사용자를 찾을 수 없습니다.
        assertEquals(bizException.getBaseExceptionType().getErrorCode(), MemberExceptionType.NOT_FOUND_USER.getErrorCode());
    }

    @DisplayName("비밀번호를 입력하지 않아 로그인 실패")
    @Test
    @Transactional
    public void loginFailBecauseEmptyPassword() {
        // given
        LoginDTO dto = LoginDTO.builder().email("normalUser@normalUser.com").build();

        //when
        BizException bizException = assertThrows(BizException.class, () -> {
            authService.login(dto);
        });

        //then
        // 비밀번호를 입력해주세요.
        assertEquals(bizException.getBaseExceptionType().getErrorCode()
                ,MemberExceptionType.NOT_FOUND_PASSWORD.getErrorCode());

    }

    @DisplayName("비밀번호가 틀려서 로그인 실패")
    @Test
    @Transactional
    public void loginFailBecauseWrongPassword() {
        // given
        LoginDTO dto = LoginDTO.builder().email("normalUser@normalUser.com").password("12345").build();

        //when
        BizException bizException = assertThrows(BizException.class, () -> {
            authService.login(dto);
        });

        //then
        // 비밀번호를 잘못 입력하였습니다.
        assertEquals(bizException.getBaseExceptionType().getErrorCode()
                ,MemberExceptionType.WRONG_PASSWORD.getErrorCode());

    }

    @DisplayName("로그인에 성공한다")
    @Test
    @Transactional
    public void loginSuccess() {
        // given
        LoginDTO dto = LoginDTO.builder().email("normalUser@normalUser.com").password("1234").build();

        TokenDTO login = authService.login(dto);
        assertEquals(login.getGrantType(),"Bearer");
    }

}