package hnist.javafx.kqms.bg.controller;

import hnist.javafx.kqms.bg.mapper.StudentMapper;
import hnist.javafx.kqms.pojo.Student;

public class StudentController {

    StudentMapper studentMapper = MapperGenerator.getStudentMapper();

    public boolean getStudentIfExistByNo(String no) {
        System.out.println(no);
        return studentMapper.getStudentIfExistByNo(no);
    }

    public void addStudent(Student student) {
        studentMapper.addStudent(student);
    }
}
