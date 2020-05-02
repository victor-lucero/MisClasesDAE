package pe.isil;

import pe.isil.dao.CourseDAO;
import pe.isil.model.Course;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Course course = new Course();
        //course.setId(100);
        course.setName("DAE 1");
        course.setCredits(4);
        course.setProfessorName("Jose Ventura");

        CourseDAO courseDAO = new CourseDAO();
//        courseDAO.create(course);
//        listAll();

//        course.setId(1);
//        course.setCredits(3);
//        course.setProfessorName("Marcelo");
//        courseDAO.update(course);
//        listAll();


        course.setId(1);
        courseDAO.delete(course);
        listAll();


    }

    public static void listAll(){
        CourseDAO courseDAO = new CourseDAO();
        List<Course> courses = courseDAO.getAll();
        for (Course c: courses){
            System.out.println("=>" + c);
        }
        System.out.println("\n");
    }

}
