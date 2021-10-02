package Modelo;


import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    private static final String URL = "jdbc:postgresql://18.219.21.28:5432/samdemo";
    private static final String USERNAME = "samdemo";
    private static final String PASSWORD = "samdemo";

    public static Connection getConnection(){
        Connection connection = null;
        try{
            Class.forName("org.postgresql.Driver");
            connection = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }catch (Exception e){
            System.out.print("Error al crear la conexión a base de datos"+ e);
        }

        return connection;
    }

}
