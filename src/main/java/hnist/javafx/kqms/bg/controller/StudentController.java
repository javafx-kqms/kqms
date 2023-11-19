package hnist.javafx.kqms.bg.controller;

import hnist.javafx.kqms.bg.mapper.StudentMapper;
import hnist.javafx.kqms.pojo.Student;

import java.util.List;

public class StudentController {
    static private final StudentMapper studentMapper = MapperGenerator.getStudentMapper();

    static public void addStudent(Student student) {
        studentMapper.addStudent(student);
    }

    static public void deleteStudent(String no) {
        studentMapper.deleteStudent(no);
    }

    static public void modifyStudent(Student student) {
        studentMapper.modifyStudent(student);
    }

    static public boolean getStudentIfExist(String no) {
        return studentMapper.getStudentIfExist(no);
    }

    static public List<Student> getStudent(String no, String name) {
        return studentMapper.getStudent(no, name);
    }
}
