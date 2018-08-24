package com.bnp.showroom.userprofile;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.*;
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

	@Lob
	@Column(name = "AVATAR_IMAGE")
	private byte[] avatarImage;

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

	@Column(name = "PROFILE_ENABLED")
	//@JsonIgnore
	private String profileEnabled = "FALSE";

	@Column(name = "VERIFICATION_TOKEN")
	private String verificationToken = UUID.randomUUID().toString();

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

	public byte[] getAvatarImage() {
		return avatarImage;
	}

	public void setAvatarImage(byte[] avatarImage) {
		this.avatarImage = avatarImage;
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
		return profileEnabled;
	}

	public void setEnabled(String enabled) {
		this.profileEnabled = enabled;
	}

	public String getVerificationToken() {
		return verificationToken;
	}

	public void setVerificationToken(String verificationToken) {
		this.verificationToken = verificationToken;
	}
}
