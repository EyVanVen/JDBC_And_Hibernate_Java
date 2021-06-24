package homework5;

import homework5.animal.Animal;
import homework5.animal.Animal_Dao_JDBC;
import homework5.aviary.Aviary;
import homework5.aviary.Aviary_Dao_Jdbc;
import homework5.vet.Vet;
import homework5.vet.Vet_Dao_Jdbc;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {


        Animal_Dao_JDBC animalManager = new Animal_Dao_JDBC();
        Aviary_Dao_Jdbc aviaryManager = new Aviary_Dao_Jdbc();
        Vet_Dao_Jdbc vetManager = new Vet_Dao_Jdbc();

        Animal bird1 = new Animal("bird 1", 3, true);
        Animal bird2 = new Animal("bird 2", 13, false);
        Animal bird3 = new Animal("bird 3", 7, true);

        animalManager.addAnimal(bird1);
        animalManager.addAnimal(bird2);
        animalManager.addAnimal(bird3);

        List<Animal> birdsList = animalManager.getAll();

        Animal fish1 = new Animal("Fish 1", 1, true);
        Animal fish2 = new Animal("Fish 2", 112, true);
        Animal fish3 = new Animal("Fish 3", 40, true);

        List<Animal> fishList = new ArrayList<>();
        fishList.add(fish1);
        fishList.add(fish2);
        fishList.add(fish3);

        Vet kira = new Vet("Kira", "093-231-32-42", "Morioh Vet");
        Vet komarovsky = new Vet("Komarovsky", "743-135-22-12", "Kiev vet clinic");

        vetManager.add(kira);
        vetManager.add(komarovsky);

        Aviary water = new Aviary("Ocean", 100, fishList);
        Aviary sky = new Aviary("sky", 955.50, birdsList);

        aviaryManager.add(water);
        aviaryManager.add(sky);
    }

    public static SessionFactory getFactory() {
        SessionFactory factory;

        Configuration configuration = new Configuration();
        Properties settings = new Properties();
        settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        settings.put(Environment.URL, "com.mysql.cj.jdbc.Driver");
        settings.put(Environment.USER, "com.mysql.cj.jdbc.Driver");
        settings.put(Environment.PASS, "com.mysql.cj.jdbc.Driver");
        settings.put(Environment.DIALECT, "com.mysql.cj.jdbc.Driver");
        settings.put(Environment.SHOW_SQL, "com.mysql.cj.jdbc.Driver");
        settings.put(Environment.HBM2DDL_AUTO, "com.mysql.cj.jdbc.Driver");
        configuration.setProperties(settings);
      //  configuration.addAnnotatedClass(homework5.vet.Vet);
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties())
                .build();
        factory = configuration.buildSessionFactory(serviceRegistry);

        return factory;

    }
}
