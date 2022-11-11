package com.dntwk;

import com.dntwk.comm.converter.usergrade.UserGrade;
import com.dntwk.user.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@SpringBootApplication
public class DntwkApplication {

    public static void main(String[] args) {
        SpringApplication.run(DntwkApplication.class, args);
    }

}
