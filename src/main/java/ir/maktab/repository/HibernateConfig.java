package ir.maktab.repository;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfig {
    private static Configuration configuration = new Configuration().configure();

    public static SessionFactory getSessionFactory() {
        return configuration.buildSessionFactory();
    }
}
