import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Student
{
    private int studentID;
    private String studentName;

    private HashMap<Integer, Double> studentGrades;

    ArrayList<Course> enrolledCourses;


    public Student(int studentID, String studentName)
    {
        this.studentID = studentID;
        this.studentName = studentName;
        this.enrolledCourses = new ArrayList<>();
        this.studentGrades = new HashMap<Integer, Double>(); //key, value --> courseID, gradeForCourse
    }

    public void displayCourses()
    {
        for (int i = 0; i < enrolledCourses.size(); i++)
        {
            System.out.println("Course: " + enrolledCourses.get(i).getName());
            System.out.println("Course ID: " + enrolledCourses.get(i).getID());
            System.out.println("Course Code: " + enrolledCourses.get(i).getCode());
            System.out.println("Description: " + enrolledCourses.get(i).getDescription());
            System.out.println("Credit: " + enrolledCourses.get(i).getCredit() + "\n");
        }
    }

    public void enrollCourse(Course course)
    {
        enrolledCourses.add(course);
    }

    public List<Course> getEnrolledCourse()
    {
        return(enrolledCourses);
    }

    public boolean setGrade(Course course, double grade)
    {
        /*
        A -->  93 - 100 --> 4.0
        A- --> 90 - 92 -->  3.7
        B+ --> 87 - 89 -->  3.3
        B -->  83 - 86 -->  3.0
        B- --> 80 - 82 -->  2.7
        C+ --> 77 - 79 -->  2.3
        C -->  73 - 76 -->  2.0
        C- --> 70 - 72 -->  1.7
        D+ --> 67 - 69 -->  1.3
        D -->  65 - 66 -->  1.0
        F -->  64 - 0  -->  0.0
        */

        if(enrolledCourses.contains(course))
        {
            this.studentGrades.put(course.getID(), grade); //key, value --> courseID, gradeForCourse
            return(true);
        }
        //else
        return(false);
    }

    public double calculateGPA()
    {
        double gradePoints = 0;
        double creditTotal = 0;

        for (int i = 0; i < studentGrades.size(); i++)
        {
            //gradePoints = (grade1 * credit1) + (...)
            //creditTotal = credit1 + ...
            //result = gradePoints / creditTotal

            gradePoints += (enrolledCourses.get(i).getCredit()  *  studentGrades.get(enrolledCourses.get(i).getID()));

            creditTotal += enrolledCourses.get(i).getCredit();
        }

        return(gradePoints / creditTotal);
    }
}