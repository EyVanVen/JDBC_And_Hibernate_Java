package homework5.animal;


import homework5.animal.Animal;
import homework5.vet.Vet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.sql.SQLException;
import java.util.List;

public interface Animal_Dao {
    public void addAnimal(Animal animal) throws SQLException;


    public List<Animal> getAll();


    public Animal getAnimal(long id) throws SQLException;

    public void updateById(long id, Animal animal) throws SQLException;

    public void deleteAnimal(long id) throws SQLException;
}
