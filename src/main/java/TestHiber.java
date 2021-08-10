import Entity.User;
import Entity.UserActivity;

import javax.persistence.EntityManager;
import java.util.List;

public class TestHiber   {

    public User addUser(EntityManager entityManager, User user ) {
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        List<User> users = entityManager.createQuery("from User", User.class)
                .getResultList();
        return users.get(0);
    }
    public static void insert (EntityManager entityManager,User user,UserActivity activity)
    {
        entityManager.getTransaction().begin();
        entityManager.persist(activity);
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }
}
