import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.swing.tree.TreeNode;

public class StatusService {

    private static StatusService instance;

    public StatusService() {

    }

    public static StatusService getInstance() {
        if (instance == null) {
            instance = new StatusService();
        }
        return instance;
    }

    public Status getStatus(Integer id) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Status status1 = session.find(Status.class, id);
            return status1;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void createStatus(Status status) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();

            session.save(status);

            transaction.commit();
            session.close();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    public void updateStatus(Status status) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();

            session.update(status);

            transaction.commit();
            session.close();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    public void deleteStatus(Status status) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();

            session.delete(status);

            transaction.commit();
            session.close();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }
}
