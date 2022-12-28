package com.dntwk.visiter;

import com.dntwk.visiter.dto.VisitorDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest

class VisitorServiceTest {

    @Autowired
    VisitorService visitorService;

    @Autowired
    VisitorRepository visitorRepository;

    @BeforeEach
    public void beforeEach() {
        Calendar cal = Calendar.getInstance();
        Date now = new Date();
        cal.setTime(now);
        cal.add(Calendar.DATE,-1);
        Date minusOneDate=cal.getTime();
        visitorRepository.save(Visitor.builder().visitId(1L).visitIp("1.1.1.1").visitRefer("chrome").visitTime(new Date()).build());
        visitorRepository.save(Visitor.builder().visitId(2L).visitIp("2.2.2.2").visitRefer("chrome").visitTime(minusOneDate).build());
        visitorRepository.save(Visitor.builder().visitId(3L).visitIp("3.3.3.3").visitRefer("chrome").visitTime(minusOneDate).build());
    }

    @DisplayName("방문자 수 조회가 된다")
    @Test
    public void countingTest(){
        VisitorDTO visitorDTO = visitorService.countingVisitor();

        assertEquals(visitorDTO.getTotal(),3);
        assertEquals(visitorDTO.getToday(),1);
        assertEquals(visitorDTO.getYesterday(),2);
    }

}