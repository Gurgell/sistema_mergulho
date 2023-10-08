package com.empresa.dao;

import com.empresa.entities.CheckList;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;


public class DaoCheckList extends Dao<CheckList>{
    public CheckList buscarCheckList(Long id){
        return (CheckList) em.createNativeQuery("SELECT * FROM checklist WHERE idMergulho = :idMergulho", CheckList.class)
            .setParameter("idMergulho", id)
            .getSingleResult();
    }

    public static void inserirIdMergulho(Long idMergulho, Long idCheckList){
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        
        em.createNativeQuery("UPDATE checklist SET idmergulho = :idmergulho WHERE id = :idchecklist", CheckList.class)
        .setParameter("idmergulho", idMergulho)
        .setParameter("idchecklist", idCheckList)
        .executeUpdate();

        transaction.commit();

        em.close();
    }

    public static void inserirIdMergulhoWhereIsNull(){
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        
        em.createNativeQuery("UPDATE checklist SET idmergulho = id WHERE idmergulho IS NULL", CheckList.class).executeUpdate();

        transaction.commit();

        em.close();
    }
}

