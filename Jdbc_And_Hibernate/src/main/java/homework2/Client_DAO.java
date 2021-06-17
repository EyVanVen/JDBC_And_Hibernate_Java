package homework2;

import java.sql.SQLException;
import java.util.List;

public interface Client_DAO {
    public void addClient(Client client) throws SQLException;

    public Client getClient(int id) throws SQLException;

    public List<Client> getAllClients() throws SQLException;

    public void updateClientPhone(int id, String phone) throws SQLException;
    public void updateClientName(int id, String name) throws SQLException;

    public void deleteClient(int id) throws SQLException;

}
