public class Student {

    String name;
    double marks;

    // Constructor
    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    // Calculate grade based on marks
    public String getGrade() {

        if (marks >= 90) {
            return "A";
        } else if (marks >= 80) {
            return "B";
        } else if (marks >= 70) {
            return "C";
        } else if (marks >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
}