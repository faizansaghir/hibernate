package io.github.faizansaghir;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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

        a1.setAid(101);
        a1.setAname("Alien 1");
        a1.setColor("Green");

        Configuration configuration = new Configuration();

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.openSession();

        session.save(a1);

    }
}
