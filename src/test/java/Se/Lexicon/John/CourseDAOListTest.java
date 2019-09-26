package Se.Lexicon.John;

import static org.junit.Assert.*;
import Se.Lexicon.John.data_access.CourseDAOList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CourseDAOListTest {
    private Course testCourse;
    private List<Course> testCourseList = new ArrayList<>();
    private CourseDAOList testDAOList;
    private final String testCourseName = "Java Masterclass";
    private final LocalDate testStartDate = LocalDate.of(2019,8,19);
    private int testWeekDuration = 40;

    @Before
    public void createCourse() {
        testCourse = new Course(testCourseName,testStartDate,testWeekDuration);
        testCourseList.add(testCourse);
        testDAOList = new CourseDAOList();
        testDAOList.saveCourse(testCourse);
    }

    @After
    public void endCourse() {
        testCourse = null;
        testCourseList.clear();;
    }

    @Test
    public void testSaveCourse() {
        assertEquals(testCourseList,testDAOList.findAll());
    }

    @Test
    public void testFindById_ExcistingId() {
        assertEquals(testDAOList.findAll().get(0),testDAOList.findById(testCourse.getId()));
    }

    @Test
    public void testFindById_NonExcistingId() {
        assertNull(testDAOList.findById(Integer.MAX_VALUE));
    }

    @Test
    public void testFindByName() {
        assertEquals(testCourseList,testDAOList.findByName("Java"));
    }

    @Test
    public void testFindByName_NoHit() {
        assertTrue(testDAOList.findByName("C#").isEmpty());
    }

    @Test
    public void testFindByDate() {
        assertEquals(testCourseList,testDAOList.findByDate(LocalDate.of(2019,8,19)));
    }

    @Test
    public void testFindByDate_NoHit() {
        assertTrue(testDAOList.findByDate(LocalDate.of(2015,7,25)).isEmpty());
    }

    @Test
    public void testFindAll() {
        assertEquals(testCourseList,testDAOList.findAll());
    }

    @Test
    public void testDeleteCourse_Correct(){
        assertTrue(testDAOList.removeCourse(testCourse));
    }

    @Test
    public void testDeleteStudent_Incorrect(){
        Course testCourse2 = new Course("C# for Dummies",LocalDate.of(2019,10,23),120);
        assertFalse(testDAOList.removeCourse(testCourse2));
    }
}
