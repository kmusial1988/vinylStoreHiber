package vinylStoreHiber.dataBase.impl;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vinylStoreHiber.DAO.IUserDAO;
import vinylStoreHiber.dataBase.IUserRepository;
import vinylStoreHiber.model.User;
import vinylStoreHiber.services.IUserService;

@Component
public class HBUserRepositoryImpl implements IUserRepository {


    @Autowired
    IUserDAO userDAO;
    @Autowired
    IUserService userService;

    @Autowired
    SessionFactory sessionFactory;


    @Override
    public User authentication(User user) {
        return this.userService.authentication(user);
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
