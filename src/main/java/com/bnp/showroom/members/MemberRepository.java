package com.bnp.showroom.members;

import com.bnp.showroom.userprofile.UserProfile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.ArrayList;

/**
 * Created by CS8593 on 31.07.2018.
 */
@RepositoryRestResource(collectionResourceRel = "members", path = "member")
public interface MemberRepository extends PagingAndSortingRepository<ProjectMembers, Long> {

    @Query(value = "SELECT p.id,p.email  FROM UserProfile p JOIN ProjectMembers m ON m.userID = p.id WHERE m.projectID =?1")
    Object findAllByProjectID(Long id);

    Long deleteByProjectID(Long id);
}
