import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Course> courses = new ArrayList<>();
        boolean exit = false;
        while(!exit){
            System.out.println("===== COLLAGE MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Student");
            System.out.println("5. Add Course");
            System.out.println("6. Remove Course");
            System.out.println("7. Display Courses");
            System.out.println("8. Enroll Student");
            System.out.println("9. Update Mark");
            System.out.println("10. Display Result");
            System.out.println("11. Sort Student");
            System.out.println("12. Join Club");
            System.out.println("13. Generate Report");
            System.out.println("14. Exit");

            System.out.println();
            System.out.print("Enter a Number: ");
            int option = sc.nextInt();
            sc.nextLine();

            if(option > 14 || option < 1){
                continue;
            }

            switch(option){
                case 1:
                    System.out.print("Enter Student Name : ");
                    String studentName = sc.nextLine();
                    System.out.print("Enter Student Department : ");
                    String studentDept = sc.nextLine();
                    System.out.print("Enter Student Number : ");
                    long studentNo = sc.nextLong();
                    sc.nextLine();
                    Student std = new Student(studentName, studentDept, studentNo);
                    students.add(std);
                    break;
                case 2:
                    boolean removeStudent = false;
                    System.out.print("Enter Student ID : ");
                    int studentId = sc.nextInt();
                    sc.nextLine();
                    for(Student st : students ){
                        if(st.getStudentId() == studentId){
                            System.out.println("Student ID : "+st.getStudentId());
                            System.out.println("Student Name : "+st.getStudentName());
                            System.out.println("Student Department : "+st.getStudentdept());
                            System.out.println("Student Number : "+st.getStudentNo());
                            students.remove(st);
                            removeStudent = true;
                            break;
                        }
                    }
                    if(!removeStudent){
                        System.out.println("Student not found!");
                    }else{
                        System.out.println("Student Removed Successfully!");
                    }
                    break;
                case 3:
                    System.out.print("Enter student ID : ");
                    int stdId = sc.nextInt();
                    sc.nextLine();
                    for(Student st : students ){
                        if(st.getStudentId() == stdId){
                            System.out.println("Student ID : "+st.getStudentId());
                            System.out.println("Student Name : "+st.getStudentName());
                            System.out.println("Student Department : "+st.getStudentdept());
                            System.out.println("Student Number : "+st.getStudentNo());
                            break;
                        }
                    }
                    break;
                case 4:
                    for(Student st : students ){
                        System.out.println("Student ID : "+st.getStudentId());
                        System.out.println("Student Name : "+st.getStudentName());
                        System.out.println("Student Department : "+st.getStudentdept());
                        System.out.println("Student Number : "+st.getStudentNo());
                        System.out.println();
                    }
                    break;
                case 5:
                    System.out.print("Enter Course Name : ");
                    String courseName = sc.nextLine();
                    System.out.print("Enter Course Id : ");
                    int courseId = sc.nextInt();
                    System.out.print("Enter Course Credit : ");
                    int courseCredit = sc.nextInt();
                    sc.nextLine();
                    Course crs = new Course(courseId, courseName, courseCredit);
                    courses.add(crs);
                    break;
                case 6:
                    boolean removeCourse = false;
                    System.out.print("Enter Course ID : ");
                    int crsId = sc.nextInt();
                    sc.nextLine();
                    for(Course course : courses ){
                        if(course.getCourseId() == crsId){
                            System.out.println("Course ID : "+course.getCourseId());
                            System.out.println("Course Name : "+course.getCourseName());
                            System.out.println("Course Credit : "+course.getCourseCredit());
                            courses.remove(course);
                            removeCourse = true;
                            break;
                        }
                    }
                    if(!removeCourse){
                        System.out.println("Course not found!");
                    }else{
                        System.out.println("Course Removed Successfully!");
                    }
                    break;
                case 7:
                    for(Course course : courses ){
                        System.out.println("Course ID : "+course.getCourseId());
                        System.out.println("Course Name : "+course.getCourseName());
                        System.out.println("Course Credit : "+course.getCourseCredit());
                        System.out.println();
                    }
                    break;
                case 8:
                    Student student = null;
                    Course course = null;
                    System.out.print("Enter Student ID : ");
                    int stId = sc.nextInt();
                    System.out.print("Enter Course ID : ");
                    int cId = sc.nextInt();
                    for(Student st : students ){
                        if(st.getStudentId() == stId){
                            student = st;
                            System.out.println("Student ID : "+st.getStudentId());
                            System.out.println("Student Name : "+st.getStudentName());
                            System.out.println("Student Department : "+st.getStudentdept());
                            System.out.println("Student Number : "+st.getStudentNo());
                            break;
                        }
                    }
                    for(Course cours : courses ){
                        if(cours.getCourseId() == cId){
                            course = cours;
                            System.out.println("Course ID : "+cours.getCourseId());
                            System.out.println("Course Name : "+cours.getCourseName());
                            System.out.println("Course Credit : "+cours.getCourseCredit());
                            break;
                        }
                    }
                    try {
                        Enrollment.enroll(student, course);
                    } catch (NullPointerException e) {
                        System.out.println("Invalid student or course ID");
                    }
                    break;
                case 9:
                    Student s = null;
                    System.out.print("Enter Student ID : ");
                    int sId = sc.nextInt();
                    for(Student st : students ){
                        if(st.getStudentId() == sId){
                            s = st;
                            break;
                        }
                    }
                    System.out.print("Enter Course ID : ");
                    int coId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter mark out of 100 : ");
                    int mark = sc.nextInt();
                    sc.nextLine();
                    try {
                        if(mark <= 100 && mark >= 0){
                            s.addMark(coId, mark);
                            System.out.println("Marks have been updated successfully!");
                        }
                        else{
                            System.out.println("Mark value is invalid");
                        }
                    } catch (NullPointerException e) {
                        System.out.println("Invalid student or course ID");
                    }
                    break;
                case 10:
                    Student stu = null;
                    System.out.print("Enter Student ID : ");
                    int stuId = sc.nextInt();
                    for(Student st : students ){
                        if(st.getStudentId() == stuId){
                            stu = st;
                            break;
                        }
                    }
                    sc.nextLine();
                    try {
                        System.out.println("========== STUDENT RESULT ==========");
                        System.out.println();
                        System.out.println("Student ID : "+stu.getStudentId());
                        System.out.println("Student Name : "+stu.getStudentName());
                        System.out.println();
                        stu.displayMarks();
                    } catch (NullPointerException e) {
                        System.out.println("Invalid student ID");
                    }
                    break;
                case 11:
                    System.out.println("====== SORT STUDENT ======");
                    System.out.println();
                    System.out.println("1. Sort By Student ID");
                    System.out.println("2. Sort By Student Name");
                    System.out.println("3. Sort By Student Marks");
                    System.out.println();
                    System.out.print("Enter the Option : ");
                    int choice = sc.nextInt();
                    switch (choice) {
                        case 1:
                            System.out.println("====== STUDENT SORT BY ID ======");
                            System.out.println("ID      NAME               DEPARTMENT");
                            System.out.println("-------------------------------------");
                            students.sort(Comparator.comparingInt((st) -> st.getStudentId()));
                            for(Student st : students ){
                                System.out.printf("%-8d%-18s%-10s\n", st.getStudentId(), st.getStudentName(), st.getStudentdept());
                            }
                            break;
                        case 2:
                            System.out.println("====== STUDENT SORT BY NAME ======");
                            System.out.println("ID      NAME               DEPARTMENT");
                            System.out.println("-------------------------------------");
                            students.sort(Comparator.comparing((st) -> st.getStudentName()));
                            for(Student st : students){
                                System.out.printf("%-8d%-18s%-10s\n", st.getStudentId(), st.getStudentName(), st.getStudentdept());
                            }
                            break;
                        case 3:
                            System.out.println("====== STUDENT SORT BY MARKS ======");
                            System.out.println("ID      NAME            TOTAL MARKS");
                            System.out.println("-----------------------------------");
                            students.sort(Comparator.comparingInt((st) -> st.totalMarks()));
                            for(Student st : students){
                                System.out.printf("%-8d%-18s%-10s\n", st.getStudentId(), st.getStudentName(), st.totalMarks());
                            }
                            break;
                    }
                    break;
                case 12:
                    Student stud = null;
                    System.out.print("Enter Student ID : ");
                    int studId = sc.nextInt();
                    sc.nextLine();
                    for(Student st : students ){
                        if(st.getStudentId() == studId){
                            stud = st;
                            break;
                        }
                    }
                    try {
                        System.out.println("Student Name : "+ stud.getStudentName());
                        System.out.println();
                        System.out.println("1. Java Club");
                        System.out.println("2. Coding Club");
                        System.out.println("3. Robotics Club");
                        System.out.println();
                        System.out.print("Enter your Choice : ");
                        int clubNo = sc.nextInt();
                        switch(clubNo){
                            case 1 -> stud.addClub("Java Club");
                            case 2 -> stud.addClub("Coding Club");
                            case 3 -> stud.addClub("Robotics Club");
                        }
                    } catch (NullPointerException e) {
                        System.out.println("Student Not Found");
                    }
                    break;
                case 13:
                    System.out.println("Generating department report ....");
                    Thread t1 = new Thread(new DepartmentReport("CSE"));
                    Thread t2 = new Thread(new DepartmentReport("IT"));
                    Thread t3 = new Thread(new DepartmentReport("ECE"));
                    t1.start();
                    t2.start();
                    t3.start();
                    try {
                        t1.join();
                        t2.join();
                        t3.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case 14:
                    exit = true;
                    break;
            }
        }
        sc.close();
    }
}
