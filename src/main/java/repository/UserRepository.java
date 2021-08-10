package repository;

import Entity.User;
import repository.base.BaseRepository;

import java.util.List;

public interface UserRepository extends BaseRepository<User,Long>
{

//    @Override
//    User save(User user);
//
//    @Override
//    User update(User user);
//
//    @Override
//    User findById(Long aLong);
//
//    @Override
//    List<User> findAll();
//
//    @Override
//    void deleteById(Long aLong);

    User findByUserName(User user);


}
