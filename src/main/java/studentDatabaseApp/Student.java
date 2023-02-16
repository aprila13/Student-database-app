package studentDatabaseApp;

import java.util.Scanner;

public class Student {
    private String firstName;
    private String lastName;
    private int gradeYear;
    private String courses = null;
    private String studentID;
    private int tuitionBalance = 0;
    private static int costOfCourse = 600;
    private static int id = 1000;

    //constructor: prompt user to enter student's name/year
    public  Student() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter student first name: ");
        this.firstName = in.nextLine();

        System.out.println("Enter student last name: ");
        this.lastName = in.nextLine();

        System.out.println("1 - Freshmen\n2 - Sophomore\n3 - Junior\n4 - Senior\nEnter student grade year: ");
        this.gradeYear = in.nextInt();
        setStudentID();

        System.out.println(firstName + " " + lastName + " " + gradeYear + " " + studentID);
    }

    //generate ID
    private void setStudentID() {
        id++;
        this.studentID = gradeYear + "" + id;
    }
    //enroll in courses
    public void enroll() {
        do {
        System.out.println("Enter course to enroll (Q to quit): ");
        Scanner in = new Scanner(System.in);
        String course = in.nextLine();
        if(!course.equalsIgnoreCase("Q")) {
            courses = courses + "\n" + course;
            tuitionBalance = tuitionBalance + costOfCourse;
        }
        else {break;}
        } while (1 != 0);
        System.out.println("ENROLLED IN: " + courses);
    }
    //view balance
    public void viewBalance() {
        System.out.println("Your balance is $" + tuitionBalance);
    }

    //pay tuition
    public void payTuition() {
        viewBalance();
        System.out.println("Enter your payment: $");
        Scanner in = new Scanner(System.in);
        int payment = in.nextInt();
        tuitionBalance = tuitionBalance - payment;
        System.out.println("Thank you for your payment of $" + payment);
        viewBalance();
    }
    //show status
    public String showInfo() {
        return "Name: " + firstName + " " + lastName +
                "\nGrade Level: " + gradeYear +
                "\nStudent ID: " + studentID +
                "\nCourses Enrolled:" + courses +
                "\nBalance: $" + tuitionBalance;
    }
}
