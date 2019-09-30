package Se.Lexicon.John;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StudentTest {
    private Student testStudent;
    private final String testName = "Ture Test";
    private final String testEmail = "ture.test@gmail.com";
    private final String testAdress = "Testvägen 42";

    @Before
    public void createStudent() {
        testStudent = new Student(testName,testEmail,testAdress);
    }

    @After
    public void killStudent() {
        testStudent = null;
    }

    @Test
    public void testBeforeWorks()
    {
        //Arrange
        String expectedName = testName;
        String expectedEmail = testEmail;
        String expectedAdress = testAdress;

        //Act
        // done by @Before

        //Assert
        assertTrue(testStudent.getId() > 0);
        assertEquals(expectedName, testStudent.getName());
        assertEquals(expectedEmail,testStudent.getEmail());
        assertEquals(expectedAdress, testStudent.getAdress());
    }

    @Test
    public void testSetName() {
        //Arrange
        String studentname = "Boaty McBoatface";

        //Act
        testStudent.setName(studentname);

        //Assert
        assertEquals(studentname, testStudent.getName());
    }

    @Test
    public void testSetEmail() {
        //Arrange
        String studentemail = "boaty.mcboatface@gmail.com";

        //Act
        testStudent.setEmail(studentemail);

        //Assert
        assertEquals(studentemail, testStudent.getEmail());
    }

    @Test
    public void testSetAdress() {
        //Arrange
        String studentadress = "Båtvägen 92";

        //Act
        testStudent.setAdress(studentadress);

        //Assert
        assertEquals(studentadress, testStudent.getAdress());
    }

    @Test
    public void testSetCourse() {
        //Arrange
        Course testCourse = new Course ("C# for Dummies", LocalDate.of(2019,10,23),40);

        //Act
        testStudent.setCourses(testCourse);

        //Assert
        assertTrue(testStudent.getCourses().contains(testCourse));
    }

    @Test
    public void testToString() {

        //Act
        String result = testStudent.toString();

        //Assert
        assertTrue(result.contains(testName));
        assertTrue(result.contains(testEmail));
        assertTrue(result.contains(testAdress));
    }

}
