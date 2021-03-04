package vinylStoreHiber.services.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vinylStoreHiber.DAO.IUserDAO;
import vinylStoreHiber.model.User;
import vinylStoreHiber.services.IUserService;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    IUserDAO userDAO;

    @Autowired
    SessionFactory sessionFactory;


    @Override
    public User authentication(User user) {
        User userFromDB = this.userDAO.getUserByLogin(user.getLogin());

        if (userFromDB.getLogin().equals(user.getLogin())) {
            if (userFromDB.getPass().equals(user.getPass())) {
                return userFromDB;
            } else {
                return null;
            }
        }
        return null;
    }
}
