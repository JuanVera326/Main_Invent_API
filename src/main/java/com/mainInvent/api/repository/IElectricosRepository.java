package com.mainInvent.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mainInvent.api.entity.ElectricosVo;


@Repository
public interface IElectricosRepository extends JpaRepository<ElectricosVo, Long>{}
