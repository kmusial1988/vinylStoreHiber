package vinylStoreHiber.DAO;

import vinylStoreHiber.model.User;

public interface IUserDAO {
    User getUserByLogin(String login);
}
