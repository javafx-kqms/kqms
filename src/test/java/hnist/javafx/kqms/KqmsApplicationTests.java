package hnist.javafx.kqms;


import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import hnist.javafx.kqms.bg.controller.StudentController;
import hnist.javafx.kqms.pojo.Student;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class KqmsApplicationTests {

    @Test
    public void test1() {
        List<Student> data = StudentController.getStudent(null, null);
        EasyExcel.write("E:\\java\\学生信息.xlsx", Student.class).sheet().doWrite(data);
    }

    @Test
    public void test2() {
        EasyExcel.read("E:\\java\\学生信息.xlsx", Student.class, new ReadListener<Student>() {
            private final List<Student> data = new ArrayList<>();

            @Override
            public void invoke(Student student, AnalysisContext analysisContext) {
                data.add(student);
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {
                StudentController.addStudentByList(data);
            }
        }).sheet().doRead();
    }
}
