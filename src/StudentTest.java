public class StudentTest {
    public static void main(String[] args) {
        Student students = new Student("Yahaya", "Fofana","Computer Science",19,3.73);

        System.out.println(students.getName());
        students.setName("Yahaya");
        System.out.println(students.getLastName());
        students.setLastName("Fofana");
        System.out.println(students.getMajor());
        students.setMajor("Computer Science");
        System.out.println(students.getAge());
        students.setAge(19);
        System.out.println(students.getGpa());
        students.setGpa(3.73);
    }
}
