
import java.util.Scanner;


class WrongAge extends Exception {
  
    public WrongAge() {
        super("Age Error");
    }


    public WrongAge(String message) {
        super(message);
    }
}


class Father {
    int fatherAge;

   
    public Father() throws WrongAge {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter father's age: ");
        fatherAge = s.nextInt();

       
        if (fatherAge < 0) {
            throw new WrongAge("Age cannot be negative");
        }
    }


    public void displayFather() {
        System.out.println("Father's age: " + fatherAge);
    }
}


class Son extends Father {
    int sonAge;

  
    public Son() throws WrongAge {
       
        super();

        Scanner s = new Scanner(System.in);
        System.out.print("Enter son's age: ");
        sonAge = s.nextInt();

      
        if (sonAge >= fatherAge) {
            throw new WrongAge("Son's age cannot be greater than or equal to father's age");
        } else if (sonAge < 0) {
            throw new WrongAge("Age cannot be negative");
        }
    }

  
    public void displaySon() {
        System.out.println("Son's age: " + sonAge);
    }
}

public class Main1 {
    public static void main(String[] args) {
        try {
         
            Son son = new Son();
            
      
            son.displaySon();
            son.displayFather(); 
            
        } catch (WrongAge e) {
            // Print the exception name and message
            System.out.println("Exception: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }
}
