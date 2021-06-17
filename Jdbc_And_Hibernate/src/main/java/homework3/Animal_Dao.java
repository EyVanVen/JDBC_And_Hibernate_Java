package homework3;


import java.sql.SQLException;

public interface Animal_Dao {
    public void addAnimal(Animal animal) throws SQLException;

    public Animal getAnimal(long id) throws SQLException;

    public void updateAnimalAge(long id, int age) throws SQLException;

    public void updateAnimalName(long id, String name) throws SQLException;

    public void deleteAnimal(long id) throws SQLException;
}
