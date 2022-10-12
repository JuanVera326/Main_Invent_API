package com.mainInvent.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mainInvent.api.entity.ElectronicosVo;


@Repository
public interface IElectronicosRepository extends JpaRepository<ElectronicosVo, Long>{}
