import org.hibernate.Session;
import org.hibernate.Transaction;

public class CommentService {

    private static CommentService instance;

    public CommentService() {

    }

    public static CommentService getInstance() {
        if (instance == null) {
            instance = new CommentService();
        }
        return instance;
    }

    public Status getComment(Integer id) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Status comment1 = session.find(Status.class, id);
            return comment1;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void createComment(Comment comment) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();

            session.save(comment);

            transaction.commit();
            session.close();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    public void updateComment(Comment comment) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();

            session.update(comment);

            transaction.commit();
            session.close();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    public void deleteComment(Comment comment) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();

            session.delete(comment);

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
