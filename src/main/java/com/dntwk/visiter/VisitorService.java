package com.dntwk.visiter;

import com.dntwk.visiter.dto.VisitorDTO;
import com.dntwk.visiter.dto.VisitorReqDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.Calendar;
import java.util.Date;

@RequiredArgsConstructor
@Service
public class VisitorService {
    private final VisitorRepository visitorRepository;
    private final EntityManager entityManager;

    public VisitorDTO countingVisitor() {
        Date now = new Date();

        return entityManager.createNamedQuery("Visitor.visitCounting",VisitorDTO.class)
                .setParameter("today", now.getDate())
                .setParameter("yesterday", now.getDate() - 1)
                .getSingleResult();
    }

    public void findUserAndCounting(VisitorReqDTO visitorReqDTO) {
        Calendar cal = Calendar.getInstance();
        Date now = new Date();
        cal.setTime(now);
        cal.add(Calendar.MINUTE, -30);
        Date minusThirtyMin = cal.getTime();
        visitorRepository.findByVisitIpAndVisitTimeGreaterThan(visitorReqDTO.getVisitIp(), minusThirtyMin)
                .orElseGet(() -> visitorRepository.save(visitorReqDTO.toEntity()));
    }
}
