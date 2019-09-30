package Se.Lexicon.John;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CourseTest {
    private Course testCourse;
    private final String testCourseName = "Java Masterclass";
    private final LocalDate testStartDate = LocalDate.of(2019,8,19);
    private final int testWeekDuration = 40;

    @Before
    public void createCourse() {
        testCourse = new Course(testCourseName, testStartDate, testWeekDuration);
    }

    @After
    public void endCourse() {
        testCourse = null;
    }

    @Test
    public void testBeforeWorks()
    {
        //Arrange
        String expectedName = testCourseName;
        LocalDate expecteddate = testStartDate;
        int expectedDuration = testWeekDuration;

        //Act
        // done by @Before

        //Assert
        assertTrue(testCourse.getId() > 0);
        assertEquals(expectedName, testCourse.getCourseName());
        assertEquals(expecteddate,testCourse.getStartDate());
        assertEquals(expectedDuration, testCourse.getWeekDuration());
    }

    @Test
    public void testSetCourseName() {
        //Arrange
        String coursename = "C# for Dummies";

        //Act
        testCourse.setCourseName(coursename);

        //Assert
        assertEquals(coursename, testCourse.getCourseName());
    }

    @Test
    public void testSetStartDate() {
        //Arrange
        LocalDate testdate = LocalDate.of(2019,9,26);

        //Act
        testCourse.setStartDate(testdate);

        //Assert
        assertEquals(testdate,testCourse.getStartDate());
    }

    @Test
    public void testSetDuration() {
        //Arrange
        int duration = 52;

        //Act
        testCourse.setWeekDuration(duration);

        //Assert
        assertEquals(duration, testCourse.getWeekDuration());
    }

    @Test
    public void testSetStudents() {
        //Arrange
        Student testStudent = new Student ("Ture Test","ture.test@gmail.com","Testvägen 42");

        //Act
        testCourse.setStudents(testStudent);

        //Assert
        assertTrue(testCourse.getStudents().contains(testStudent));
    }

    @Test
    public void testRegister() {
        //Arrange
        Student testStudent = new Student ("Ture Test","ture.test@gmail.com","Testvägen 42");

        //Act
        testCourse.register(testStudent);

        //Assert
        assertTrue(testCourse.getStudents().contains(testStudent));
        assertTrue(testStudent.getCourses().contains((testCourse)));

    }

    @Test
    public void testUnregister() {
        //Arrange
        Student testStudent = new Student ("Ture Test","ture.test@gmail.com","Testvägen 42");
        testCourse.register(testStudent);

        //Act
        testCourse.unregister(testStudent);

        //Assert
        assertTrue(testCourse.getStudents().isEmpty());
        assertTrue(testStudent.getCourses().isEmpty());
    }

    @Test
    public void testToString() {

        //Act
        String result = testCourse.toString();

        //Assert
        assertTrue(result.contains(testCourseName));
        assertTrue(result.contains(String.valueOf(testStartDate)));
        assertTrue(result.contains(String.valueOf(testWeekDuration)));
    }

}
