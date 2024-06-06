package com.elearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elearning.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
