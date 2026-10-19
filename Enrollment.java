public class Enrollment {
    public static void enroll(Student student, Course course){
        if(student.getCourseIds().contains(course.getCourseId())){
            System.out.println("You have already registered for this course");
        }
        else{
            student.getCourseIds().add(course.getCourseId());
            course.getStudentIds().add(student.getStudentId());
            System.out.println(student.getStudentName() + " Has successfully registered for the "+course.getCourseName()+" course!");
            
        }
    }
}
