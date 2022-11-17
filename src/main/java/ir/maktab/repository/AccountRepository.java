package ir.maktab.repository;

import ir.maktab.model.Account;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class AccountRepository extends HibernateConfig {
    static SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
    private static final Logger log = LoggerFactory.getLogger(AccountRepository.class);

    public void creat(Account account) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(account);
        transaction.commit();
        session.close();
        log.info("account saved");
    }

    public Account findByUsername(String username) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "from Account where user.username=:username";
        Query query = session.createQuery(hql, Account.class);
        query.setParameter("username", username);
        Account account = (Account) query.getSingleResult();
        transaction.commit();
        session.close();
        return account;
    }

    public void update(Account account) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(account);
        transaction.commit();
        session.close();
    }

    public void remove(Account account) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.remove(account);
        transaction.commit();
        session.close();
    }
}
