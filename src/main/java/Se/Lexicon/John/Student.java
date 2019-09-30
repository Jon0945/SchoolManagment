package Se.Lexicon.John;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Student {
    //Static field
    private static int studentCounter = 1;

    //Field
    private int id;
    private String name;
    private String email;
    private String adress;
    private List<Course> courses = new ArrayList<>();

    public int getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getAdress() { return adress; }
    public void setAdress(String adress) { this.adress = adress; }
    public List<Course> getCourses() { return courses; }
    public void setCourses(Course course) { this.courses.add(course); }

    public Student(String name, String email, String adress) {
        id = studentCounter++;
        this.name = name;
        this.email = email;
        this.adress = adress;
    }

    @Override
    public String toString() {
        return "\nStudent ID: " + id +
                "\nName: " + name +
                "\nEmail: " + email +
                "\nAdress: " + adress;
    }
}
