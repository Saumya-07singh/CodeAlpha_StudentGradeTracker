import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Student> students = new ArrayList<>();

        System.out.println("=================================");
        System.out.println("      STUDENT GRADE TRACKER");
        System.out.println("=================================");

        // Get number of students
        System.out.print("Enter number of students: ");
        int numberOfStudents = sc.nextInt();
        sc.nextLine();

        // Take student details
        for (int i = 0; i < numberOfStudents; i++) {

            System.out.println("\nEnter details for Student " + (i + 1));

            System.out.print("Enter student name: ");
            String name = sc.nextLine();

            System.out.print("Enter marks (0-100): ");
            double marks = sc.nextDouble();
            sc.nextLine();

            // Validate marks
            while (marks < 0 || marks > 100) {

                System.out.println(
                    "Invalid marks! Please enter marks between 0 and 100."
                );

                System.out.print("Enter marks again: ");
                marks = sc.nextDouble();
                sc.nextLine();
            }

            // Create Student object
            Student student = new Student(name, marks);

            // Add student to ArrayList
            students.add(student);
        }

        // Variables for calculations
        double totalMarks = 0;

        double highestMarks = students.get(0).marks;
        double lowestMarks = students.get(0).marks;

        String highestStudent = students.get(0).name;
        String lowestStudent = students.get(0).name;

        // Calculate total, highest and lowest
        for (Student student : students) {

            totalMarks = totalMarks + student.marks;

            if (student.marks > highestMarks) {
                highestMarks = student.marks;
                highestStudent = student.name;
            }

            if (student.marks < lowestMarks) {
                lowestMarks = student.marks;
                lowestStudent = student.name;
            }
        }

        // Calculate average
        double averageMarks = totalMarks / students.size();

        // Display report
        System.out.println("\n=================================");
        System.out.println("       STUDENT GRADE REPORT");
        System.out.println("=================================");

        for (Student student : students) {

            System.out.println("Name   : " + student.name);
            System.out.println("Marks  : " + student.marks);
            System.out.println("Grade  : " + student.getGrade());
            System.out.println("---------------------------------");
        }

        // Display summary
        System.out.println("Average Marks : " + averageMarks);
        System.out.println("Highest Marks : " + highestMarks);
        System.out.println("Highest Scorer: " + highestStudent);
        System.out.println("Lowest Marks  : " + lowestMarks);
        System.out.println("Lowest Scorer : " + lowestStudent);

        System.out.println("=================================");

        sc.close();
    }
}