package Se.Lexicon.John.data_access;

import Se.Lexicon.John.Course;

import java.time.LocalDate;
import java.util.List;

public interface CourseDAO {
    Course saveCourse(Course course);
    Course findById(int id);
    List<Course>findByName(String name);
    List<Course>findByDate(LocalDate date);
    List<Course>findAll();
    boolean removeCourse(Course course);
}
