package com.mainInvent.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mainInvent.api.entity.Documentos_DatasheetsVo;

@Repository
public interface IDocumentos_DatasheetsRepository extends JpaRepository<Documentos_DatasheetsVo, Long>{}
