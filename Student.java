import java.util.HashMap;
import java.util.HashSet;

public class Student {
    private String studentName;
    private int studentId;
	private String studentdept;
    private long studentNo;
    private static int nextstudentId = 1000;

	private HashSet<Integer> courseIds = new HashSet<>();
	private HashMap<Integer, Mark> marks = new HashMap<>();
	private HashSet<String> club = new HashSet<>();

	public Student(String name, String dept, long no){
        studentId = nextstudentId;
        nextstudentId++;
        setStudentName(name);
        setStudentdept(dept);
        setStudentNo(no);
        System.out.println("New student is added successfully!");
        System.out.println("The student id is : "+ studentId);
    }

	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentdept() {
		return studentdept;
	}
	public void setStudentdept(String studentdept) {
		this.studentdept = studentdept;
	}

	public long getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(long studentNo) {
		this.studentNo = studentNo;
	}

	public int getStudentId() {
		return studentId;
	}

	public HashSet<Integer> getCourseIds() {
		return courseIds;
	}

	public void addMark(int courseId, int mark){
		Mark newMark = new Mark(courseId, mark);
		marks.put(courseId, newMark);
	}

	public void displayMarks(){
		double totalPercentage = 0;
		for(Mark mark : marks.values() ){
			System.out.println("Course ID : "+mark.getCourseId());
			System.out.println("Mark : "+mark.getMark());
			System.out.println();
		}
		if(!marks.isEmpty()){
			totalPercentage =(totalMarks() * 100.0) / (marks.size() * 100);
		}
		else{
			System.out.println("Marks not Found. Update the marks");
		}
		System.out.println("Total Marks : "+totalMarks());
		System.out.println("Total percentage : "+totalPercentage);
	}

	public int totalMarks(){
		int totalMark = 0;
		for(Mark mark : marks.values() ){
			totalMark += mark.getMark();
		}
		return totalMark;
	}

	public void addClub(String name){
		if(club.contains(name)){
			System.out.println("You have already in the club!");
		}
		else{
			club.add(name);
			System.out.println("You have joined the club successfully!");
		}
	}

}
