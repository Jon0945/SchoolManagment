package Se.Lexicon.John.data_access;

import Se.Lexicon.John.Course;
import Se.Lexicon.John.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CourseDAOList implements CourseDAO {
    private static List<Course> courses;
    public CourseDAOList() {
        courses = new ArrayList<Course>();
    }

    @Override
    public Course saveCourse(Course course) {
        courses.add(course);
        return course;
    }

    @Override
    public Course findById(int id) {
        for (Course c : courses) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    @Override
    public List<Course> findByName(String name) {
        List<Course> coursesresult = new ArrayList<>();
        courses.stream().filter(course -> course.getCourseName().contains(name)).forEach(coursesresult::add);
        return coursesresult;
    }

    @Override
    public List<Course> findByDate(LocalDate date) {
        List<Course> courseresult = new ArrayList<>();
        courses.stream().filter(course -> course.getStartDate().equals(date)).forEach(courseresult::add);
        return courseresult;
    }

    @Override
    public List<Course> findAll() {
        return courses;
    }

    @Override
    public boolean removeCourse(Course course) {
        for (Course c : courses) {
            if (c == course) {
                courses.remove(course);
                return true;
            }
        }
        return false;

    }
}
