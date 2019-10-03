package Se.Lexicon.John;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Course {
    //Static Field
    private static int courseCounter = 1;

    //Fields
    private int id;
    private String courseName;
    private LocalDate startDate;
    private int weekDuration;
    private List<Student> students = new ArrayList<>();

    public Course(String courseName, LocalDate startDate, int weekDuration) {
        id = courseCounter++;
        this.courseName = courseName;
        this.startDate = startDate;
        this.weekDuration = weekDuration;
    }

    public int getId() { return id; }
    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }
    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
    public int getWeekDuration() { return weekDuration; }
    public void setWeekDuration(int weekDuration) { this.weekDuration = weekDuration; }
    public List<Student> getStudents() { return students; }
    public void setStudents(Student student) { this.students.add(student); }

    public void register (Student student) {
        this.students.add(student);
        student.setCourses(this);
    }

    public void unregister (Student student) {
        this.students.remove(student);
        student.getCourses().remove(this);
    }

    @Override
    public String toString() {
        return "\nCourse Id: " + id +
                "\nCourse Name: " + courseName +
                "\nStart Date: " + startDate +
                "\nDuration: " + weekDuration + " weeks";
    }
}
