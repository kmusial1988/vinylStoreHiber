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

//TODO null przy rejstrCJI
    @Override
    public User authentication(User user) {
        return this.userService.authentication(user);
    }


    @Override
    public boolean checkIfLoginExist(String login) {
        return this.userService.checkIfLoginExist(login);
    }

    @Override
    public void addUser(User user) {
        this.userService.addUser(user);

    }

    @Override
    public User updateUserData(User user) {
       return this.userService.updateUserDB(user);

    }

    @Override
    public User updateUserPass(User user) {
        return this.userService.updateUserPass(user);
    }

}
