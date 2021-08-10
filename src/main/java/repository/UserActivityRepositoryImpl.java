package repository;
import Entity.UserActivity;
import repository.base.BaseRepositoryImpl;
import util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;

public class UserActivityRepositoryImpl extends BaseRepositoryImpl<UserActivity, Long> implements UserActivityRepository {
    private final static EntityManagerFactory entityMangerFactory = HibernateUtil.entityManagerFactory;
    private final static EntityManager entityManager = entityMangerFactory.createEntityManager();

    public UserActivityRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public UserActivity save(UserActivity activity) {
        return null;
    }

    @Override
    public UserActivity update(UserActivity activity) {
    //    entityManager.find(UserActivity.class,id)
        return null;
    }

    @Override
    public List<UserActivity> findAll() {
        List<UserActivity> activities = new ArrayList<>();
        entityManager.getTransaction().begin();
        entityManager.persist(activities);
        entityManager.getTransaction().commit();
        entityManager.createQuery
                (" from UserActivity", UserActivity.class)
                .getResultList();
        return activities;
    }

    @Override
    public void deleteById(Long id) {
        entityManager.getTransaction().begin();
        UserActivity activity = entityManager.find(UserActivity.class, id);
        entityManager.remove(activity);
        entityManager.getTransaction().commit();
    }

    @Override
    public UserActivity findById(Long id) {
        entityManager.find(UserActivity.class, id);
        List<UserActivity> activities = entityManager.createQuery
                (" from User where id=:id", UserActivity.class).setParameter("id", id)
                .getResultList();
        return activities.get(0);
    }

    @Override
    public Boolean existById(Long id) {
        entityManager.find(UserActivity.class, id);
        List<UserActivity> activities = entityManager.createQuery
                (" from User where id=:id", UserActivity.class).setParameter("id", id)
                .getResultList();
        if (activities.get(0) != null)
            return true;
        else return false;
    }
}
