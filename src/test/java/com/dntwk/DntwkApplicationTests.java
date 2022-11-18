package com.dntwk;

import com.dntwk.comm.converter.EnumUserGradeException;
import com.dntwk.comm.converter.usergrade.UserGrade;
import com.dntwk.comm.converter.usergrade.UserGradeAttributeConverter;
import com.dntwk.directory.entity.Directory;
import com.dntwk.user.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
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

        TypedQuery<Directory> query = em.createQuery("select d from Directory as d", Directory.class);
        List<Directory> directoryList = query.getResultList();

        for(Directory directory : directoryList){
            if(directory.getDirectoryName().equals("1")){
                //1
                directory.modDirectoryName("2");
            }
        }
    }

}
