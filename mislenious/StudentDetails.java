import java.util.Scanner;

class Student
{
    int roll;
    String name;
    double cgpa;

    Student(int roll, String name, double cgpa)
    {
        this.roll = roll;
        this.name = name;
        this.cgpa = cgpa;
    }
}

public class StudentDetails
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int n = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        Student[] students = new Student[n];

        // Input student details
        for (int i = 0; i < n; i++)
        {
            System.out.println("Enter details for student " + (i + 1) + ":");

            System.out.print("Roll Number: ");
            int roll = sc.nextInt();

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("CGPA: ");
            double cgpa = sc.nextDouble();

            students[i] = new Student(roll, name, cgpa);
        }

        System.out.println("\nStudent Details:");
        for (Student student : students)
            System.out.println("Roll Number: " + student.roll + ", Name: " + student.name + ", CGPA: " + student.cgpa);


        double minCgpa = students[0].cgpa;
        String lowestCgpaName = students[0].name;

        for (int i = 1; i < n; i++)
        {
            if (students[i].cgpa < minCgpa)
            {
                minCgpa = students[i].cgpa;
                lowestCgpaName = students[i].name;
            }
        }

        System.out.println("\nStudent with the lowest CGPA:");
        System.out.println("Name: " + lowestCgpaName + ", CGPA: " + minCgpa);
    }
}
