package com.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.core.model.Copy;

@Repository
public interface CopyRepository extends JpaRepository<Copy, Integer> {

}
