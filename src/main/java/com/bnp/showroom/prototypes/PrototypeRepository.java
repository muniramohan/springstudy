package com.bnp.showroom.prototypes;

import com.bnp.showroom.project.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "prototypes", path ="prototype")
public interface PrototypeRepository extends PagingAndSortingRepository<Prototypes, Long> {


}
