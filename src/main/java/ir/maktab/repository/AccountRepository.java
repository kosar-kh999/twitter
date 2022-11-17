package ir.maktab.repository;

import ir.maktab.exception.DuplicateUsernameException;
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

    public boolean checkUsername(String username) throws DuplicateUsernameException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "SELECT COUNT (*) FROM Account where user.username=:username";
        Query query = session.createQuery(hql, Account.class);
        query.setParameter("username", username);
        long count = (long) query.getSingleResult();
        transaction.commit();
        session.close();
        if (count > 1)
            throw new DuplicateUsernameException("Username is duplicated");
        return true;
    }

    public Account findByUsernameAndPassword(String username, String password) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "from Account where user.username=:username and user.password=:password";
        Query query = session.createQuery(hql, Account.class);
        query.setParameter("username", username);
        query.setParameter("password", password);
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
