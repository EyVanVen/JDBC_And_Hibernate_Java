package homework2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Client_JDBC_DAO implements Client_DAO{

    String URL = "jdbc:mysql://localhost:3306/CarShop";
    String LOGIN = "root";
    String PASSWORD = "92837";


    @Override
    public void addClient(Client client) throws SQLException {

        Connection con = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        PreparedStatement stat;

        stat = con.prepareStatement("INSERT INTO clients(name, age, phone) VALUES (?, ?, ?)");

        stat.setString(1, client.getName());
        stat.setInt(2, client.getAge());
        stat.setString(3, client.getPhone());

        stat.execute();
    }

    @Override
    public Client getClient(int id) throws SQLException {
        Connection con = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        PreparedStatement stat;

        stat = con.prepareStatement("SELECT id, name, age, phone FROM clients WHERE id = ?;");

        stat.setInt(1, id);

        ResultSet rs = stat.executeQuery();


        if (rs.next()) {

            String name = rs.getString(2);
            int age = rs.getInt(3);
            String phone = rs.getString(4);

            Client client = new Client();

            client.setId(id);
            client.setName(name);
            client.setAge(age);
            client.setPhone(phone);

            return client;
        }
        return null;
    }

    @Override
    public List<Client> getAllClients() throws SQLException {
        Connection con = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        PreparedStatement stat;

        List<Client> allClients = new ArrayList<>();
        PreparedStatement statement = null;

        try {
            statement = con.prepareStatement("SELECT id, name, age, phone FROM clients;");

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Client client = new Client(rs.getLong("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("phone"));

                allClients.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allClients;
    }

    @Override
    public void updateClientPhone(int id, String phone) throws SQLException {
        Connection con = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        PreparedStatement stat;

        stat = con.prepareStatement("UPDATE clients SET phone = ? WHERE id = ?;");

        stat.setString(1, phone);
        stat.setInt(2, id);

        stat.execute();
    }

    @Override
    public void updateClientName(int id, String name) throws SQLException {
        Connection con = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        PreparedStatement stat;

        stat = con.prepareStatement("UPDATE clients SET name = ? WHERE id = ?;");

        stat.setString(1, name);
        stat.setInt(2, id);

        stat.execute();
    }

    @Override
    public void deleteClient(int id) throws SQLException {
        Connection con = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        PreparedStatement stat;

        stat = con.prepareStatement("DELETE FROM clients WHERE id = ?;");

        stat.setInt(1, id);

        stat.execute();
    }
}
