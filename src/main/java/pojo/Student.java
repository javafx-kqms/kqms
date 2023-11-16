package pojo;

public class Student {
    private String no;
    private String name;
    private String sex;
    private short age;
    private String className;

    public Student(String no, String name, String sex, short age , String className){
        this.no = no;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.className = className;
    }

    public Student(){

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

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
