package com.bnp.showroom.entities;

import com.bnp.showroom.project.Project;

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

/**
 * Entity for screenshots saved in projects.
 */
@Entity
@Table(name = "SCREENSHOTS")
public class Screenshot {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SCREENSHOT_ID_SEQ")
	@SequenceGenerator(name = "SCREENSHOT_ID_SEQ", sequenceName = "SCREENSHOT_ID_SEQ", allocationSize = 1)
	private long id;

	@Column(name = "URL")
	private String url;

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

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

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
