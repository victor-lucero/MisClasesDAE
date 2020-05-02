package pe.isil.dao;

import pe.isil.model.Student;
import pe.isil.util.DataBaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDAO {

    public void crear (Student student){

        Connection connection = null;

        try {
            connection = DataBaseUtil.getConnection();

            final String sql = "INSERT INTO tbl_student (name, last_name_father, last_name_mother, age) values ( ?, ?, ?, ? )";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, student.getName());
            ps.setString(2, student.getLastNameFather());
            ps.setString(3, student.getLastNameMother());
            ps.setInt(4, student.getAge());

            ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

    }


}
