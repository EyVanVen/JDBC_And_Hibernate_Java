package homework2;

import java.sql.SQLException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws SQLException {
        Client_JDBC_DAO client_Dao = new Client_JDBC_DAO();

        Client giorno = new Client("Giorno Giovanna", 16, "01293-32562");

        client_Dao.addClient(giorno);

        System.out.println(client_Dao.getClient(1));

        System.out.println(client_Dao.getAllClients());

        client_Dao.deleteClient(7);

        client_Dao.deleteClient(15);
        client_Dao.deleteClient(16);
        client_Dao.deleteClient(17);

        System.out.println("========================================");

        System.out.println(client_Dao.getAllClients());

        client_Dao.updateClientName(6, "Alto Clef");
        client_Dao.updateClientPhone(6, "████-██-██");

        System.out.println(client_Dao.getAllClients());
    }
}
