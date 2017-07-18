package com.yong.jpa;

import com.yong.jpa.delivery.Delivery;
import com.yong.jpa.member.Member;
import com.yong.jpa.product.Product;
import com.yong.jpa.purchase.Purchase;
import com.yong.jpa.purchase.PurchaseDetail;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Arrays;
import java.util.Calendar;
import java.util.function.Consumer;

/**
 * Created by lichking on 2017. 7. 11..
 */
public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");

        transaction(emf, createMember());
        transaction(emf, createProduct());
        transaction(emf, createPurchase());
        transaction(emf, selectPurchase());
    }

    private static void transaction(EntityManagerFactory emf, Consumer<EntityManager> logic){
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try{
            System.out.println("hello transaction");
            tx.begin();
            logic.accept(em);
            tx.commit();
            System.out.println("goodbye transaction");
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }
    }

    private static Consumer<EntityManager> createMember(){
        return em -> {
            Member member = new Member();
            member.setAge(29);
            member.setUsername("LichKing");

            em.persist(member);
        };
    }

    private static Consumer<EntityManager> createProduct(){
        return em -> {
            Product product11 = new Product();
            product11.setName("상품1");
            product11.setPrice(200);

            Product product21 = new Product();
            product21.setName("상품2");
            product21.setPrice(300);

            em.persist(product11);
            em.persist(product21);
        };
    }

    private static Consumer<EntityManager> createPurchase(){
        return em -> {
            Product product1 = em.find(Product.class, 1L);
            Product product2 = em.find(Product.class, 2L);

            PurchaseDetail purchaseDetail1 = new PurchaseDetail();
            purchaseDetail1.setProduct(product1);
            purchaseDetail1.setCount(2);

            PurchaseDetail purchaseDetail2 = new PurchaseDetail();
            purchaseDetail2.setProduct(product2);
            purchaseDetail2.setCount(5);

            Delivery delivery = new Delivery();
            em.persist(delivery);

            Member member = em.find(Member.class, 1L);

            Purchase purchase = new Purchase();
            purchase.setMember(member);
            purchase.setPurchaseDatetime(Calendar.getInstance());
            purchase.setPurchaseDetails(Arrays.asList(purchaseDetail1, purchaseDetail2));
            purchase.setDelivery(delivery);

            em.persist(purchase);
        };
    }

    private static Consumer<EntityManager> selectPurchase(){
        return em -> {
            System.out.println("start select");
            Purchase purchase = em.find(Purchase.class, 1L);

            System.out.println(purchase);
        };
    }
}
