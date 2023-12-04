public class Student {
    private String name;
    private String regNum;
    private String course;
    private String gpa;

    public Student(String name, String regNum, String course, String gpa) {
        this.name = name;
        this.regNum = regNum;
        this.course = course;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public String getRegNum() {
        return regNum;
    }

    public String getCourse() {
        return course;
    }

    public String getGpa() {
        return gpa;
    }
}
