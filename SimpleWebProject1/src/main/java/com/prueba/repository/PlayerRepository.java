package com.prueba.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.prueba.entity.PlayerEntity;

//Tenemos que marcar los repositorios con la etiqueta @Repository, y extender las interfaces 
//CrudRepository y JpaRepository
@Repository
public interface PlayerRepository extends CrudRepository<PlayerEntity, Long>, JpaRepository<PlayerEntity, Long> {
    List<PlayerEntity> findByTeamId(long teamId);
    
    //Si queremos hacer una consulta JPQL (Java Persistance Query Language)
    //aquí tenemos un ejemplo de como implementarla
    @Transactional
    @Modifying
    @Query("delete from PlayerEntity p where p.name = :playerName")
	void deleteByName(@Param ("playerName") String playerName);
}