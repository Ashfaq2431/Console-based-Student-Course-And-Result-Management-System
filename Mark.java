public class Mark {
    private int mark;
    private int courseId;

    public Mark(int courseId, int mark){
        setCourseId(courseId);
        setMark(mark);
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
}
