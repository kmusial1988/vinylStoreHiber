package vinylStoreHiber.dataBase;

import vinylStoreHiber.model.User;


public interface IUserRepository {
    User authentication(User user);
    User updateUserData(User user);
    User updateUserPass(User user);
    boolean checkIfLoginExist(String login);
    void addUser(User user);
}
