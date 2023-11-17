package hnist.javafx.kqms.bg.controller;

import hnist.javafx.kqms.bg.mapper.StudentMapper;
import hnist.javafx.kqms.pojo.Student;

import java.util.List;

public class StudentController {
    static private final StudentMapper studentMapper = MapperGenerator.getStudentMapper();

    static public void addStudent(Student student) {
        studentMapper.addStudent(student);
    }

    static public boolean getStudentIfExistByNo(String no) {
        return studentMapper.getStudentIfExistByNo(no);
    }

    static public List<Student> getStudentByNoAndName(String no, String name) {
        return studentMapper.getStudentByNoAndName(no, name);
    }
}
