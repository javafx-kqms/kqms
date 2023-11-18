package hnist.javafx.kqms.pojo;

import java.util.Date;

public class Kaoqin {
    private Date date;//缺课日期
    private String courseName;//课程名称
    private byte courseSection;//第几节课
    private String type;//缺课类型
    private String studentName;
    private String studentNo;

    public Kaoqin(){}

    public Kaoqin(Date date, String courseName, byte courseSection, String type, String studentName, String studentNo) {
        this.date = date;
        this.courseName = courseName;
        this.courseSection = courseSection;
        this.type = type;
        this.studentName = studentName;
        this.studentNo = studentNo;
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

    public byte getCourseSection() {
        return courseSection;
    }

    public void setCourseSection(byte courseSection) {
        this.courseSection = courseSection;
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
