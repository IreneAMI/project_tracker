import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.swing.tree.TreeNode;

public class ItemService {


    private static ItemService instance;

    public ItemService() {

    }

    public static ItemService getInstance() {
        if (instance == null) {
            instance = new ItemService();
        }
        return instance;
    }

    public Item getItem(Integer id) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Item item1 = session.find(Item.class, id);
            return item1;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void createItem(Item item) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();

            session.save(item);

            transaction.commit();
            session.close();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    public void updateItem(Item item) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();

            session.update(item);

            transaction.commit();
            session.close();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    public void deleteItem(Item item) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();

            session.delete(item);

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