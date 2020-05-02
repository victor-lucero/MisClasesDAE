package pe.isil;

import pe.isil.dao.StudentDAO;
import pe.isil.model.Course;
import pe.isil.model.Student;

public class Main {

    public static void main(String[] args) {

        Student student = new Student();
        student.setName("Jose");
        student.setLastNameFather("Ventura");
        student.setLastNameMother("Arteaga");
        student.setAge(23);

        Course course = new Course();
        course.setId(100);
        course.setName("Desarrollo de Aplicaciones Empresariales 1");
        course.setCredits(4);
        course.setProfessorName("Jose V.");

        StudentDAO studentDAO = new StudentDAO();
        studentDAO.crear(student);


        System.out.println(student);
        System.out.println(course);

    }

}
