package ir.maktab.repository;

import ir.maktab.model.Tweet;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

@Slf4j
public class TweetRepository extends HibernateConfig {
    static SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
    public static EntityManager entityManager = Persistence.createEntityManagerFactory("PU").createEntityManager();

    public void creat(Tweet tweet) {
        entityManager.getTransaction().begin();
        entityManager.persist(tweet);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Tweet findByUsername(String username) {
        entityManager.getTransaction().begin();
        String hql = "from Tweet where Account.user.username=:username";
        Query query = entityManager.createQuery(hql, Tweet.class);
        query.setParameter("username", username);
        Tweet tweet = (Tweet) query.getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return tweet;
    }

    public List<Tweet> getAll() {
        entityManager.getTransaction().begin();
        String hql = "from Tweet ";
        Query query = entityManager.createQuery(hql, Tweet.class);
        List<Tweet> tweets = query.getResultList();
        return tweets;
    }

    public void update(Tweet tweet) {
        entityManager.getTransaction().begin();
        entityManager.merge(tweet);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void remove(Tweet tweet) {
        entityManager.getTransaction().begin();
        entityManager.remove(tweet);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
