package homework5.aviary;

import homework5.animal.Animal;
import homework5.vet.Vet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class Aviary_Dao_Jdbc implements Aviary_Dao{
    @Override
    public void add(Aviary aviary) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        session.save(aviary);

        session.flush();
        session.getTransaction().commit();
        session.close();
        factory.close();
    }

    @Override
    public List<Aviary> getAll() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();// не использовать session.createCriteria, т.к. deprecated

        CriteriaQuery cq = cb.createQuery(Vet.class);


        Query query = session.createQuery(cq);

        List<Aviary> resultList = query.getResultList();

        session.flush();
        factory.close();
        session.close();

        return resultList;
    }

    @Override
    public Aviary getById(long id) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        Aviary returnedAviary = session.get(Aviary.class, id);

        session.flush();
        session.getTransaction().commit();
        session.close();
        factory.close();
        return returnedAviary;
    }

    @Override
    public void updateById(long id, Aviary aviary) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        try {

            session.saveOrUpdate(aviary);

            System.out.println("Rows affected: " + 1);

            System.out.println("Successfully updated");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.getTransaction().commit();
            session.close();
            factory.close();
        }
    }

    @Override
    public void removeById(long id) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        session.delete(getById(id));

        session.flush();
        session.getTransaction().commit();
        session.close();
        factory.close();
    }
}
