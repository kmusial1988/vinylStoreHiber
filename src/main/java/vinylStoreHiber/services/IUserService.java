package vinylStoreHiber.services;

import vinylStoreHiber.model.User;

public interface IUserService {

    User authentication(User user);

    boolean checkIfLoginExist(String login);

    void addUser(User user);

    User updateUserData(User user);

    User updateUserPass(User user);

    User getUserByLogin(String login);
}
