package homework5.vet;

import homework3.Animal;
import homework5.aviary.Aviary;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;
import java.util.List;

public class Vet_Dao_Jdbc implements VetDAO{

    @Override
    public void add(Vet vet) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        session.save(vet);

        session.flush();
        session.getTransaction().commit();
        session.close();
        factory.close();
    }

    @Override
    public List<Vet> getAll() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();// не использовать session.createCriteria, т.к. deprecated

        CriteriaQuery cq = cb.createQuery(Vet.class);


        Query query = session.createQuery(cq);

        List<Vet> resultList = query.getResultList();

        session.flush();
        factory.close();
        session.close();

        return resultList;
    }

    @Override
    public Vet getById(long id) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        Vet returnedVet = session.get(Vet.class, id);

        session.flush();
        session.getTransaction().commit();
        session.close();
        factory.close();
        return returnedVet;
    }

    @Override
    public void updateById(long id, Vet vet) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        try {

            session.saveOrUpdate(vet);

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
