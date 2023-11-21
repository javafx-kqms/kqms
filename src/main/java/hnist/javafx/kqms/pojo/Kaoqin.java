package hnist.javafx.kqms.pojo;

import com.alibaba.excel.annotation.ExcelProperty;

import java.util.Date;

public class Kaoqin {
    @ExcelProperty("缺课日期")
    private Date date;//缺课日期
    @ExcelProperty("课程名称")
    private String courseName;//课程名称
    @ExcelProperty("第几节课")
    private byte section;//第几节课
    @ExcelProperty("缺课类型")
    private String type;//缺课类型
    @ExcelProperty("学生姓名")
    private String studentName;
    @ExcelProperty("学号")
    private String studentNo;

    public Kaoqin(){}

    public Kaoqin(Date date, String courseName, byte section, String type, String studentName, String studentNo) {
        this.date = date;
        this.courseName = courseName;
        this.section = section;
        this.type = type;
        this.studentName = studentName;
        this.studentNo = studentNo;
    }

    @Override
    public String toString() {
        return "学号：" + studentNo +
                "   姓名：" +  studentName +
                "   缺课日期：" +date +
                "   课程名称：'" + courseName +
                "   缺课节次：" + section +
                "   缺课类型" + type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public byte getSection() {
        return section;
    }

    public void setSection(byte section) {
        this.section = section;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }
}
