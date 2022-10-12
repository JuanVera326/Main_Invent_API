package com.mainInvent.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mainInvent.api.entity.ElementosFerrerteriaVo;

@Repository
public interface IElementosFerreteriaRepository extends JpaRepository<ElementosFerrerteriaVo, Long>{}
