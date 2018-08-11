package com.bnp.showroom.userprofile;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Component;

/**
 * Repository for CRUD operations for the {@link UserProfile} entities.
 */
@Component
@Configuration
@RepositoryRestResource(collectionResourceRel = "userprofiles", path = "userprofile")
public interface UserProfileRepository extends PagingAndSortingRepository<UserProfile, Long> {

	@Query(value = "SELECT * FROM USER_PROFILES WHERE Enabled = true AND email= ?1", nativeQuery = true)
	UserProfile findByEmail(String email);

	@Query(value = "SELECT * FROM USER_PROFILES WHERE email= ?1", nativeQuery = true)
	UserProfile findByOnlyEmail(String email);
}
