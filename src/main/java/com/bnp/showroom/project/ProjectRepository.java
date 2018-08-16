package com.bnp.showroom.project;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.bnp.showroom.project.Project;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "projects", path = "project")
public interface ProjectRepository extends PagingAndSortingRepository<Project, Long>  {

    @Query(value = "Select P From Project P")
    List<Project> findAllRecords();

    @Query(value = "Select Count(*) From PROJECT_COMMENTS Where Project_ID = ?1",nativeQuery = true)
    Long findCommentCount(Long projectID);

}
