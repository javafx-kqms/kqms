package hnist.javafx.kqms.bg.mapper;

import hnist.javafx.kqms.pojo.Student;

import java.util.List;

public interface StudentMapper {
    void addStudent(Student student);

    void deleteStudent(String no);

    void modifyStudent(Student student);

    boolean getStudentIfExist(String no);

    List<Student> getStudent(String no, String name);
}
