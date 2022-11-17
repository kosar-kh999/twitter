package ir.maktab.repository;

import ir.maktab.model.Comment;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class CommentRepository extends HibernateConfig {
    public static EntityManager entityManager = Persistence.createEntityManagerFactory("PU").createEntityManager();

    public void creat(Comment comment) {
        entityManager.getTransaction().begin();
        entityManager.persist(comment);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Comment findByUsername(String username) {
        entityManager.getTransaction().begin();
        String hql = "from Comment where Account.user.username=:username";
        Query query = entityManager.createQuery(hql, Comment.class);
        query.setParameter("username", username);
        Comment comment = (Comment) query.getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return comment;
    }

    public List<Comment> getCommentOfTweet(){
        entityManager.getTransaction().begin();
        return null;

    }

    public void update(Comment comment) {
        entityManager.getTransaction().begin();
        entityManager.merge(comment);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void remove(Comment comment) {
        entityManager.getTransaction().begin();
        entityManager.remove(comment);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
