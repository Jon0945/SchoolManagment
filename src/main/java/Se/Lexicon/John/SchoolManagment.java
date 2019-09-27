package Se.Lexicon.John;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import Se.Lexicon.John.data_access.StudentDAOList;
import Se.Lexicon.John.data_access.CourseDAOList;

public class SchoolManagment {
    private static Scanner scanner = new Scanner(System.in);
    private StudentDAOList studentlist = new StudentDAOList();
    private CourseDAOList courselist = new CourseDAOList();
    private Student selectedStudent = null;
    private Course selectedCourse = null;

    public void menu() {
        studentlist.saveStudent(new Student("Ture Test","ture.test@gmail.com","Testvägen 42"));
        studentlist.saveStudent(new Student("Ture Vest","ture.vest@hotmale.com","Vestvägen 24"));
        courselist.saveCourse((new Course("Java Masterclass",LocalDate.parse("2019-08-19"),40)));
        courselist.saveCourse(new Course("C# for Dummies",LocalDate.parse("2019-10-23"),20));
        boolean keepLooping = true;
        while (keepLooping) {
            System.out.println("     __...--~~~~~-._   _.-~~~~~--...__");
            System.out.println("    //               `V'               \\\\ ");
            System.out.println("   //                 |                 \\\\ ");
            System.out.println("  //__...--~~~~~~-._  |  _.-~~~~~~--...__\\\\ ");
            System.out.println(" //__.....----~~~~._\\ | /_.~~~~----.....__\\\\");
            System.out.println("====================\\\\|//====================");
            System.out.println("                    `---`");
            System.out.println();
            System.out.println("---- School Manager v0.1b ----\n" +
                    "1: Student Management\n" +
                    "2: Course Management\n" +
                    "3: Quit Program\n");

            int selection = askUserForNumber("Select");

            switch(selection) {
                case 1:
                    studentManagement();
                    break;
                case 2:
                    courseManagement();
                    break;
                case 3:
                    keepLooping = false;
                    System.out.println("Bye Bye!");
                    break;
                default:
                    System.out.println("Incorrect selection!");
                    break;
            }
        }
    }

    public void studentManagement() {
        boolean looping = true;
        while (looping) {
            System.out.println("\n---- Student Management ----\n" +
                    "1: Create New Student\n" +
                    "2: Delete a Student\n" +
                    "3: Select a Student\n" +
                    "4: Search Student by Name\n" +
                    "5: Search Student by Email\n" +
                    "6: Search Student by StudentID\n" +
                    "7: List All Students\n" +
                    "8: Return to Main Menu\n");

            int selection = askUserForNumber("Selection");

            switch(selection) {
                case 1:
                    Student student = new Student(
                            askUserFor("Student name"),
                            askUserFor("Email"),
                            askUserFor("Address")
                    );
                    studentlist.saveStudent(student);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    String name = askUserFor("Name");
                    List<Student> nameresult = studentlist.findByName(name);
                    if(nameresult.isEmpty()) {
                        System.out.println("\nNo students found with that name!");
                    }
                    else {
                        nameresult.forEach(System.out::println);
                    }
                    break;
                case 5:
                    String email = askUserFor("Email");
                    Student emailresult = studentlist.findByEmail(email);
                    if(emailresult == null) {
                        System.out.println("\nNo students found with that email!");
                    }
                    else {
                        System.out.println(emailresult);
                    }
                    break;
                case 6:
                    int studentid = askUserForNumber("Student ID");
                    Student idresult = studentlist.findById(studentid);
                    if(idresult == null) {
                        System.out.println("\nNo students found with that ID!");
                    }
                    else {
                        System.out.println(idresult);
                    }
                    break;
                case 7:
                    studentlist.findAll().forEach(System.out::println);
                    break;
                case 8:
                    looping = false;
                    break;
                default:
                    System.out.println("Incorrect selection!");
                    break;
            }
        }
    }

    public void courseManagement() {
        boolean looping = true;
        while (looping) {
            System.out.println("---- Course Management ----\n" +
                    "1: Create New Course\n" +
                    "2: Remove Existing Course\n" +
                    "3: Select a Course\n" +
                    "4: Search Course by Name\n" +
                    "5: Search Course by Start Date\n" +
                    "6: Search Course by CourseID\n" +
                    "7: List All Courses\n" +
                    "8: Register Student for Course\n" +
                    "9: Remove Student from Course\n" +
                    "0: Return to Main Menu\n");

            int selection = askUserForNumber("Select");

            switch(selection) {
                case 1:
                    Course course = new Course(
                            askUserFor("Course name"),
                            askUserForDate("Course Start date"),
                            askUserForNumber("Course Length")
                    );
                    courselist.saveCourse(course);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    String name = askUserFor("Name");
                    List<Course> nameresult = courselist.findByName(name);
                    if(nameresult.isEmpty()) {
                        System.out.println("\nNo courses found with that name!");
                    }
                    else {
                        nameresult.forEach(System.out::println);
                    }
                    break;
                case 5:
                    LocalDate date = askUserForDate("Start Date");
                    List<Course> dateresult = courselist.findByDate(date);
                    if(dateresult.isEmpty()) {
                        System.out.println("\nNo courses found starting on that date!");
                    }
                    else {
                        dateresult.forEach(System.out::println);
                    }
                    break;
                case 6:
                    int courseid = askUserForNumber("Course ID");
                    Course idresult = courselist.findById(courseid);
                    if(idresult == null) {
                        System.out.println("\nNo courses found with that ID!");
                    }
                    else {
                        System.out.println(idresult);
                    }
                    break;
                case 7:
                    courselist.findAll().forEach(System.out::println);
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 0:
                    looping = false;
                    break;
                default:
                    System.out.println("Incorrect selection!");
                    break;
            }
        }
    }

    public String askUserFor(String name)
        {
            System.out.print("Please enter " + name + ": ");
            String inputFromUser = scanner.nextLine();

            return inputFromUser;
        }

        public int askUserForNumber(String name)
        {
            int number = Integer.parseInt(askUserFor(name));
            return number;
        }

        public LocalDate askUserForDate(String inputdate)
        {
            LocalDate date = LocalDate.parse(askUserFor(inputdate));
            return date;
        }
    }

