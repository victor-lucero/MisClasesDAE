package pe.isil;

import pe.isil.dao.StudentDAO;
import pe.isil.model.Student;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        StudentDAO studentDAO = new StudentDAO();

//        Student student = new Student();
//        //student.setId(1);
//        student.setName("Jose");
//        student.setLastNameFather("Ventura");
//        student.setLastNameMother("Arteaga");
//        student.setAge(30);
//
//        listAll();
//        System.out.println("\n");
//
//        studentDAO.create(student);
//
//        listAll();
//        System.out.println("\n");
//
//        student.setId(3);
//        student.setLastNameFather("AAAAAA");
//        student.setLastNameMother("BBBBBB");
//
//        studentDAO.update(student);
//
//        listAll();
//        System.out.println("\n");
//
//        studentDAO.delete(student);
//
//        listAll();


        Student currentStudent = studentDAO.getById(2);
        System.out.println(currentStudent);

        //System.out.println(student);

    }

    public static void listAll(){
        StudentDAO studentDAO = new StudentDAO();
        List<Student> students = studentDAO.getAll();
        for (Student s: students){
            System.out.println("=>" + s);
        }
    }


}
