package com.bnp.showroom.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.bnp.showroom.project.Project;
import org.springframework.data.annotation.CreatedDate;

/**
 * Entity that represents project comments.
 */
@Entity
@Table(name = "PROJECT_COMMENTS")
public class Comment {

	@Id
	@Column(name = "COMMENT_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMMENT_ID_SEQ")
	@SequenceGenerator(name = "COMMENT_ID_SEQ", sequenceName = "COMMENT_ID_SEQ", allocationSize = 1)
	private long id;

	@Column(name = "COMMENT_DESCRIPTION")
	private String commentDescription;

	@CreatedDate
	@Column(name = "CREATION_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;

//	@OneToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID", nullable = false)
//	private UserProfile userProfile;

	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "PROJECT_ID", referencedColumnName = "PROJECT_ID", nullable = false)
	private Project project;

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

	public String getCommentDescription() {
		return commentDescription;
	}

	public void setCommentDescription(String commentDescription) {
		this.commentDescription = commentDescription;
	}

	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate
	 *            the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

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

	/**
	 * @return the project
	 */
	public Project getProject() {
		return project;
	}

	/**
	 * @param project
	 *            the project to set
	 */
	public void setProject(Project project) {
		this.project = project;
	}

}
