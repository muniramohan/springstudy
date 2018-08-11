package com.bnp.showroom.project;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.bnp.showroom.project.Project;

@RepositoryRestResource(collectionResourceRel = "projects", path = "project")
public interface ProjectRepository extends PagingAndSortingRepository<Project, Long>  {
    //Project findByProjectTitle(String projectTitle);
}
