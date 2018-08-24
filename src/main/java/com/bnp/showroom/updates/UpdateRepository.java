package com.bnp.showroom.updates;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "updates", path = "update")
public interface UpdateRepository extends PagingAndSortingRepository<Updates, Long> {
}
