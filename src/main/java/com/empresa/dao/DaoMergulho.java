package com.empresa.dao;

import java.util.List;

import com.empresa.entities.Mergulho;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class DaoMergulho extends Dao<Mergulho>{
    public List<Mergulho> buscarTodos(){
        return em.createQuery("select c from Mergulho c").getResultList();
    }

    public List<Mergulho> buscaMergulhosPorRom(Long romId){
        String sql = "SELECT mergulho.* " +
             "FROM rom " +
             "JOIN rom_mergulho ON rom.id = rom_mergulho.rom_id " +
             "JOIN mergulho ON rom_mergulho.listademergulhos_id = mergulho.id " +
             "WHERE rom.id = :romId";

        return  em.createNativeQuery(sql, Mergulho.class)
        .setParameter("romId", romId)
        .getResultList();
    }    
    public List<Mergulho> buscarMergulhosSemId_Rom(){
        return em.createNativeQuery("SELECT * FROM Mergulho WHERE rom_id IS NULL", Mergulho.class).getResultList();
    }

    public static void inserirIdRomMergulho(Long romId){
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        
        em.createNativeQuery("UPDATE mergulho SET rom_id = :rom_id WHERE rom_id is null", Mergulho.class)
        .setParameter("rom_id", romId)
        .executeUpdate();

        transaction.commit();

        em.close();
    }

    public static void apagarId_rom_listademergulhos_id(Long romId, Long listademergulhos_id){
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        
        em.createNativeQuery("DELETE FROM rom_mergulho WHERE rom_id = :rom_id  AND listademergulhos_id = :listademergulhos_id")
        .setParameter("rom_id", romId)
        .setParameter("listademergulhos_id", listademergulhos_id)
        .executeUpdate();

        transaction.commit();

        em.close();
    }

}
