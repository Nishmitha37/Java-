import java.util.Scanner;

class StudDetails {
    int[] marks = new int[3];
    String usn, name;
    Scanner sc = new Scanner(System.in);

    void getDetails() {
        System.out.print("Enter USN: ");
        usn = sc.next();
        System.out.print("Enter Name: ");
        name = sc.next();

        System.out.println("Enter marks for 3 subjects:");
        for (int i = 0; i < 3; i++) {
            marks[i] = sc.nextInt();
        }
    }

    void display() {
        System.out.println("USN: " + usn);
        System.out.println("Name: " + name);
        for (int i = 0; i < 3; i++) {
            System.out.println("Marks of subject " + (i + 1) + ": " + marks[i]);
        }
        System.out.printf("SGPA: %.2f%n", calculateSGPA());
    }

    double calculateSGPA() {
        double totalPoints = 0;
        for (int mark : marks) {
            totalPoints += getGradePoint(mark);
        }
        return totalPoints / marks.length; // Average of grade points
    }

    private double getGradePoint(int mark) {
        if (mark >= 90) return 10;
        else if (mark >= 80) return 9;
        else if (mark >= 70) return 8;
        else if (mark >= 60) return 7;
        else if (mark >= 50) return 6;
        else if (mark >= 40) return 5;
        else return 0; // Below 40
    }
}

public class Student {
    public static void main(String[] args) {
        StudDetails[] s1 = new StudDetails[3];

        for (int j = 0; j < 3; j++) {
            s1[j] = new StudDetails();
            System.out.println("Enter details for student " + (j + 1) + ":");
            s1[j].getDetails();
        }

        System.out.println("\nStudent Details:");
        for (StudDetails student : s1) {
            student.display();
        }
    }
}
