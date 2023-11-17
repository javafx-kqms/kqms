package hnist.javafx.kqms.bg.mapper;

import hnist.javafx.kqms.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {
    void addStudent(Student student);

    void deleteStudent(String no);

    void modifyStudent(Student student);

    boolean getStudentIfExistByNo(String no);

    List<Student> getStudentByNoAndName(@Param("no") String no, @Param("name") String name);
}
