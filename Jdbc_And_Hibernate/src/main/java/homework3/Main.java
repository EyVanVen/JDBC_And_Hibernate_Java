package homework3;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Animal tvarina = new Animal("Tvarina", 11, true);
        Animal scott = new Animal("Scott", 11, true);
        Animal kira = new Animal("Kira", 11, true);

        Animal_Dao_JDBC tableManager = new Animal_Dao_JDBC();

        tableManager.addAnimal(tvarina);
        tableManager.addAnimal(scott);
        tableManager.addAnimal(kira);

    }
}
