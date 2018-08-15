package com.bnp.showroom.project;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.bnp.showroom.project.Project;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "projects", path = "project")
public interface ProjectRepository extends PagingAndSortingRepository<Project, Long>  {
    //Project findByProjectTitle(String projectTitle);
    @Query(value = "Select P From Project P")
    List<Project> findAllRecords();
}
