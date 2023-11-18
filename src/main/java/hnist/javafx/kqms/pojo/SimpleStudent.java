package hnist.javafx.kqms.pojo;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class SimpleStudent {
    private final SimpleStringProperty no;
    private final SimpleStringProperty name;
    private final SimpleStringProperty sex;
    private final SimpleIntegerProperty age;
    private final SimpleStringProperty className;

    public SimpleStudent(String no, String name, String sex, int age , String className){
        this.no = new SimpleStringProperty(no);
        this.name = new SimpleStringProperty(name);
        this.sex = new SimpleStringProperty(sex);
        this.age = new SimpleIntegerProperty(age);
        this.className = new SimpleStringProperty(className);
    }

    public Student toStudent() {
        return new Student(no.get(), name.get(), sex.get(), age.get(), className.get());
    }

    public String getNo() {
        return no.get();
    }

    public SimpleStringProperty noProperty() {
        return no;
    }

    public void setNo(String no) {
        this.no.set(no);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getSex() {
        return sex.get();
    }

    public SimpleStringProperty sexProperty() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex.set(sex);
    }

    public int getAge() {
        return age.get();
    }

    public SimpleIntegerProperty ageProperty() {
        return age;
    }

    public void setAge(int age) {
        this.age.set(age);
    }

    public String getClassName() {
        return className.get();
    }

    public SimpleStringProperty classNameProperty() {
        return className;
    }

    public void setClassName(String className) {
        this.className.set(className);
    }
}
