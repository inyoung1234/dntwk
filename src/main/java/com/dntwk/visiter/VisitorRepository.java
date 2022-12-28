package com.dntwk.visiter;

import com.dntwk.visiter.Visitor;
import com.dntwk.visiter.dto.VisitorDTO;
import org.hibernate.annotations.Columns;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.NamedNativeQuery;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.Optional;

@Repository
public interface VisitorRepository extends JpaRepository<Visitor,Long> {
    Optional<Visitor> findByVisitIpAndVisitTimeGreaterThan(String visitorIp,Date date);

}
