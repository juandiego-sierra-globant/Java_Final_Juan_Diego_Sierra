import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // Start the program by displaying the menu
        showMenu();
    }

    public static void showMenu() {
        int option = 0;

        // Initialize Full Time teachers
        Teacher teacher1 = new FullTime("Ariana Grande", 6000, 8);
        Teacher teacher2 = new FullTime("Taylor Swift", 5500, 4);

        // Initialize Part Time teachers
        Teacher teacher3 = new PartTime("Beyoncé", 25, 15);
        Teacher teacher4 = new PartTime("Ed Sheeran", 30, 20);

        // Initialize students
        Student student1 = new Student("Emma Watson", 10, 21);
        Student student2 = new Student("Tom Holland", 20, 22);
        Student student3 = new Student("Lily Collins", 30, 23);
        Student student4 = new Student("Timothée Chalamet", 40, 19);
        Student student5 = new Student("Zendaya", 50, 20);
        Student student6 = new Student("Miley Cyrus", 60, 24);
        int lastID = 60;

        // Initialize arrays of students for each class
        ArrayList<Student> arrayClass1 = new ArrayList<>();
        ArrayList<Student> arrayClass2 = new ArrayList<>();
        ArrayList<Student> arrayClass3 = new ArrayList<>();
        ArrayList<Student> arrayClass4 = new ArrayList<>();

        // Initialize overall student array
        ArrayList<Student> totalStudents = new ArrayList<>();
        totalStudents.add(student1);
        totalStudents.add(student2);
        totalStudents.add(student3);
        totalStudents.add(student4);

        // Initialize overall teacher array
        ArrayList<Teacher> totalTeachers = new ArrayList<>();
        totalTeachers.add(teacher1);
        totalTeachers.add(teacher2);
        totalTeachers.add(teacher3);
        totalTeachers.add(teacher4);

        // Students enrolled in each class
        arrayClass1.add(student1);
        arrayClass1.add(student2);
        arrayClass2.add(student3);
        arrayClass2.add(student4);
        arrayClass3.add(student1);
        arrayClass3.add(student3);
        arrayClass4.add(student2);
        arrayClass4.add(student4);

        // Initialize subjects and subject list
        Subject class1 = new Subject("Math Class", teacher1.getName(), arrayClass1,"A1");
        Subject class2 = new Subject("Literature Class", teacher2.getName(), arrayClass2, "B2");
        Subject class3 = new Subject("Physics Class", teacher3.getName(), arrayClass3, "C3");
        Subject class4 = new Subject("History Class", teacher4.getName(), arrayClass4, "D4");

        ArrayList<Subject> classList = new ArrayList<>();
        classList.add(class1);
        classList.add(class2);
        classList.add(class3);
        classList.add(class4);

        do {
            // Display the main menu
            System.out.println("Menu:");
            System.out.println("1. Print all the professors with their data");
            System.out.println("2. Print all the classes");
            System.out.println("3. Create a new student and add it to an existing class");
            System.out.println("4. Create a new class and add an existing teacher and students");
            System.out.println("5. List all the classes for a given student (search by id)");
            System.out.println("6. Exit");
            Scanner sc = new Scanner(System.in);
            option = sc.nextInt();

            switch (option) {
                case 1:
                    // Display teacher information
                    teacher1.displayInfo();
                    teacher2.displayInfo();
                    teacher3.displayInfo();
                    teacher4.displayInfo();
                    break;
                case 2:
                    // Display class information
                    int subjectName = 1;
                    for (Subject subject : classList) {
                        System.out.print("Class "+subjectName +"-> ");
                        subject.getSubjectName();
                        subjectName = subjectName +1;
                    }

                    System.out.println("Select a class to print the class data:");
                    Scanner ss = new Scanner(System.in);
                    int option2= ss.nextInt();
                    option2 = option2 - 1;
                    classList.get(option2).printData();
                    break; // a
                case 3:
                    // Add a new student to an existing class
                    int subjectName2 = 1;
                    System.out.println("Type name of the student");
                    Scanner st = new Scanner(System.in);
                    String newStudent = st.nextLine();
                    lastID = lastID + 10;
                    int newID = lastID;
                    System.out.println("Type age of the student");
                    int newAge = st.nextInt();

                    // Display class options
                    System.out.println("Which class is the student going to be added:");
                    for (Subject subject : classList) {
                        System.out.print("Class "+ subjectName2 +"-> ");
                        subject.getSubjectName();
                        subjectName2 = subjectName2 +1;
                    }

                    // Add student and update lists
                    int newClass = st.nextInt();
                    newClass = newClass -1 ;
                    Student newStudents = new Student(newStudent, newID, newAge);
                    totalStudents.add(newStudents);
                    classList.get(newClass).getStudents().add(newStudents);
                    System.out.println("Student added succesfully.");
                    System.out.println("Total students: " + Student.getTotalStudents());
                    break;

                case 4:
                    // Create a new class and add teacher and students
                    System.out.println("Type name of the subject:");
                    Scanner sb = new Scanner(System.in);
                    String newSubject = sb.nextLine();
                    System.out.println("Type classroom:");
                    String newClassroom = sb.nextLine();

                    // Display teacher options
                    System.out.print("1. ");
                    teacher1.displayInfo();
                    System.out.print("2. ");
                    teacher2.displayInfo();
                    System.out.print("3. ");
                    teacher3.displayInfo();
                    System.out.print("4. ");
                    teacher4.displayInfo();
                    System.out.println("Add an existing teacher:");
                    int newTeacher = sb.nextInt();
                    newTeacher--;
                    ArrayList<Student> arrayClassNew = new ArrayList<>();

                    // Add students to the new class

                    int Option = 1;
                    while(Option !=2) {
                        int numStudent = 1;
                        for (Student student : totalStudents) {
                            System.out.print("Student " + numStudent + "-> ");
                            student.displayInfo();
                            numStudent++;
                        }
                        System.out.println("Add students:");
                        int newStudentOption = sb.nextInt();
                        newStudentOption--;
                        Student finalOption = totalStudents.get(newStudentOption);
                        arrayClassNew.add(finalOption);
                        System.out.println("1. Continue adding students.");
                        System.out.println("2. Exit.");
                        Option = sb.nextInt();
                    }
                    Subject newFinalClass = new Subject(newSubject, totalTeachers.get(newTeacher).getName(), arrayClassNew, newClassroom);
                    classList.add(newFinalClass);
                    break;
                case 5:
                    System.out.println("Type ID of the student:");
                    Scanner sd = new Scanner(System.in);
                    int newIDs = sd.nextInt();
                    for (Student student : totalStudents) {
                        int whatID = student.getId();
                        if(whatID==newIDs){
                            for (Subject subject : classList) {
                                if (subject.getStudents().contains(student)) {
                                    System.out.println(subject.getClassName());
                                }
                            }
                        }
                    }

                    break;

                default:
                    System.out.println("Invalid option, try again.");
                    break;
            }
        } while(option !=6);
    }

}