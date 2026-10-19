import java.util.HashSet;

public class Course {
    private int courseId;
    private String courseName;
    private int courseCredit;

    private HashSet<Integer> studentIds = new HashSet<>();

    public Course(int id, String name, int credit){
        setCourseId(id);
        setCourseCredit(credit);
        setCourseName(name);
        System.out.println("Course is added successfully!");
    }

    public int getCourseId() {
        return courseId;
    }
    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseCredit() {
        return courseCredit;
    }
    public void setCourseCredit(int courseCredit) {
        this.courseCredit = courseCredit;
    }

    public HashSet<Integer> getStudentIds() {
        return studentIds;
    }
    
}
