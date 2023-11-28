package hnist.javafx.kqms.pojo;

import com.alibaba.excel.annotation.ExcelProperty;

public class Student {
    @ExcelProperty("学号")
    private String no;
    @ExcelProperty("姓名")
    private String name;
    @ExcelProperty("性别")
    private String sex;
    @ExcelProperty("年龄")
    private byte age;
    @ExcelProperty("班级")
    private String className;

    public Student(){}

    public Student(String no, String name, String sex, byte age , String className){
        this.no = no;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.className = className;
    }

    @Override
    public String toString() {
        return "学号：" + no +
                "   姓名：" +  name +
                "   性别：" + sex +
                "   年龄：" + age +
                "   班级：" + className;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
