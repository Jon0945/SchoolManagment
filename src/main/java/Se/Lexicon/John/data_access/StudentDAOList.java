package Se.Lexicon.John.data_access;

import Se.Lexicon.John.Student;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOList implements StudentDAO {
    private static List<Student> students;
    public StudentDAOList() {
        students = new ArrayList<Student>();
    }

    @Override
    public Student saveStudent(Student student) {
        students.add(student);
        return student;
    }

    @Override
    public Student findByEmail(String email) {
        for (Student s : students) {
            if (email.contains(s.getEmail())) {
                return s;
            }
        }
        return null;
    }

    @Override
    public List<Student> findByName(String name) {
        List<Student> studentresult = new ArrayList<>();
        students.stream().filter(student -> student.getName().contains(name)).forEach(studentresult::add);
        return studentresult;
    }

    @Override
    public Student findById(int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public boolean deleteStudent(Student student) {
        for (Student s : students) {
            if (s == student) {
                students.remove(student);
                return true;
            }
        }
        return false;

    }
}

