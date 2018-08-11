package com.bnp.showroom.entities;

import com.bnp.showroom.project.Project;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Entity that represents a user-rating for a specific {@link Project}.
 */
@Entity
@Table(name = "RATINGS")
public class Rating {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RATING_ID_SEQ")
	@SequenceGenerator(name = "RATING_ID_SEQ", sequenceName = "RATING_ID_SEQ", allocationSize = 1)
	private long id;

	@Column(name = "VALUE")
	private Integer value;

//	@OneToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "PROJECT_ID", referencedColumnName = "ID", nullable = false)
//	private Project project;
//
//	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.MERGE, CascadeType.REFRESH })
//	@JoinColumn(name = "PROFILE_ID", referencedColumnName = "ID", nullable = false)
//	private UserProfile userProfile;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the value
	 */
	public Integer getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(Integer value) {
		this.value = value;
	}

//	/**
//	 * @return the project
//	 */
//	public Project getProject() {
//		return project;
//	}
//
//	/**
//	 * @param project
//	 *            the project to set
//	 */
//	public void setProject(Project project) {
//		this.project = project;
//	}
//
//	/**
//	 * @return the userProfile
//	 */
//	public UserProfile getUserProfile() {
//		return userProfile;
//	}
//
//	/**
//	 * @param userProfile
//	 *            the userProfile to set
//	 */
//	public void setUserProfile(UserProfile userProfile) {
//		this.userProfile = userProfile;
//	}

}
