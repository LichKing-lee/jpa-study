package com.yong.jpa;

import com.yong.jpa.product.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by lichking on 2017. 7. 11..
 */
public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try{
            tx.begin();
            System.out.println("hello transaction");
            logic(em);
            System.out.println("goodbye transaction");
            tx.commit();
        }catch (Exception e){
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    private static void logic(EntityManager em){
        Product product1 = new Product();
        product1.setName("test1");

        Product product2 = new Product();
        product2.setName("test2");

        em.persist(product1);
        em.persist(product2);

    }
}
