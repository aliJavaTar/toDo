package service;

import Entity.base.BaseEntity;
import repository.base.BaseRepository;
import service.UserActivityService;
import service.base.BaseServiceImpl;

import java.util.List;

public class UserActivityServiceImpl extends BaseServiceImpl implements UserActivityService {

    public UserActivityServiceImpl(BaseRepository repository) {
        super(repository);
    }

    @Override
    public BaseEntity save(BaseEntity baseEntity) {
        return null;
    }

    @Override
    public BaseEntity update(BaseEntity baseEntity) {
        return null;
    }

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public void deleteById(Object o) {

    }

    @Override
    public BaseEntity findById(Object o) {
        return null;
    }
}
