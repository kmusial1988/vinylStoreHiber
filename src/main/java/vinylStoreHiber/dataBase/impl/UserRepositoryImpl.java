package vinylStoreHiber.dataBase.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import vinylStoreHiber.dataBase.IUserRepository;
import vinylStoreHiber.model.User;


public class UserRepositoryImpl implements IUserRepository {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public User authentication(User user) {
        return null;
    }

    @Override
    public User updateUserData(User user) {
        return null;
    }

    @Override
    public User updateUserPass(User user) {
        return null;
    }

    @Override
    public boolean checkIfLoginExist(String login) {
        return false;
    }

    @Override
    public void addUser(User user) {

    }
}