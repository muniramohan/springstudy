package com.bnp.showroom.prototypes;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "prototypes", path ="prototype")
public interface PrototypeRepository extends PagingAndSortingRepository<Prototypes, Long> {

}
