package com.dntwk.directory.repository;

import com.dntwk.directory.entity.Directory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectoryRepository extends JpaRepository<Directory,Long> {
    Directory findByDirectoryNameEqualsAndDirectoryLayerEquals(String directoryName,Integer directoryLayer);

    Directory findByDirectoryNameEqualsAndDirectoryLayerEqualsAndSuperDirectoryNameEqualsAndDirectorySortedNumEquals(
            String directoryName,Integer directoryLayer,String superDirectoryName,Integer directorySortNum
    );

    void deleteByDirectoryNameEqualsAndDirectoryLayer(String directoryName, Integer directoryLayer);

    @Modifying(clearAutomatically = true)
    @Query("update Directory as d set d.directorySortedNum = d.directorySortedNum - 1 where d.superDirectoryName=:superDirectoryName and d.directorySortedNum>:directorySortedNum")
    void sortDirectoryWhenRemove(@Param("superDirectoryName") String superDirectoryName,@Param("modDirectorySortedNum") Integer directorySortedNum);
}
