package com.empresa.dao;

import java.time.LocalDate;
import java.util.List;

import com.empresa.entities.Mergulho;
import com.empresa.entities.Rom;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class DaoRom extends Dao<Rom>{

    public List<Rom> buscarTodos(){
        return em.createNativeQuery("select * from rom", Rom.class).getResultList();
    }
    
    public static void inserirRom_idListaDeMergulhos_id(Long rom_id, Long listademergulhos_id){
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        
        em.createNativeQuery("INSERT INTO rom_mergulho (rom_id, listademergulhos_id) VALUES (:rom_id, :listademergulhos_id)", Mergulho.class)
        .setParameter("rom_id", rom_id)
        .setParameter("listademergulhos_id", listademergulhos_id)
        .executeUpdate();

        transaction.commit();

        em.close();
    }

    public static List<Rom> buscarPorData(LocalDate dataInicio, LocalDate dataFim){
        return em.createNativeQuery("SELECT * FROM rom WHERE data BETWEEN :datainicio AND :datafim", Rom.class)
        .setParameter("datainicio", dataInicio)
        .setParameter("datafim", dataFim)
        .getResultList();
    }
}
