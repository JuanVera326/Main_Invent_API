package com.mainInvent.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mainInvent.api.entity.ModDevVo;

@Repository
public interface IModDevRepository extends JpaRepository<ModDevVo, Long>{}
