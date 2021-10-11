import entity.Member;
import entity.Team;

import javax.persistence.*;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        //엔티티 매니저 팩토리 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성

        EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득
        try {
            tx.begin(); //트랜잭션 시작


//            외래키대신_엔터티를_직접_조회조건에_사용하는_코드(em);
//            컬렉션_식(em);
//            컬렉션값_연관경로_탐색(em);
//            basicJpql(em);

            tx.commit();//트랜잭션 커밋
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); //트랜잭션 롤백
        } finally {
            em.close(); //엔티티 매니저 종료
        }

        emf.close(); //엔티티 매니저 팩토리 종료
    }

    private static void 외래키대신_엔터티를_직접_조회조건에_사용하는_코드(EntityManager em) {
        Team team = em.find(Team.class, 1L);
        em.createQuery("select m from Member m where m.team = :team")
                .setParameter("team", team)
                .getResultList();
    }

    private static void 컬렉션_식(EntityManager em) {
        TypedQuery<Team> query = em.createQuery("select t from Team t where t.members is not empty", Team.class);
        List<Team> resultList = query.getResultList();
        System.out.println("resultList = " + resultList);
    }

    /**
     * 컬렉션은 경로 탐색의 끝이다.
     * 컬렉션에서 경로 탐색을 하려면 아래와 같이 명시적으로 조인해서 별칭을 얻어야한다.
     */
    private static void 컬렉션값_연관경로_탐색(EntityManager em) {
        Query query = em.createQuery("select m.name from Team t join t.members m");
        List resultList = query.getResultList();
        System.out.println("resultList = " + resultList);
    }

    private static void basicJpql(EntityManager em) {
        TypedQuery<Member> query = em.createQuery("select m from Member m", Member.class);
        List<Member> resultList = query.getResultList();
        System.out.println("resultList = " + resultList);
    }
}
