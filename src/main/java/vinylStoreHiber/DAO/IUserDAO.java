package vinylStoreHiber.DAO;

import vinylStoreHiber.model.User;

import java.util.List;

public interface IUserDAO {

    User getUserByLogin(String login);

    void addUser(User user);

    void upgradeUser(User user);
}
