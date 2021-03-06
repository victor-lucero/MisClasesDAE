package pe.isil.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseUtil {

    private static final String URL = "jdbc:mysql://localhost:3306/isil_dae1_db?useTimezone=true&serverTimezone=UTC";
    private static final String USER = "isil_dae1_user";
    private static final String PASSWORD = "isil_dae1_password";

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {

        Class.forName(DRIVER);

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }


    public static void main(String[] args) {

        try {
            DataBaseUtil.getConnection();
            System.out.println("Conexion satisfactoria!");

        } catch (SQLException throwables) {
            System.err.println("Error de conexion a BD");
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.err.println("El Driver no se encuentra");
            e.printStackTrace();
        }

    }

}
