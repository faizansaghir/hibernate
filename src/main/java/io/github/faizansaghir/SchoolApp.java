package io.github.faizansaghir;

import io.github.faizansaghir.entity.Address;
import io.github.faizansaghir.entity.Author;
import io.github.faizansaghir.entity.Book;
import io.github.faizansaghir.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SchoolApp {

    public static void main( String[] args )
    {
        Configuration configuration = new Configuration().configure()
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Address.class)
                .addAnnotatedClass(Book.class)
                .addAnnotatedClass(Author.class);

        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            Session session = sessionFactory.openSession();

            createEntries(session);

        }
    }

    private static void createEntries(Session session) {

        Student s1 = new Student("First", "Student");

        Student s2 = new Student("Second", "Student");

        Address a1 = new Address("City1", "Country1");

        Address a2 = new Address("City2", "Country2");

        Book b1 = new Book("Title 1");

        Book b2 = new Book("Title 2");

        Book b3 = new Book("Title 3");

        s1.setAddress(a1);
        s1.addBook(b1);
        b1.setStudent(s1);
        a1.setStudent(s1);

        s2.setAddress(a2);
        s2.addBook(b2);
        s2.addBook(b3);
        b2.setStudent(s2);
        b3.setStudent(s2);
        a2.setStudent(s2);

        Author at1 = new Author("First", "Author");

        Author at2 = new Author("Second", "Author");

        b1.addAuthor(at1);
        b1.addAuthor(at2);
        at1.addBook(b1);
        at2.addBook(b1);

        b2.addAuthor(at2);
        at2.addBook(b2);

        b3.addAuthor(at1);
        at1.addBook(b3);

        Transaction tx = session.beginTransaction();

        System.out.println("Saving address: "+a1);
        session.persist(a1);
        System.out.println("Saved address: "+a1);

        System.out.println("Saving address: "+a2);
        session.persist(a2);
        System.out.println("Saved address: "+a2);

        System.out.println("Saving student: "+s1);
        session.persist(s1);
        System.out.println("Saved student: "+s1);

        System.out.println("Saving student: "+s2);
        session.persist(s2);
        System.out.println("Saved student: "+s2);


        System.out.println("Saving book: "+b1);
        session.persist(b1);
        System.out.println("Saved book: "+b1);
        System.out.println("Saving book: "+b2);
        session.persist(b2);
        System.out.println("Saved book: "+b2);
        System.out.println("Saving book: "+b3);
        session.persist(b3);
        System.out.println("Saved book: "+b3);

        System.out.println("Saving author: "+at1);
        session.persist(at1);
        System.out.println("Done!");
        System.out.println("Saving author: "+at2);
        session.persist(at2);
        System.out.println("Done!");

        tx.commit();

    }

}
