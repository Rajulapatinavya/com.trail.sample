package com.trail.sample.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trail.sample.pojo.ProfileInfo;

public interface ProfileInfoRepo  extends JpaRepository<ProfileInfo,Long>{

	public ProfileInfoRepo findByProfileId(Long long1);
}
