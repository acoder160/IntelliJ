package app;

import main.java.connection.HibernateUtil;
import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        System.out.println("Hibernate conectado correctamente a la base de datos ACDA_UT3.");

        session.getTransaction().commit();
        session.close();
        HibernateUtil.closeSessionFactory();
    }
}