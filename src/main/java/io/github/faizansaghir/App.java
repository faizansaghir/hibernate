package io.github.faizansaghir;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Alien a1 = new Alien();

        a1.setAid(102);
        a1.setAname("Alien 2");
        a1.setColor("Orange");

        Configuration configuration = new Configuration().configure().addAnnotatedClass(Alien.class);

        Session session;
        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {

            session = sessionFactory.openSession();

            Transaction tx = session.beginTransaction();

            session.persist(a1);

            tx.commit();
        }

    }
}
