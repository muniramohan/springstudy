package com.bnp.showroom.userprofile;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Entity for a user profile.
 */
@Entity
@Table(name = "USER_PROFILES")
public class UserProfile {

	@Id
	@Column(name = "USER_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_PROFILE_ID_SEQ")
	@SequenceGenerator(name = "USER_PROFILE_ID_SEQ", sequenceName = "USER_PROFILE_ID_SEQ", allocationSize = 1)
	private long id;

	@Column(name = "SALUTATION")
	private String salutation;

	@Column(name = "FIRST_NAME",nullable = false)
    @Size(min=2, message="Name should have atleast 2 characters")
	private String firstName;

	@Column(name = "LAST_NAME",nullable = false)
	@NotNull
	private String lastName;

	@Column(name = "AVATAR_URL")
	private String avatarUrl;

	@Column(name = "EMAIL",nullable = false)
	@NotNull
	@Email(message = "Email format is not correct")
	private String email;

	@Column(name = "PHONE_NUMBER")
	private Long phoneNumber;

	@Column(name = "JOB_TITLE")
	private String jobTitle;

    @Column(name = "PASSWORD")
	//@JsonIgnore
	private String password;

	@Column(name = "ENABLED")
	//@JsonIgnore
	private String enabled;

//	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "profile")
//	private List<Rating> rating = new ArrayList<>();
//
//	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
//	@JoinTable(name = "USER_PROJECT_LIKES", joinColumns = @JoinColumn(name = "PROFILE_ID", referencedColumnName = "ID"),
//					inverseJoinColumns = @JoinColumn(name = "PROJECT_ID", referencedColumnName = "ID"))
//	private List<Project> likes = new ArrayList<>();
//
//	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
//	@JoinTable(name = "USER_PROJECT_VISITS",
//					joinColumns = @JoinColumn(name = "PROFILE_ID", referencedColumnName = "ID"),
//					inverseJoinColumns = @JoinColumn(name = "PROJECT_ID", referencedColumnName = "ID"))
//	private List<Project> visited = new ArrayList<>();

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
	 * @return the salutation
	 */
	public String getSalutation() {
		return salutation;
	}

	/**
	 * @param salutation
	 *            the salutation to set
	 */
	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the avatarUrl
	 */
	public String getAvatarUrl() {
		return avatarUrl;
	}

	/**
	 * @param avatarUrl
	 *            the avatarUrl to set
	 */
	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
	 * @return the phoneNumber
	 */
	public Long getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber
	 *            the phoneNumber to set
	 */
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	//	/**
//	 * @return the rating
//	 */
//	public List<Rating> getRating() {
//		return rating;
//	}
//
//	/**
//	 * @param rating
//	 *            the rating to set
//	 */
//	public void setRating(List<Rating> rating) {
//		this.rating = rating;
//	}
//
//	/**
//	 * @return the likes
//	 */
//	public List<Project> getLikes() {
//		return likes;
//	}
//
//	/**
//	 * @param likes
//	 *            the likes to set
//	 */
//	public void setLikes(List<Project> likes) {
//		this.likes = likes;
//	}
//
//	/**
//	 * @return the visited
//	 */
//	public List<Project> getVisited() {
//		return visited;
//	}
//
//	/**
//	 * @param visited
//	 *            the visited to set
//	 */
//	public void setVisited(List<Project> visited) {
//		this.visited = visited;
//	}

}
