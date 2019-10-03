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
        studentlist.saveStudent(new Student("Ture Test", "ture.test@gmail.com", "Testvägen 42"));
        studentlist.saveStudent(new Student("Ture Vest", "ture.vest@hotmale.com", "Vestvägen 24"));
        courselist.saveCourse((new Course("Java Masterclass", LocalDate.parse("2019-08-19"), 40)));
        courselist.saveCourse(new Course("C# for Dummies", LocalDate.parse("2019-10-23"), 20));
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
            try {
            int selection = askUserForNumber("Select");
                switch (selection) {
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
            } catch (Exception NumberFormatException) {
                System.out.println("Error! Only input numbers");
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

            try {
                int selection = askUserForNumber("Selection");

                switch (selection) {
                    case 1:
                        Student student = new Student(
                                askUserFor("Student name"),
                                askUserFor("Email"),
                                askUserFor("Address")
                        );
                        studentlist.saveStudent(student);
                        break;
                    case 2:
                        try {
                            deleteStudent(selectedStudent);
                            break;
                        } catch (Exception NullPointerException) {
                            break;
                        }
                    case 3:
                        selectedStudent = selectStudent(studentlist.findAll());
                        try {
                            System.out.println("Student selected: \n\n" + "Student ID: " + selectedStudent.getId() +
                                    "\n" + "Student Name: " + selectedStudent.getName());
                            break;
                        } catch (Exception NullPointerException) {
                            break;
                        }
                    case 4:
                        String name = askUserFor("Name");
                        List<Student> nameresult = studentlist.findByName(name);
                        if (nameresult.isEmpty()) {
                            System.out.println("\nNo students found with that name!");
                        } else {
                            nameresult.forEach(System.out::println);
                        }
                        break;
                    case 5:
                        String email = askUserFor("Email");
                        Student emailresult = studentlist.findByEmail(email);
                        if (emailresult == null) {
                            System.out.println("\nNo students found with that email!");
                        } else {
                            System.out.println(emailresult);
                        }
                        break;
                    case 6:
                        int studentid = askUserForNumber("Student ID");
                        Student idresult = studentlist.findById(studentid);
                        if (idresult == null) {
                            System.out.println("\nNo students found with that ID!");
                        } else {
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
            }catch (Exception NumberFormatException) {
                System.out.println("Error! Only input numbers!");
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
            try {
                int selection = askUserForNumber("Select");

                switch (selection) {
                    case 1:
                        Course course = new Course(
                                askUserFor("Course name"),
                                askUserForDate("Course Start date"),
                                askUserForNumber("Course Length")
                        );
                        courselist.saveCourse(course);
                        break;
                    case 2:
                        try {
                            deleteCourse(selectedCourse);
                            break;
                        } catch (Exception NullPointerException) {
                            break;
                        }
                    case 3:
                        selectedCourse = selectCourse(courselist.findAll());
                        try {
                            System.out.println("Course selected: \n\n" + "Course ID: " + selectedCourse.getId() +
                                    "\n" + "Course Name: " + selectedCourse.getCourseName());
                            break;
                        } catch (Exception NullPointerException) {
                            break;
                        }
                    case 4:
                        String name = askUserFor("Name");
                        List<Course> nameresult = courselist.findByName(name);
                        if (nameresult.isEmpty()) {
                            System.out.println("\nNo courses found with that name!");
                        } else {
                            nameresult.forEach(System.out::println);
                        }
                        break;
                    case 5:
                        LocalDate date = askUserForDate("Start Date");
                        List<Course> dateresult = courselist.findByDate(date);
                        if (dateresult.isEmpty()) {
                            System.out.println("\nNo courses found starting on that date!");
                        } else {
                            dateresult.forEach(System.out::println);
                        }
                        break;
                    case 6:
                        int courseid = askUserForNumber("Course ID");
                        Course idresult = courselist.findById(courseid);
                        if (idresult == null) {
                            System.out.println("\nNo courses found with that ID!");
                        } else {
                            System.out.println(idresult);
                        }
                        break;
                    case 7:
                        courselist.findAll().forEach(System.out::println);
                        break;
                    case 8:
                        try {
                            registerStudent(selectedStudent, selectedCourse);
                            break;
                        } catch (Exception NullPointException) {
                            break;
                        }
                    case 9:
                        try {
                            unregisterStudent(selectedStudent, selectedCourse);
                            break;
                        } catch (Exception NullPointException) {
                            break;
                        }
                    case 0:
                        looping = false;
                        break;
                    default:
                        System.out.println("Incorrect selection!");
                        break;
                }
            }catch (Exception NumberFormatException) {
                System.out.println("Error! Only input numbers");
            }
        }
    }

    public void deleteStudent(Student student) {
        if (student == null) {
            System.out.println("No student selected. Run the selection function first");
        }
        boolean idiotProtection = true;
        while (idiotProtection) {
            System.out.println("\nAre you sure you want to delete student " + student.getName() + " from the system? (Y/N):");
            switch (scanner.nextLine().charAt(0)) {
                case 'Y':
                    studentlist.deleteStudent(student);
                    System.out.println("\n\nStudent deleted!");
                    selectedStudent = null;
                    idiotProtection = false;
                    break;
                case 'N':
                    idiotProtection = false;
                    break;
                default:
                    System.out.println("Not a valid answer! Answer Y or N only");
            }
        }
    }

    public Student selectStudent(List<Student> students) {
        try {
            if (students.isEmpty()) {
                System.out.println("No students enrolled! Add some first");
            } else {
                int indexOfStudent = -1;
                students.forEach(System.out::println);
                indexOfStudent = askUserForNumber("Student ID");
                for (Student s : students) {
                    if (indexOfStudent == s.getId()) {
                        return s;
                    }
                }
                System.out.println("Invalid Student ID!");
                return null;
            }
            return null;
        } catch (Exception NullPointerException) {
            return null;
        }
    }

    public void deleteCourse(Course course) {
        if (course == null) {
            System.out.println("No coourse selected. Run the selection function first");
        }
        boolean idiotProtection = true;
        while (idiotProtection) {
            System.out.println("\nAre you sure you want to delete the course " + course.getCourseName() + " from the system? (Y/N):");
            switch (scanner.nextLine().charAt(0)) {
                case 'Y':
                    courselist.removeCourse(course);
                    System.out.println("\n\nCourse deleted!");
                    selectedCourse = null;
                    idiotProtection = false;
                    break;
                case 'N':
                    idiotProtection = false;
                    break;
                default:
                    System.out.println("Not a valid answer! Answer Y or N only");
            }
        }
    }

    public Course selectCourse(List<Course> courses) {
        try {
            if (courses.isEmpty()) {
                System.out.println("No courses found! Add some first");
            } else {
                int indexOfCourse = -1;
                courses.forEach(System.out::println);
                indexOfCourse = askUserForNumber("Course ID");
                for (Course c : courses) {
                    if (indexOfCourse == c.getId()) {
                        return c;
                    }
                }
                System.out.println("Invalid Course ID!");
                return null;
            }
            return null;
        } catch (Exception NullPointerException) {
            return null;
        }
    }

    public void registerStudent(Student student, Course course) {
        if (student == null) {
            System.out.println("No student selected. Run the student selection function first");
        }
        else if (course == null) {
                System.out.println("No course selected. Run the course selection function first");
        }
        boolean idiotProtection = true;
        while (idiotProtection) {
            if(student.getCourses().contains(course) && course.getStudents().contains(student)){
                System.out.println("That student is already registered to that course!");
                idiotProtection = false;
            }
            else {
                System.out.println("\nAre you sure you want to register " + student.getName() + " to the " + course.getCourseName() + " course (Y/N):");
                switch (scanner.nextLine().charAt(0)) {
                    case 'Y':
                        selectedCourse.register(student);
                        System.out.println("\n\nStudent " + student.getName() + " registered to " + course.getCourseName());
                        selectedStudent = null;
                        selectedCourse = null;
                        idiotProtection = false;
                        break;
                    case 'N':
                        idiotProtection = false;
                        break;
                    default:
                        System.out.println("Not a valid answer! Answer Y or N only");
                }
            }

        }
    }

    public void unregisterStudent(Student student, Course course) {
    if (student == null) {
        System.out.println("No student selected. Run the student selection function first");
    }
        else if (course == null) {
        System.out.println("No course selected. Run the course selection function first");
    }
    boolean idiotProtection = true;
        while (idiotProtection) {
            if(!course.getStudents().contains(course) && !student.getCourses().contains(student)){
                System.out.println("That student is not registered to that course!");
                idiotProtection = false;
            }
            else {
                System.out.println("\nAre you sure you want to unregister " + student.getName() + " from the " + course.getCourseName() + " course (Y/N):");
                switch (scanner.nextLine().charAt(0)) {
                    case 'Y':
                        selectedCourse.unregister(student);
                        System.out.println("\n\nStudent " + student.getName() + " unregistered from " + course.getCourseName());
                        selectedStudent = null;
                        selectedCourse = null;
                        idiotProtection = false;
                        break;
                    case 'N':
                        idiotProtection = false;
                        break;
                    default:
                        System.out.println("Not a valid answer! Answer Y or N only");
                }
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