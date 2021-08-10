package service;

import Entity.User;
import repository.base.BaseRepository;
import service.base.BaseService;

import java.util.List;

public interface UserService extends BaseService<User, Long>{
    @Override
    User update(User user);

    @Override
    User findById(Long aLong);

    @Override
    List<User> findAll();
}
