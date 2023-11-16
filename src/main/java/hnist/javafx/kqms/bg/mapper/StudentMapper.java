package hnist.javafx.kqms.bg.mapper;

import hnist.javafx.kqms.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StudentMapper {

    boolean getStudentIfExistByNo(String no);

    void addStudent(Student student);
}
