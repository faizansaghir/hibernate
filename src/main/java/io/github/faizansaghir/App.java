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
        Configuration configuration = new Configuration().configure().addAnnotatedClass(Alien.class);

        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            Session session = sessionFactory.openSession();
        // createAlien(session);
            getAline(session);

        }
    }

    private static void getAline(Session session) {
        int id = 101;

        Alien alien = session.get(Alien.class, id);

        System.out.println(alien);
    }

    private static void createAlien(Session session) {
        Alien a1 = new Alien();

        a1.setAid(102);
        a1.setAname("Alien 2");
        a1.setColor("Orange");

        Transaction tx = session.beginTransaction();

        session.persist(a1);

        tx.commit();

    }


}
