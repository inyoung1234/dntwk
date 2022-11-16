package com.dntwk.directory.firstdirectory.repository;

import com.dntwk.directory.firstdirectory.entity.FirstDirectory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectoryRepository extends JpaRepository<FirstDirectory,Long> {

    FirstDirectory findByDirectoryName(String DirectoryName);

}
