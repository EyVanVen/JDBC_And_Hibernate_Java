package homework3;

import java.io.File;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.query.Query;

import javax.imageio.spi.ServiceRegistry;


public class Animal_Dao_JDBC implements Animal_Dao{

    SessionFactory factory = new Configuration()
            .configure()
            .buildSessionFactory();

    Session session = factory.getCurrentSession();


    @Override
    public void addAnimal(Animal animal) throws SQLException {
        session.beginTransaction();

        session.save(animal);

        session.flush();
        session.getTransaction().commit();
        session.close();
        factory.close();
    }

    @Override
    public Animal getAnimal(long id) throws SQLException {
        session.beginTransaction();

        Animal returnedAnimal = session.get(Animal.class, id);

        session.flush();
        session.getTransaction().commit();
        session.close();
        factory.close();
        return returnedAnimal;
    }

    @Override
    public void updateAnimalAge(long id, int age) throws SQLException {

        session.beginTransaction();

        try {
            Transaction transaction = session.beginTransaction();

            String queryString = "UPDATE animals SET age = ? where id = ?";

            Query query = session.createQuery(queryString);

            query.setParameter(1, age);
            query.setParameter(2, id);

            int result = query.executeUpdate();

            System.out.println("Rows affected: " + result);

            System.out.println("Successfully updated");
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }

        session.flush();
        session.getTransaction().commit();
        session.close();
        factory.close();
    }

    @Override
    public void updateAnimalName(long id, String name) throws SQLException {
        session.beginTransaction();

        try {
            Transaction transaction = session.beginTransaction();

            String queryString = "UPDATE animals SET name = ? where id = ?";

            Query query = session.createQuery(queryString);

            query.setParameter(1, name);
            query.setParameter(2, id);

            int result = query.executeUpdate();

            System.out.println("Rows affected: " + result);

            System.out.println("Successfully updated");
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }

        session.flush();
        session.getTransaction().commit();
        session.close();
        factory.close();
    }

    @Override
    public void deleteAnimal(long id) throws SQLException {
        session.beginTransaction();

        session.delete(getAnimal(id));

        session.flush();
        session.getTransaction().commit();
        session.close();
        factory.close();
    }

//    public static SessionFactory getFactory (){
//        if (factory == null){
//            try{
//                Configuration configuration = new Configuration();
//                Properties settings = new Properties();
//                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
//                settings.put(Environment.URL, "com.mysql.cj.jdbc.Driver");
//                settings.put(Environment.USER, "com.mysql.cj.jdbc.Driver");
//                settings.put(Environment.PASS, "com.mysql.cj.jdbc.Driver");
//                settings.put(Environment.DIALECT, "com.mysql.cj.jdbc.Driver");
//                settings.put(Environment.SHOW_SQL, "com.mysql.cj.jdbc.Driver");
//                settings.put(Environment.HBM2DDL_AUTO, "com.mysql.cj.jdbc.Driver");
//                configuration.setProperties(settings);
//                configuration.addAnnotatedClass(Animal.class);
//                StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
//                        .applySettings(configuration.getProperties())
//                        .build();
//                factory = configuration.buildSessionFactory(serviceRegistry);
//
//            } catch (Exception e){
//                e.printStackTrace();
//            }
//        }
//        return factory;
//    } doesn't work, idk why :(
}
