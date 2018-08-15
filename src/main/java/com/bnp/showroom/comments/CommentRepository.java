package com.bnp.showroom.comments;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by cs8593 on 15-08-2018.
 */
@RepositoryRestResource(collectionResourceRel = "comments", path = "comment")
public interface CommentRepository  extends PagingAndSortingRepository<Comments, Long> {
}
