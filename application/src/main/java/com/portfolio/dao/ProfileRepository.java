package com.portfolio.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.dto.ProfileDTO;

public interface ProfileRepository extends JpaRepository<ProfileDTO,Long> {

}
