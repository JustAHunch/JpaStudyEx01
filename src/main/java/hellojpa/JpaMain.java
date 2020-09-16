package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        //EntityManagerFactory 만드는 순간 database와 연결
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaTest");

        EntityManager em = emf.createEntityManager();
        //code
        em.close();
        emf.close();
    }
}
