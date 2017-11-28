package com.trail.sample.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "ProfileInfo")
public class ProfileInfo {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long profileId;
	
	private String firstName;
	
	private String lastName;
	
	private String profileFilePath;
	
	@Transient
	private MultipartFile profileFile;

	public Long getProfileId() {
		return profileId;
	}

	public void setProfileId(Long profileId) {
		this.profileId = profileId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getProfileFilePath() {
		return profileFilePath;
	}

	public void setProfileFilePath(String profileFilePath) {
		this.profileFilePath = profileFilePath;
	}

	public MultipartFile getProfileFile() {
		return profileFile;
	}

	public void setProfileFile(MultipartFile profileFile) {
		this.profileFile = profileFile;
	}

	public ProfileInfo(Long profileId, String firstName, String lastName, String profileFilePath,
			MultipartFile profileFile) {
		super();
		this.profileId = profileId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.profileFilePath = profileFilePath;
		this.profileFile = profileFile;
	}

	public ProfileInfo() {
		// TODO Auto-generated constructor stub
	}
	
	
}
