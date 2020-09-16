package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        // EntityManagerFactory 만드는 순간 database와 연결
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaTest"); // data base connection 생성과 비슷한 역할. web server가 올라오는 시점에 하나만 생성됨(application 전체에서 공유).
        EntityManager em = emf.createEntityManager(); // JAVA Collection 처럼 이해하면 쉬움. 고객의 요청이 올 때마다 create, close. thread간에 공유 X.

        EntityTransaction tx = em.getTransaction(); // transaction 생성
        tx.begin();

        // JPA에서 모든 데이터 변경은 꼭 Transaction단위 안에서 이루어져야한다.
        try {
            /* insert
            Member member = new Member();
            member.setId(2L);
            member.setName("helloB");
            em.persist(member);*/

            /* select
            Member findMember = em.find(Member.class, 1L);
            System.out.println("findMember.getId() = " + findMember.getId());
            System.out.println("findMember.getName() = " + findMember.getName());*/

            /* delete
            em.remove(findMember);*/

            /* update
             * em.persist()를 호출하지 않아도 됨.
             * JPA를 통해서 entity를 가져오면 JPA가 관리를 한다, transaction을 커밋하는 시점에 변경을 체크해서 update쿼리를 날리기 때문.
            Member findMember = em.find(Member.class, 1L);
            findMember.setName("HelloJPA");*/

            tx.commit();
        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
