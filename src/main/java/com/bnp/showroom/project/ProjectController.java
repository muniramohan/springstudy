package com.bnp.showroom.project;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.List;

/**
 * Created by cs8593 on 15-08-2018.
 */
@RestController
@RequestMapping("/api/project")
public class ProjectController {
    private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);
    private ProjectRepository projectRepository;

    public ProjectController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public ResponseEntity findAll(){
        System.out.println("inside project get all");
        List<Project> results =projectRepository.findAllRecords();

        results.forEach(result -> result.setCommentCount(Long.valueOf(2)));
        return new ResponseEntity<>(results,HttpStatus.OK);
    }
}
