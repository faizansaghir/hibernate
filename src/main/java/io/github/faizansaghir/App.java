package io.github.faizansaghir;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.File;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Alien a1 = new Alien();

        a1.setAid(101);
        a1.setAname("Alien 1");
        a1.setColor("Green");

        Configuration configuration = new Configuration().configure().addAnnotatedClass(Alien.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction tx = session.beginTransaction();

        session.save(a1);

        tx.commit();

    }
}
