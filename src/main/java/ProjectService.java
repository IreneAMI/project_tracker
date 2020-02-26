import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProjectService {


    private static ProjectService instance;

    public ProjectService() {

    }

    public static ProjectService getInstance() {
        if (instance == null) {
            instance = new ProjectService();
        }
        return instance;
    }

    public static Project getProject(Integer id) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Project project1 = session.find(Project.class, id);
            return project1;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static Project getProjects(Integer id) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Project project1 = session.find(Project.class, id);
            return project1;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void createProject(Project project) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();

            session.save(project);

            transaction.commit();
            session.close();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    public void updateProject(Project project) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();

            session.update(project);

            transaction.commit();
            session.close();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    public void deleteProject(Project project) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();

            session.delete(project);

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