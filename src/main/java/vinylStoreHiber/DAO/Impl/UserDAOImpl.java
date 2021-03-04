package vinylStoreHiber.DAO.Impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vinylStoreHiber.DAO.IUserDAO;
import vinylStoreHiber.model.User;

import javax.persistence.NoResultException;
@Repository
public class UserDAOImpl implements IUserDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public User getUserByLogin(String login) {
        try {
            Session session = sessionFactory.openSession();
            Query<User> query = session
                    .createQuery("FROM vinylStoreHiber.model.User WHERE login = :login");
            query.setParameter("login", login);
            User user = query.getSingleResult();
            session.close();
            return user;
        } catch (NoResultException e) {
            return null;
        }
    }
}
