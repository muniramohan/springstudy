package com.bnp.showroom.project;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.CreatedDate;
import com.bnp.showroom.common.ProjectStatus;

@Entity
@Table(name = "PROJECTS")
public class Project {

	@Id
	@Column(name = "PROJECT_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PROJECT_ID_SEQ")
	@SequenceGenerator(name = "PROJECT_ID_SEQ", sequenceName = "PROJECT_ID_SEQ", allocationSize = 1)
	private long id;

	@Column(name = "PROJECT_TITLE" , unique = true)
	@NotNull
	private String projectTitle;

	@CreatedDate
	@Column(name = "CREATION_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;

	@Column(name = "STATUS")
	@Enumerated(EnumType.STRING)
	@NotNull
	private ProjectStatus status;

	@Column(name = "DESCRIPTION_HTML")
	private String descriptionHtml;

	@Column(name = "PROJECT_OWNER")
	private long projectOwner;

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

	/**
	 * @return the status
	 */
	public ProjectStatus getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(ProjectStatus status) {
		this.status = status;
	}

	/**
	 * @return the descriptionHtml
	 */
	public String getDescriptionHtml() {
		return descriptionHtml;
	}

	/**
	 * @param descriptionHtml
	 *            the descriptionHtml to set
	 */
	public void setDescriptionHtml(String descriptionHtml) {
		this.descriptionHtml = descriptionHtml;
	}

	public String getProjectTitle() {
		return projectTitle;
	}

	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}

	public long getProjectOwner() {
		return projectOwner;
	}

	public void setProjectOwner(long projectOwner) {
		this.projectOwner = projectOwner;
	}

}
