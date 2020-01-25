import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void enrollCourseSize()
    {
        //setting up the student
        Student dottyHorsman = new Student(180081, "DottyHorsman");
        //setting up class 1
        Course computerScience = new Course(000001, 100, "Computer Science 1", "cool and good", 3);
        dottyHorsman.enrollCourse(computerScience);
        //test
        assertEquals(1, dottyHorsman.enrolledCourses.size());
    }

    @Test
    void setGradeTrue()
    {
        //setting up the student
        Student dottyHorsman = new Student(180081, "DottyHorsman");
        //setting up class 1
        Course computerScience = new Course(000001, 100, "Computer Science 1", "cool and good", 3);
        dottyHorsman.enrollCourse(computerScience);
        assertTrue(dottyHorsman.setGrade(computerScience, 3.3)); //B+
    }

    @Test
    void setGradeFalse()
    {
        //setting up the student
        Student dottyHorsman = new Student(180081, "DottyHorsman");
        //setting up class 1
        Course computerScience = new Course(000001, 100, "Computer Science 1", "cool and good", 3);
        //don't add the course to the student
        assertFalse(dottyHorsman.setGrade(computerScience, 3.3)); //B+
    }

    @Test
    void calcGPA()
    {
        /*
        A -->  93 - 100
        A- --> 90 - 92
        B+ --> 87 - 89
        B -->  83 - 86
        B- --> 80 - 82
        C+ --> 77 - 79
        C -->  73 - 76
        C- --> 70 - 72
        D+ --> 67 - 69
        D -->  63 - 66
        D- --> 60 - 62
        F -->  59 - 0
        */

        //setting up the student
        Student dottyHorsman = new Student(0000, "DottyHorsman");

        //setting up class 1
        Course computerScience = new Course(00001, 100, "Computer Science 1", "cool and good", 3);
        dottyHorsman.enrollCourse(computerScience);
        dottyHorsman.setGrade(computerScience, 2.7); //B-
        //setting up class 2
        Course discreteStructures = new Course(00002, 200, "Discrete Structures", "just okay", 4);
        dottyHorsman.enrollCourse(discreteStructures);
        dottyHorsman.setGrade(discreteStructures, 4.0); //A
        //setting up class 3
        Course biology = new Course(00003, 300, "Biology", "bad", 4);
        dottyHorsman.enrollCourse(biology);
        dottyHorsman.setGrade(biology, 1.7); //C-

        //gradeTotal should be 30.9
        //creditTotal should be 11

        //test (rounded: 2.81)
        assertEquals(2.809090909090909, dottyHorsman.calculateGPA());

    }
}