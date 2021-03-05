package vinylStoreHiber.DAO.Impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vinylStoreHiber.DAO.IVinylDAO;
import vinylStoreHiber.model.User;
import vinylStoreHiber.model.Vinyl;

import javax.persistence.NoResultException;
import java.util.List;

@Repository
public class VinylDAOImpl implements IVinylDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Vinyl> getAllVinyl(){
        try {
            Session session = this.sessionFactory.openSession();
            Query<Vinyl> query = session
                    .createQuery("FROM vinylStoreHiber.model.Vinyl");
            List<Vinyl> result = query.getResultList();
            session.close();

            return result;
        } catch (NoResultException e) {
            return null;
        }
    }
    @Override
    public List<Vinyl> getProductByCategory(Vinyl.Category category) {
        try {
        Session session = this.sessionFactory.openSession();

        Query<Vinyl> query = session
                .createQuery("FROM vinylStoreHiber.model.Vinyl WHERE category = :category");
        query.setParameter("category", category);
        List<Vinyl> result = query.getResultList();
        session.close();
        return result;
        } catch (NoResultException e) {
            return null;
        }
    }
    @Override
    public Vinyl getVinylByISBN(String isbn){
        try {
            Session session = sessionFactory.openSession();
            Query<Vinyl> query = session
                    .createQuery("FROM vinylStoreHiber.model.Vinyl WHERE isbn = :isbn");
            query.setParameter("isbn", isbn);
            Vinyl vinyl = query.getSingleResult();
            session.close();
            return vinyl;
        } catch (NoResultException e) {
            return null;
        }
    }
    @Override
    public void addVinyl(Vinyl vinyl) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(vinyl);
            tx.commit();
        } catch (Exception e) {
            if(tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }

    }

    @Override
    public void updateVinyl(Vinyl vinyl) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(vinyl);
            tx.commit();
        } catch (Exception e) {
            if(tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }

    }

}
