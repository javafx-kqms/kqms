package pojo;

public class Kaoqin {
    private String absentData;//缺课日期
    private String absentClass;//第几节课
    private String absentCourse;//课程名称
    private String absentType;//缺课类型
    private String studentName;
    private int studentNo;

    public Kaoqin(String absentData, String absentClass, String absentCourse, String absentType, String studentName, int studentNo) {
        this.absentData = absentData;
        this.absentClass = absentClass;
        this.absentCourse = absentCourse;
        this.absentType = absentType;
        this.studentName = studentName;
        this.studentNo = studentNo;
    }

    public Kaoqin(){

    }


    public int getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(int studentNo) {
        this.studentNo = studentNo;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getAbsentData() {
        return absentData;
    }

    public void setAbsentData(String absentData) {
        this.absentData = absentData;
    }

    public String getAbsentClass() {
        return absentClass;
    }

    public void setAbsentClass(String absentClass) {
        this.absentClass = absentClass;
    }

    public String getAbsentCourse() {
        return absentCourse;
    }

    public void setAbsentCourse(String absentCourse) {
        this.absentCourse = absentCourse;
    }

    public String getAbsentType() {
        return absentType;
    }

    public void setAbsentType(String absentType) {
        this.absentType = absentType;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
