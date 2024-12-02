package CIE;

public class Student {
    String usn;
    String name;
    int sem;
    public Student(String usn, String name, int sem) {
        this.usn = usn;
        this.name = name;
        this.sem = sem;
    }
}

package CIE;

public class Internals {
    int[] internalMarks = new int[5]; 

    public Internals(int[] marks) {
        if (marks.length == 5) {
            this.internalMarks = marks;
        } else {
            System.out.println("Invalid marks array length.");
        }
    }


    public void displayInternalMarks() {
        System.out.println("Internal Marks: ");
        for (int i = 0; i < internalMarks.length; i++) {
            System.out.print(internalMarks[i] + " ");
        }
        System.out.println();
    }
}
package SEE;

import CIE.Student;
import CIE.Internals;

public class External extends Student {
    int[] externalMarks = new int[5]; 

    public External(String usn, String name, int sem, int[] externalMarks) {
        super(usn, name, sem); 
        if (externalMarks.length == 5) {
            this.externalMarks = externalMarks;
        } else {
            System.out.println("Invalid external marks array length.");
        }
    }


    public void displayExternalMarks() {
        System.out.println("External Marks: ");
        for (int i = 0; i < externalMarks.length; i++) {
            System.out.print(externalMarks[i] + " ");
        }
        System.out.println();
    }
}
import CIE.Internals;
import CIE.Student;
import SEE.External;

public class Main {
    public static void main(String[] args) {
     
        External student1 = new External("1BM19CS001", "Alice", 5, new int[]{85, 90, 80, 75, 88});
        Internals internals1 = new Internals(new int[]{40, 45, 50, 40, 48});

        External student2 = new External("1BM19CS002", "Bob", 5, new int[]{78, 84, 70, 68, 80});
        Internals internals2 = new Internals(new int[]{42, 43, 49, 46, 50});

        External student3 = new External("1BM19CS003", "Charlie", 5, new int[]{88, 85, 78, 90, 92});
        Internals internals3 = new Internals(new int[]{44, 48, 50, 47, 46});

        
        displayStudentMarks(student1, internals1);
        displayStudentMarks(student2, internals2);
        displayStudentMarks(student3, internals3);
    }

    public static void displayStudentMarks(External student, Internals internals) {
        System.out.println("Student USN: " + student.usn);
        System.out.println("Name: " + student.name);
        System.out.println("Semester: " + student.sem);


        internals.displayInternalMarks();
       
        student.displayExternalMarks();

        int totalInternal = 0;
        for (int mark : internals.internalMarks) {
            totalInternal += mark;
        }

        int totalExternal = 0;
        for (int mark : student.externalMarks) {
            totalExternal += mark;
        }

        System.out.println("Total Internal Marks: " + totalInternal);
        System.out.println("Total External Marks: " + totalExternal);
        System.out.println("Final Marks (Internal + External): " + (totalInternal + totalExternal));
        System.out.println();
    }
}
