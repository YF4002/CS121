public class Student1 {
    String name;
    String lastName;
    String major;
    double gpa;

    public Student1(String name, String lastName, String major, double gpa) {
        this.name = name;
        this.lastName = lastName;
        this.major = major;
        this.gpa = gpa;
    }

    void getStudentInfo(){
        System.out.printf("Name: %s\n" +
                "ID: %s\n"+
                "Major: %s\n "+
                "GPA: %.2f\n",
                name,lastName,major,gpa);

    }

}
