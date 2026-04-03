package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionDB {

    private static Connection connection;

    public static Connection getConnection(){

        try {

            if(connection == null){

                Class.forName("com.mysql.cj.jdbc.Driver");

                connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/biblioteca",
                        "root",
                        "Aragon0812>"
                );

                System.out.println("Conexion exitosa a MySQL");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }
}