package hnist.javafx.kqms.bg.mapper;

import hnist.javafx.kqms.pojo.Student;

public interface StudentMapper {

    boolean getStudentIfExistByNo(String no);

    void addStudent(Student student);
}
