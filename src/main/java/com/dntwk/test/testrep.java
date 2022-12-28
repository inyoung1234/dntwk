package com.dntwk.test;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface testrep extends JpaRepository<UserGradeTest,Long> {
}
