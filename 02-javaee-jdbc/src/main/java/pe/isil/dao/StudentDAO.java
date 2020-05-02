package pe.isil.dao;

import pe.isil.model.Student;
import pe.isil.util.DataBaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public void create (Student student){

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

    public void update(Student student){

        Connection connection = null;

        try {
            connection = DataBaseUtil.getConnection();

            final String sql = "UPDATE tbl_student SET name = ?, last_name_father = ?, last_name_mother = ?, age = ? WHERE id = ? ";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, student.getName());
            ps.setString(2, student.getLastNameFather());
            ps.setString(3, student.getLastNameMother());
            ps.setInt(4, student.getAge());
            ps.setInt(5, student.getId());

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

    public void delete (Student student){

        Connection connection = null;

        try {
            connection = DataBaseUtil.getConnection();
            final String sql = "DELETE FROM tbl_student WHERE id = ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, student.getId());

            ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }




    public List<Student> getAll(){
        List<Student> students = new ArrayList<Student>();

        Connection connection = null;

        try {
            connection = DataBaseUtil.getConnection();

            final String sql = "SELECT * FROM tbl_student";

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String lastNameFather = resultSet.getString("last_name_father");
                String lastNameMother = resultSet.getString("last_name_mother");
                int age = resultSet.getInt("age");

                Student student = new Student(id, name, lastNameFather, lastNameMother, age);
                students.add(student);
            }

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

        return students;
    }


    public Student getById( Integer id){

        Student student = null;

        Connection connection = null;

        try {
            connection = DataBaseUtil.getConnection();
            final String sql = "SELECT * FROM tbl_student WHERE id = ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                int studentId = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String lastNameFather = resultSet.getString("last_name_father");
                String lastNameMother = resultSet.getString("last_name_mother");
                int age = resultSet.getInt("age");

                student = new Student(studentId, name, lastNameFather, lastNameMother, age);

            }

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

        return student;
    }


}
