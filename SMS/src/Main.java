 import java.util.ArrayList;
 import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        System.out.println("Choose your option");
        int number = 0;
        do {
            System.out.println("Choose option 1: Add student");
            System.out.println("Choose option 2: view student");
            System.out.println("Choose option 3: exit");
            number = sc.nextInt();
            switch (number) {
                case 1:
                    Student s = new Student();

                    System.out.print("Enter ID: ");
                    s.setId(sc.nextInt());

                    System.out.print("Enter Name: ");
                    s.setName(sc.nextLine());

                    System.out.print("Enter Age: ");
                    s.setAge(sc.nextInt());

                    System.out.print("Enter Marks: ");
                    s.setMarks(sc.nextInt());

                    students.add(s);

                    System.out.println("Student Added Successfully");
                    break;
                case 2:
                    if (students.isEmpty()) {
                        System.out.println("No Students Found");
                    } else {
                        for (Student student : students) {
                            System.out.println(student);
                        }
                    }
                    break;
                default:
                    System.out.println("Invalid size number");
            }
        } while(number!=3);

    }
}

//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class Main {
//
//    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//        ArrayList<Student> students = new ArrayList<>();
//
//        int number;
//
//        do {
//            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
//            System.out.println("1. Create Student");
//            System.out.println("2. View Students");
//            System.out.println("3. Exit");
//
//            System.out.print("Choose option: ");
//            number = sc.nextInt();
//
//            switch (number) {
//
//                case 1:
//
//                    Student s = new Student();
//
//                    System.out.print("Enter ID: ");
//                    s.setId(sc.nextInt());
//
//                    sc.nextLine();
//
//                    System.out.print("Enter Name: ");
//                    s.setName(sc.nextLine());
//
//                    System.out.print("Enter Age: ");
//                    s.setAge(sc.nextInt());
//
//                    System.out.print("Enter Marks: ");
//                    s.setMarks(sc.nextInt());
//
//                    students.add(s);
//
//                    System.out.println("Student Added Successfully");
//                    break;
//
//                case 2:
//
//                    if (students.isEmpty()) {
//                        System.out.println("No Students Found");
//                    } else {
//                        for (Student student : students) {
//                            System.out.println(student);
//                        }
//                    }
//                    break;
//
//                case 3:
//                    System.out.println("Exiting...");
//                    break;
//
//                default:
//                    System.out.println("Invalid Option");
//            }
//
//        } while (number != 3);
//
//        sc.close();
//    }
//}