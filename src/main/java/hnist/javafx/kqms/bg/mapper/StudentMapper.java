package hnist.javafx.kqms.bg.mapper;

import hnist.javafx.kqms.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {

    boolean getStudentIfExistByNo(String no);

    void addStudent(Student student);

    List<Student> getStudentByNoAndName(@Param("no") String no, @Param("name") String name);
}
