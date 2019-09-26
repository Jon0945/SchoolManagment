package Se.Lexicon.John;

import java.lang.reflect.Array;
import java.util.Scanner;
import Se.Lexicon.John.data_access.StudentDAOList;
import Se.Lexicon.John.data_access.CourseDAOList;

public class SchoolManagment {
    private static Scanner scanner = new Scanner(System.in);
    private StudentDAOList studentlist = new StudentDAOList();
    private CourseDAOList courselist = new CourseDAOList();
    private Student selectedStudent = null;
    private Course selectedCourse = null;

    protected void menu() {
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
                    "1: Student Managment\n" +
                    "2: Course Managment\n" +
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
            System.out.println("---- Student Managment ----\n" +
                    "1: Create New Student\n" +
                    "2: Search Student by Name\n" +
                    "3: Search Student by Email\n" +
                    "4: Search Student by StudentID\n" +
                    "5: List All Students\n" +
                    "6: Return to Main Menu\n");

            int selection = askUserForNumber("Select");

            switch(selection) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    System.out.println(studentlist.findAll());
                    break;
                case 6:
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
            System.out.println("---- Course Managment ----\n" +
                    "1: Create New Course\n" +
                    "2: Search Course by Name\n" +
                    "3: Search Course by Start Date\n" +
                    "4: Search Course by CourseID\n" +
                    "5: List All Courses\n" +
                    "6: Register Student for Course\n" +
                    "7: Remove Student from Course\n" +
                    "8: Return to Main Menu\n");

            int selection = askUserForNumber("Select");

            switch(selection) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    System.out.println(courselist.findAll());
                    break;
                case 6:
                    break;
                case 7:
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
    public void addStudent() {
        Student student = new Student(
                askUserFor("Student name"),
                askUserFor("Email"),
                askUserFor("Adress")
        );
        studentlist.saveStudent(student);
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
    }

