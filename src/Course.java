public class Course
{
    private int courseID;
    private int courseCode;
    private String courseName;
    private String courseDescription;
    private int courseCredit;

    public Course(int courseID, int courseCode, String courseName, String courseDescription, int courseCredit)
    {
        this.courseID = courseID;
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.courseCredit = courseCredit;
    }

    public int getID()
    {
        return(this.courseID);
    }

    public int getCode()
    {
        return(this.courseCode);
    }

    public String getName()
    {
        return(this.courseName);
    }

    public String getDescription()
    {
        return(this.courseDescription);
    }

    public int getCredit()
    {
        return(this.courseCredit);
    }
}








