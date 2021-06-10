package homework1;

import java.sql.*;

public class Java_Join {

    static final String URL = "jdbc:mysql://localhost:3306/MyJoinsDB";
    static final String LOGIN = "root";
    static final String PASSWORD = "92837";

    public static void main(String[] args) throws SQLException {
        connect_driver();

        Connection con = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        Statement stat = con.createStatement();

        stat.addBatch("SELECT NamesAndNumbers.NAME, NamesAndNumbers.PHONES, City FROM NamesAndNumbers " +
                "JOIN family ON NamesAndNumbers.NAME = family.NAME;");
        stat.addBatch("SELECT family.NAME, NamesAndNumbers.PHONES, family.Birthday, family.Married_status FROM" +
                " family family INNER JOIN NamesAndNumbers NamesAndNumbers ON NamesAndNumbers.name = family.name" +
                " where family.Married_status = \"Alone\";");
        stat.addBatch("SELECT NamesAndNumbers.NAME, birthday, phones from NamesAndNumber JOIN PostAndSalary on" +
                " NamesAndNumbers.name = PostAndSalary.name JOIN family on NamesAndNumbers.name = family.name" +
                " where PostAndSalary.post = 'Manager';");
    }

    public static void connect_driver (){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connected successfully!");
        }
        catch(Exception ex){
            System.out.println("Connection failed...");

            System.out.println(ex);
        }
    }
}
