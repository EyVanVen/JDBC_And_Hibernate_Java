package homework5.animal;

import homework5.animal.Animal;
import homework5.aviary.Aviary;
import homework5.vet.Vet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;


public class Animal_Dao_JDBC implements Animal_Dao {

    @Override
    public void addAnimal(Animal animal) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        session.persist(animal);

        session.flush();
        session.getTransaction().commit();
        session.close();
        factory.close();
    }

    @Override
    public Animal getAnimal(long id) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        Animal returnedAnimal = session.get(Animal.class, id);

        session.flush();
        session.getTransaction().commit();
        session.close();
        factory.close();
        return returnedAnimal;
    }

    @Override
    public List<Animal> getAll() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();// не использовать session.createCriteria, т.к. deprecated

        CriteriaQuery cq = cb.createQuery(Animal.class);


        Query query = session.createQuery(cq);

        List<Animal> resultList = query.getResultList();

        session.flush();
        factory.close();
        session.close();

        return resultList;
    }

    @Override
    public void updateById(long id, Animal animal) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        try {

            session.saveOrUpdate(animal);

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
    public void deleteAnimal(long id) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        session.delete(getAnimal(id));

        session.flush();
        session.getTransaction().commit();
        session.close();
        factory.close();
    }


}
