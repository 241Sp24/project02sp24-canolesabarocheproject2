package studentdriver;

/**
 *
 * @author s567597
 */
public abstract class StudentFees {

    private String studentName;
    private int studentID;
    private boolean isEnrolled;
    private final int CREDIT_PER_COURSE = 3;
    private final double PER_CREDIT_FEE = 543.50;

    /**
     *
     * @param studentName
     * @param studentId
     * @param isEnrolled
     */
    public StudentFees(String studentName, int studentId, boolean isEnrolled) {
        this.studentName = studentName;
        this.studentID = studentId;
        this.isEnrolled = isEnrolled;
    }

    /**
     * @return the studentName
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * @param studentName the studentName to set
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     * @return the studentID
     */
    public int getStudentID() {
        return studentID;
    }

    /**
     * @param studentID the studentID to set
     */
    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    /**
     * @return the isEnrolled
     */
    public boolean isIsEnrolled() {
        return isEnrolled;
    }

    /**
     * @param isEnrolled the isEnrolled to set
     */
    public void setIsEnrolled(boolean isEnrolled) {
        this.isEnrolled = isEnrolled;
    }

    /**
     * @return the CREDIT_PER_COURSE
     */
    public int getCREDIT_PER_COURSE() {
        return CREDIT_PER_COURSE;
    }

    /**
     * @return the PER_CREDIT_FEE
     */
    public double getPER_CREDIT_FEE() {
        return PER_CREDIT_FEE;
    }

    /**
     *
     * @return
     */
    public abstract double getPayableAmount();

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Student Name: " + this.studentName + "\nStudentID: " + this.studentID
                + "\nEnrolled: " + this.isEnrolled;
    }

}
