package com.mainInvent.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mainInvent.api.entity.UsuarioVo;

@Repository
public interface IUsuarioRepository extends JpaRepository<UsuarioVo, Long>{}
