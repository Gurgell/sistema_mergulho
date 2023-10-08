package com.empresa.dao;

import com.empresa.diversos.MensagensJavaFx;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Dao<E> {
    protected static EntityManagerFactory emf;
    protected static EntityManager em;

    static{
        try{
            emf = Persistence.createEntityManagerFactory("jpa_sistema_mergulho");
        }catch(Exception ex){
            throw new RuntimeException(ex.getMessage());
        }
    }

    public Dao(){
        em = emf.createEntityManager();
    }

    public void inserir(E entidade){
        try {
            em.getTransaction().begin();
            em.persist(entidade);
            em.getTransaction().commit();
        } catch (Exception e) {
            MensagensJavaFx.exibirMensagem("ERRO","Aviso!", "Não foi possível gravar!");
        }
        
    }

    public void apagar(E entidade){
        em.getTransaction().begin();
        em.remove(entidade);
        em.getTransaction().commit();
    }

    public void alterar(E entidade){
        em.getTransaction().begin();
        em.merge(entidade);
        em.getTransaction().commit();
    }
    
}
