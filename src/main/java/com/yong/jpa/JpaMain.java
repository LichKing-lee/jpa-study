package com.yong.jpa;

import com.yong.jpa.category.Category;
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
        transaction(emf, createCategory());
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

    private static Consumer<EntityManager> createCategory(){
        return em -> {
            Category category1 = new Category();
            category1.setName("생필품");

            Category category2 = new Category();
            category2.setName("가전");

            em.persist(category1);
            em.persist(category2);
        };
    }

    private static Consumer<EntityManager> createProduct(){
        return em -> {
            Product product1 = new Product();
            product1.setName("상품1");
            product1.setPrice(200);

            Product product2 = new Product();
            product2.setName("상품2");
            product2.setPrice(300);

            Category category = em.createQuery("SELECT c FROM Category c WHERE name = :name", Category.class)
            .setParameter("name", "가전")
            .getSingleResult();

            product1.setCategory(category);
            product2.setCategory(category);

            em.persist(product1);
            em.persist(product2);
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

            Member member = em.find(Member.class, 1L);

            Delivery delivery = new Delivery();

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

            System.out.println("purchase id :: " + purchase.getId());
        };
    }
}
