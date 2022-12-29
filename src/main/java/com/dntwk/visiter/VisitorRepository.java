package com.dntwk.visiter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface VisitorRepository extends JpaRepository<Visitor,Long> {
    Optional<Visitor> findByVisitIpAndVisitTimeGreaterThan(String visitorIp,Date date);

}
