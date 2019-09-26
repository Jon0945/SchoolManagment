package Se.Lexicon.John;


import static org.junit.Assert.*;
import Se.Lexicon.John.data_access.StudentDAOList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOListTest {
    private Student testStudent;
    private List<Student> testStudentList = new ArrayList<>();
    private StudentDAOList testDAOlist;
    private final String testName = "Ture Test";
    private final String testEmail = "ture.test@gmail.com";
    private final String testAdress = "Testvägen 42";

    @Before
    public void createStudent() {
        testStudent = new Student(testName,testEmail,testAdress);
        testStudentList.add(testStudent);
        testDAOlist = new StudentDAOList();
        testDAOlist.saveStudent(testStudent);
    }

    @After
    public void killStudent() {
        testStudent = null;
        testStudentList.clear();
    }

    @Test
    public void testSaveStudent() {
        assertEquals(testStudentList,testDAOlist.findAll());
    }

    @Test
    public void testFindByEmail_RightEmail() {
        assertEquals(testDAOlist.findAll().get(0),testDAOlist.findByEmail("ture.test@gmail.com"));
    }

    @Test
    public void testFindByEmail_WrongEmail() {
        assertNull(testDAOlist.findByEmail("sture.test@gmail.com"));

    }

    @Test
    public void testFindByName() {
        assertEquals(testStudentList,testDAOlist.findByName("Ture"));
    }

    @Test
    public void testFindByName_NoHit() {
        assertTrue(testDAOlist.findByName("Anders").isEmpty());
    }

    @Test
    public void testFindById_ExcistingId() {
        assertEquals(testDAOlist.findAll().get(0),testDAOlist.findById(testStudent.getId()));
    }

    @Test
    public void testFindById_NonExcistingId() {
        assertNull(testDAOlist.findById(Integer.MAX_VALUE));
    }

    @Test
    public void testFindAll() {
        assertEquals(testStudentList,testDAOlist.findAll());
    }

    @Test
    public void testDeleteStudent_Correct(){
        assertTrue(testDAOlist.deleteStudent(testStudent));

    }

    @Test
    public void testDeleteStudent_Incorrect(){
        Student testStudent2 = new Student("Therese Test","therese.test@gmail.com","Testvägen 24");
        assertFalse(testDAOlist.deleteStudent(testStudent2));
    }
}