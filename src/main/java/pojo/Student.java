package pojo;

public class Student {
    private int no;
    private String name;
    private String sex;
    private int age;
    private String className;

    public Student(int no,String name,String sex,int age ,String className){
        this.no = no;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.className = className;
    }

    public Student(){

    }
    public int getNo() {
        return no;
    }

    public void setNo(int no) {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
