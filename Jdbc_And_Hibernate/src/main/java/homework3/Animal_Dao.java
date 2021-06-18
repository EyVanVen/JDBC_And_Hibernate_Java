package homework3;


import java.sql.SQLException;

public interface Animal_Dao {
    public void addAnimal(Animal animal) throws SQLException;

    public Animal getAnimal(int id) throws SQLException;

    public void updateAnimalAge(int id, int age) throws SQLException;

    public void updateAnimalName(int id, String name) throws SQLException;

    public void deleteAnimal(int id) throws SQLException;
}
