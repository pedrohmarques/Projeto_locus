package ConexaoBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
public class DAL {
    public String Login;
    public String MotDePasse;
    private boolean Logged = false;

    public void StartBdd() throws ClassNotFoundException, SQLException {
        String driverName = "com.mysql.jdbc.Driver";
        Class.forName(driverName); // here is the ClassNotFoundException

        String serverName = "localhost";
        String mydatabase = "mydb";
        String url = "jdbc:mysql://" + serverName + "/" + mydatabase;

        String username = "root";
        String password = "";
        Connection connection = DriverManager.getConnection(url, username, password);

    }
}

