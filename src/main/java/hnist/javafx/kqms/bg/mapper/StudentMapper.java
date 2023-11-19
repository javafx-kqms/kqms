package hnist.javafx.kqms.bg.mapper;

import hnist.javafx.kqms.pojo.Student;

import java.util.List;

public interface StudentMapper {
    void addStudent(Student student);

    void deleteStudent(String no);

    void modifyStudent(Student student);

    boolean getStudentIfExistByNo(String no);

    List<Student> getStudentByNoAndName(String no, String name);
}
