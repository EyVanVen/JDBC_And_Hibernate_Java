package homework1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Java_Join {

    static final String URL = "jdbc:mysql://localhost:3306/MyJoinsDB";
    static final String LOGIN = "root";
    static final String PASSWORD = "92837";

    public static void main(String[] args) throws SQLException {
        connect_driver();

        Connection con = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        Statement stat = con.createStatement();

        stat.execute("SELECT NamesAndNumbers.NAME, NamesAndNumbers.PHONES, City FROM NamesAndNumbers " +
                "JOIN family ON NamesAndNumbers.NAME = family.NAME;");
        stat.execute("SELECT family.NAME, NamesAndNumbers.PHONES, family.Birthday, family.Married_status FROM" +
                " family family INNER JOIN NamesAndNumbers NamesAndNumbers ON NamesAndNumbers.name = family.name" +
                " where family.Married_status = \"Alone\";");
        stat.execute("SELECT NamesAndNumbers.NAME, birthday, phones from NamesAndNumbers\n" +
                "\t\tJOIN PostAndSalary on NamesAndNumbers.name = PostAndSalary.name\n" +
                "\t\tJOIN family on NamesAndNumbers.name = family.name\n" +
                "\t\twhere PostAndSalary.post = 'Manager';");

        createADatabase();
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

    public static void createADatabase () throws SQLException {
        Connection con = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        Statement stat = con.createStatement();

        stat.execute("DROP DATABASE IF EXISTS NewDB");
        stat.execute("CREATE DATABASE NewDB");
        stat.execute("USE NewDB");

        stat.execute("CREATE TABLE NameTable(" +
                "Name varchar(30)," +
                "Surname varchar(30))");

        stat.execute("INSERT INTO NameTable (Name, Surname) VALUES (\"Kira\", \"Yoshikage\")");
        stat.execute("INSERT INTO NameTable (Name, Surname) VALUES (\"Josuke\", \"Higashikata\")");
        stat.execute("INSERT INTO NameTable (Name, Surname) VALUES (\"Gyro\", \"Zeppily\")");
        stat.execute("INSERT INTO NameTable (Name, Surname) VALUES (\"Franz\", \"Ferdinant\")");

        stat.execute("SELECT * FROM NameTable");


    }
}

