package homework3;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        Animal tvarina = new Animal("Tvarina", 11, true);
        Animal scott = new Animal("Scott", 1, true);
        Animal kira = new Animal("Kira", 33, false);

        Animal_Dao_JDBC tableManager = new Animal_Dao_JDBC();

        tableManager.addAnimal(tvarina);
        tableManager.addAnimal(scott);
        tableManager.addAnimal(kira);

        System.out.println(tableManager.getAnimal(2));

        tableManager.updateAnimalAge(1, 73);

        tableManager.updateAnimalName(3, "Yoshikage");

        System.out.println(tableManager.getAnimal(1));
        System.out.println(tableManager.getAnimal(2));
        System.out.println(tableManager.getAnimal(3));

        tableManager.deleteAnimal(3);
    }
}
