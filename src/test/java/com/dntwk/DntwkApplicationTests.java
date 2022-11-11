package com.dntwk;

import com.dntwk.comm.converter.EnumUserGradeException;
import com.dntwk.comm.converter.usergrade.UserGrade;
import com.dntwk.comm.converter.usergrade.UserGradeAttributeConverter;
import com.dntwk.user.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.EnumSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DntwkApplicationTests {


    @PersistenceContext
    private EntityManager em;

    @PersistenceContext
    private void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @Test
    @Transactional
    public void Attribute_converter() {
        // 테스트 데이터
        User user = new User();

        user.setUserName("123");
        user.setUserPwd("123");
        user.setUserGrade(UserGrade.USER);

        em.persist(user);
        em.flush();
        em.clear();

        Query query = em.createNativeQuery("select * from User", User.class);
        List<User> list = query.getResultList();
        System.out.println("쿼리 실행 결과"+query.getResultList().get(0));
//
//        // 검증
//        Object resultGrade = list.get(0).getUserGrade();
//        assertEquals("User", resultGrade);
    }
}
