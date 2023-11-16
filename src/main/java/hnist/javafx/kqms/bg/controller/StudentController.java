package hnist.javafx.kqms.bg.controller;

import hnist.javafx.kqms.bg.mapper.StudentMapper;
import hnist.javafx.kqms.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class StudentController {

    @Autowired
    StudentMapper studentMapper;

    public boolean getStudentIfExistByNo(String no) {
        return studentMapper.getStudentIfExistByNo(no);
    }

    public void addStudent(Student student) {
        studentMapper.addStudent(student);
    }
}
