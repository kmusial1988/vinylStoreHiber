package vinylStoreHiber.services.impl;

import org.apache.commons.codec.digest.DigestUtils;
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

        if (userFromDB != null && userFromDB.getPass().equals(user.getPass())) {
            return userFromDB;
        }
        return null;

    }


    @Override
    public boolean checkIfLoginExist(String login) {
        User userFromDB = this.userDAO.getUserByLogin(login);
        if (!userFromDB.getLogin().equals(login)) {
            return false;

        }
        return true;
    }

    @Override
    public void addUser(User user) {
        this.userDAO.addUser(user);
    }

    @Override
    public User updateUserDB(User user) {
        User userFromDB = userDAO.getUserByLogin(user.getLogin());
        if (userFromDB.getLogin().equals(user.getLogin())) {
            userFromDB.setName(user.getName());
            userFromDB.setSurname(user.getSurname());
            this.userDAO.upgradeUser(userFromDB);
            return userFromDB;
        }
        return null;
    }

    @Override
    public User updateUserPass(User user) {
        User userFromDB = userDAO.getUserByLogin(user.getLogin());
        if (userFromDB.getLogin().equals(user.getLogin())) {
            userFromDB.setPass(user.getPass());
            this.userDAO.upgradeUser(userFromDB);
            return userFromDB;
        }
        return null;
    }

}
