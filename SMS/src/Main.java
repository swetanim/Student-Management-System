
 import java.util.ArrayList;
 import java.util.Scanner;
 import java.io.File;
 import java.io.FileWriter;


public class Main {
    static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        saveToFile();
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose your option");
        int number = 0;
        do {
            displayMenu();
            try {
                number = sc.nextInt();
            } catch (Exception e) {

                System.out.println("Invalid Input. Please enter a number.");

                sc.nextLine();
                continue;
            }
            switch (number) {
                case 1:
                    Student s = new Student();

                    System.out.print("Enter ID: ");
                    s.setId(sc.nextInt());

                    sc.nextLine(); // consume newline

                    System.out.print("Enter Name: ");
                    s.setName(sc.nextLine());

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();

                    if (age <= 0) {
                        System.out.println("Invalid Age");
                        break;
                    }
                    s.setAge(age);

                    System.out.print("Enter Marks: ");
                    int marks = sc.nextInt();

                    if (marks < 0 || marks > 100) {
                        System.out.println("Marks should be between 0 and 100");
                        break;
                    }

                    s.setMarks(marks);
                    students.add(s);
                    saveToFile();

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
                case 3:

                    System.out.print("Enter Student ID to search: ");
                    int searchId = sc.nextInt();

                    boolean found = false;

                    for (Student student : students) {

                        if (student.getId() == searchId) {
                            System.out.println(student);
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Student not found");
                    }

                    break;
                case 4:

                    System.out.print("Enter Student ID to update: ");
                    int updateId = sc.nextInt();

                    boolean updated = false;

                    for (Student student : students) {

                        if (student.getId() == updateId) {

                            sc.nextLine();

                            System.out.print("Enter New Name: ");
                            student.setName(sc.nextLine());

                            System.out.print("Enter New Age: ");
                            student.setAge(sc.nextInt());

                            System.out.print("Enter New Marks: ");
                            student.setMarks(sc.nextInt());

                            saveToFile();
                            System.out.println("Student Updated Successfully");

                            updated = true;
                            break;
                        }
                    }

                    if (!updated) {
                        System.out.println("Student not found");
                    }

                    break;
                case 5:

                    System.out.print("Enter Student ID to delete: ");
                    int deleteId = sc.nextInt();

                    boolean deleted = false;

                    for (int i = 0; i < students.size(); i++) {

                        if (students.get(i).getId() == deleteId) {

                            students.remove(i);
                            saveToFile();

                            System.out.println("Student Deleted Successfully");

                            deleted = true;
                            break;
                        }
                    }

                    if (!deleted) {
                        System.out.println("Student not found");
                    }

                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid size number");
            }
        } while (number != 6);

    }

    public static void displayMenu() {

        System.out.println("Choose option 1: Add student");
        System.out.println("Choose option 2: View students");
        System.out.println("Choose option 3: Search student");
        System.out.println("Choose option 4: Update student");
        System.out.println("Choose option 5: Delete student");
        System.out.println("Choose option 6: Exit");
    }

    public static void saveToFile() {

        try {

            FileWriter writer = new FileWriter("Student_data.txt");

            for (Student student : students) {

                writer.write(
                        student.getId() + "," +
                                student.getName() + "," +
                                student.getAge() + "," +
                                student.getMarks() + "\n"
                );
            }

            writer.close();

        } catch (Exception e) {

            System.out.println("Error saving file");
        }
    }

    public static void loadFromFile() {

        try {

            File file = new File("Student_data.txt");

            if (!file.exists()) {
                return;
            }

            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNextLine()) {

                String line = fileScanner.nextLine();

                String[] data = line.split(",");

                Student s = new Student();

                s.setId(Integer.parseInt(data[0]));
                s.setName(data[1]);
                s.setAge(Integer.parseInt(data[2]));
                s.setMarks(Integer.parseInt(data[3]));

                students.add(s);
            }

            fileScanner.close();

        } catch (Exception e) {

            System.out.println("Error loading file");
        }
    }
}
