package com.prueba.repository;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.prueba.entity.TeamEntity;

@Repository
public interface TeamRepository extends CrudRepository<TeamEntity, Long>, JpaRepository<TeamEntity, Long> {
    TeamEntity findByPlayers(long playerId);
    TeamEntity findByName(String teamName);//SpringDataJPA
    
    
//    EntityManagerFactory emf = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );
//    EntityManager em = emf.createEntityManager();
//    
//    //Scalar function
//    Query query = (Query) entitymanager.createQuery("Select e.ename from Employee e");
//    List<String> list=query.getResultList();
    
    @Transactional
    @Modifying
    @Query("delete from TeamEntity t where t.name = :teamName")
	void deleteByName(@Param ("teamName") String teamName);
//    
    
}
