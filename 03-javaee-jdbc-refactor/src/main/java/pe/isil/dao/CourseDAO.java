package pe.isil.dao;

import pe.isil.model.Course;
import pe.isil.util.DataBaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO implements BaseDAO<Course, Integer>{

    public void create(Course course) {
        try(Connection connection = DataBaseUtil.getConnection()){
            final String sql = "INSERT INTO tbl_course_jva (name, credits, professorName) values ( ?, ?, ? )";
            try(PreparedStatement ps = connection.prepareStatement(sql)){
                ps.setString(1, course.getName());
                ps.setInt(2, course.getCredits());
                ps.setString(3, course.getProfessorName());
                ps.executeUpdate();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void update(Course course) {
        try(Connection connection = DataBaseUtil.getConnection()){
            final String sql = "UPDATE tbl_course_jva SET name = ?, credits = ?, professorName = ? WHERE id = ?";
            try(PreparedStatement ps = connection.prepareStatement(sql)){
                ps.setString(1, course.getName());
                ps.setInt(2, course.getCredits());
                ps.setString(3, course.getProfessorName());
                ps.setInt(4, course.getId());
                ps.executeUpdate();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void delete(Course course) {
        try(Connection connection = DataBaseUtil.getConnection()){
            final String sql = "DELETE FROM tbl_course_jva WHERE id = ?";
            try(PreparedStatement ps = connection.prepareStatement(sql)){
                ps.setInt(1, course.getId());
                ps.executeUpdate();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<Course> getAll() {
        List<Course> courses = new ArrayList<>();
        try(Connection connection = DataBaseUtil.getConnection()){
            final String sql = "SELECT * FROM tbl_course_jva ";
            try(Statement statement = connection.createStatement()){
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()){
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    int credits = resultSet.getInt("credits");
                    String professorName = resultSet.getString("professorName");
                    Course course = new Course(id, name, credits, professorName);
                    courses.add(course);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return courses;
    }

    public Course getById(Integer id) {
        Course course = null;
        try(Connection connection = DataBaseUtil.getConnection()){
            final String sql = "SELECT * FROM tbl_course_jva WHERE id = ?";
            try(PreparedStatement ps = connection.prepareStatement(sql)){
                ps.setInt(1, id);
                ResultSet resultSet = ps.executeQuery();
                while (resultSet.next()){
                    int courseId = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    int credits = resultSet.getInt("credits");
                    String professorName = resultSet.getString("professorName");
                    course = new Course(courseId, name, credits, professorName);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return course;
    }
}
