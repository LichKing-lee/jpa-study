package com.yong.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

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
        } finally {
            em.close();
        }
    }

    private static void logic(EntityManager em){
        String id = "id1";
        Member member = new Member();
        member.setId(id);
        member.setUsername("LichKing");
        member.setAge(29);

        em.persist(member);

        member.setAge(30);

        Member findMember = em.find(Member.class, id);

        System.out.println(findMember);

        List<Member> memberTests = em.createQuery("SELECT m FROM Member m", Member.class)
                .getResultList();

        System.out.println("size :: " + memberTests.size());

        em.remove(member);
    }
}
