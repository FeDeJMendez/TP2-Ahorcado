package LabV2.BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;

public class Conexion {
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/tp2ahorcado?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "";
    private static Conexion instance;
    private Connection conn = null;

    public static Conexion getInstance() {
        instance = Optional.ofNullable(instance).orElse(new Conexion());
        return instance;
    }

    private Conexion(){
    }

    public Connection getConnection() {
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("MySql Driver not installed");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error connecting to database");
        }
        return conn;
    }
}
