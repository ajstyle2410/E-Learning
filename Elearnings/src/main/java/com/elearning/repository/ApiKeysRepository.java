package com.elearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elearning.model.ApiKeys;

public interface ApiKeysRepository extends JpaRepository<ApiKeys, Long> {

}
