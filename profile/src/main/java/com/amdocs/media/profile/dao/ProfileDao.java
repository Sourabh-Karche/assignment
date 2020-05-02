package com.amdocs.media.profile.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.amdocs.media.profile.models.Profile;

@Repository
public interface ProfileDao extends CrudRepository<Profile, Integer>{
	
}
