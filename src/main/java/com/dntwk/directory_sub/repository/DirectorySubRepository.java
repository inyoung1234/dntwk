package com.dntwk.directory_sub.repository;

import com.dntwk.directory_sub.entity.DirectorySub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorySubRepository extends JpaRepository<DirectorySub,Long> {
}
