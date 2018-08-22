package com.bnp.showroom.userprofile;

import com.bnp.showroom.common.QueryConstants;
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

	@Query(value = QueryConstants.FIND_BY_EMAIL, nativeQuery = true)
	UserProfile findByEmail(String email);

	@Query(value = QueryConstants.FIND_BY_EMAIL_ONLY, nativeQuery = true)
	UserProfile findByOnlyEmail(String email);

	@Query(value = QueryConstants.VERIFY_EMAIL_TOKEN, nativeQuery = true)
	UserProfile verifyEmailToken(String token);

	String findByVerificationToken(String emailId);

}
