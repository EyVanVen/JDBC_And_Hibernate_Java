package homework3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;



public class Animal_Dao_JDBC implements Animal_Dao{

    @Override
    public void addAnimal(Animal animal) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        session.save(animal);

        session.flush();
        session.getTransaction().commit();
        session.close();
        factory.close();
    }

    @Override
    public Animal getAnimal(int id) {
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
    public void updateAnimalAge(int id, int age) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        try {

            Animal tempAnimal = getAnimal(id);
            tempAnimal.setAge(age);

            session.saveOrUpdate(tempAnimal);

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
    public void updateAnimalName(int id, String name) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.getCurrentSession();

        session.beginTransaction();
        try {
            Animal tempAnimal = getAnimal(id);
            tempAnimal.setName(name);

            session.saveOrUpdate(tempAnimal);

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
    public void deleteAnimal(int id) {
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
