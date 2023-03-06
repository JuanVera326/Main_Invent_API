package com.mainInvent.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mainInvent.api.entity.UbicacionVo;

@Repository
public interface IUbicacionRepository extends JpaRepository<UbicacionVo, Long>{}
