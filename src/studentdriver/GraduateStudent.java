package studentdriver;

/**
 *
 * @author s567597
 */
public class GraduateStudent extends StudentFees {

    private int coursesEnrolled;
    private boolean isGraduateAssistant;
    private String graduateAssistantType;
    private final double ADDITIONAL_FEES = 654.45;

    /**
     *
     * @param studentName
     * @param studentId
     * @param isEnrolled
     * @param isGraduateAssistant
     * @param graduateAssistantType
     * @param coursesEnrolled
     */
    public GraduateStudent(String studentName, int studentId, boolean isEnrolled,
            boolean isGraduateAssistant, String graduateAssistantType, int coursesEnrolled) {
        super(studentName, studentId, isEnrolled);
        this.isGraduateAssistant = isGraduateAssistant;
        this.graduateAssistantType = graduateAssistantType;
        this.coursesEnrolled = coursesEnrolled;
    }

    /**
     *
     * @param studentName
     * @param studentId
     * @param isEnrolled
     * @param isGraduateAssistant
     * @param coursesEnrolled
     */
    public GraduateStudent(String studentName, int studentId, boolean isEnrolled,
            boolean isGraduateAssistant, int coursesEnrolled) {
        super(studentName, studentId, isEnrolled);
        this.isGraduateAssistant = isGraduateAssistant;
        this.coursesEnrolled = coursesEnrolled;
        this.graduateAssistantType = "";
    }

    /**
     * @return the coursesEnrolled
     */
    public int getCoursesEnrolled() {
        return coursesEnrolled;
    }

    /**
     * @return the isGraduateAssistant
     */
    public boolean isIsGraduateAssistant() {
        return isGraduateAssistant;
    }

    /**
     *
     * @return
     */
    @Override
    public double getPayableAmount() {
        if (graduateAssistantType.equals("full")) {
            return ADDITIONAL_FEES;
        } else if (graduateAssistantType.equals("half")) {

            return (this.coursesEnrolled * super.getCREDIT_PER_COURSE() * super.getPER_CREDIT_FEE()) / 2 + ADDITIONAL_FEES;
        } else {
            return (this.coursesEnrolled * super.getCREDIT_PER_COURSE() * super.getPER_CREDIT_FEE()) + ADDITIONAL_FEES;
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\nGraduate Assistant: " + this.isGraduateAssistant + "\nGraduate Assistant Type: " + this.graduateAssistantType + "\nCourses Enrolled: " + this.coursesEnrolled
                + "\nPayable Amount: " + String.format("%.2f", getPayableAmount());
    }

}
