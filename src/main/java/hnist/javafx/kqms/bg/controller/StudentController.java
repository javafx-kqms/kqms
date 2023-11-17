package hnist.javafx.kqms.bg.controller;

import hnist.javafx.kqms.bg.mapper.StudentMapper;
import hnist.javafx.kqms.pojo.Student;

public class StudentController {
    static private final StudentMapper studentMapper = MapperGenerator.getStudentMapper();

    static public boolean getStudentIfExistByNo(String no) {
        System.out.println(no);
        return studentMapper.getStudentIfExistByNo(no);
    }

    static public void addStudent(Student student) {
        studentMapper.addStudent(student);
    }
}
