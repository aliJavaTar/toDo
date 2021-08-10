package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {
    public final static EntityManagerFactory entityManagerFactory ;
    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("ToDo");
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }
}
