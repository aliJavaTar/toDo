package repository;

import Entity.User;
import util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.security.interfaces.EdECKey;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private final static EntityManagerFactory entityMangerFactory = HibernateUtil.entityManagerFactory;
    private final static EntityManager entityManager = entityMangerFactory.createEntityManager();

    @Override
    public User save(User user) {
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        //List<User> users
        List<User> users;
        users = entityManager.createQuery("from User", User.class).getResultList();
        Long index = user.getId();
        System.out.println("before");
        System.out.println(users.get(Math.toIntExact(index)));
        return users.get(Math.toIntExact(index));
    }

    @Override
    public User update(User user) {
        entityManager.getTransaction().begin();
        User updatedUserInfo = entityManager.find(User.class, user.getId());
        updatedUserInfo.setUsername(user.getUsername());
        updatedUserInfo.setPassword(user.getPassword());
        entityManager.getTransaction().commit();
        return updatedUserInfo;
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        entityManager.getTransaction().begin();
        entityManager.persist(users);
        entityManager.getTransaction().commit();
        users = entityManager.createQuery
                (" from User ", User.class)
                .getResultList();
        return users;
    }

    @Override
    public void deleteById(Long id) {
        entityManager.getTransaction().begin();
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
        entityManager.getTransaction().commit();
    }

    @Override
    public User findById(Long id) {
        entityManager.find(User.class, id);
        List<User> users = entityManager.createQuery
                (" from User where id=:user_id", User.class).setParameter("user_id", id)
                .getResultList();
        return users.get(0);
    }

    @Override
    public User findByUserName(User user) {
        entityManager.find(User.class, user);
        List<User> users = entityManager.createQuery
                ("from User where username=:username and password=:password", User.class).getResultList();
        System.out.println(user.toString());
        System.out.println(user.getId());
        Long index = user.getId();
        return users.get(Math.toIntExact(index));
    }

    @Override
    public Boolean existById(Long id) {
        try {
            if (id != null || id != 0)
                return true;
            else
                return false;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

    }


}
