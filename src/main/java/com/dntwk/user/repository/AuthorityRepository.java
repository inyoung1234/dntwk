package com.dntwk.user.repository;

import com.dntwk.comm.converter.usergrade.UserGrade;
import com.dntwk.user.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, UserGrade> {

    Optional<Authority> findByAuthorityName(UserGrade userGrade);
}
