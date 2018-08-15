package com.bnp.showroom.comments;

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
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

/**
 * Entity that represents project comments.
 */
@Entity
@Table(name = "PROJECT_COMMENTS")
public class Comments {

	@Id
	@Column(name = "COMMENT_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMMENT_ID_SEQ")
	@SequenceGenerator(name = "COMMENT_ID_SEQ", sequenceName = "COMMENT_ID_SEQ", allocationSize = 1)
	private long id;

	@Column(name = "COMMENT_DESCRIPTION")
	private String commentDescription;


	@Column(name = "CREATION_DATE", updatable = false)
    @CreationTimestamp
	private Date creationDate;

	@Column(name = "PROJECT_ID")
	private long projectId;

    @Column(name = "USER_ID")
    private long userId;

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

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public long getUserID() {
        return userId;
    }

    public void setUserID(long userID) {
        this.userId = userID;
    }
}
