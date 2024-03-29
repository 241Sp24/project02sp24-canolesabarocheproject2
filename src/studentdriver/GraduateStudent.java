/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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

    public GraduateStudent(String studentName, int studentId, boolean isEnrolled,
            boolean isGraduateAssistant, String graduateAssistantType, int coursesEnrolled) {
        super(studentName, studentId, isEnrolled);
        this.isGraduateAssistant = isGraduateAssistant;
        this.graduateAssistantType = graduateAssistantType;
        this.coursesEnrolled = coursesEnrolled;
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

    @Override
    public double getPayableAmount() {
        if (graduateAssistantType.equals("full")) {
            return (this.coursesEnrolled * super.getCREDIT_PER_COURSE() * super.getPER_CREDIT_FEE()) * 0;
        } else if (graduateAssistantType.equals("half")) {

            return (this.coursesEnrolled * super.getCREDIT_PER_COURSE() * super.getPER_CREDIT_FEE()) / 2;
        } else {
            return (this.coursesEnrolled * super.getCREDIT_PER_COURSE() * super.getPER_CREDIT_FEE());
        }
    }

    public String toString() {
        return super.toString() + "\nGraduate Assistant: " + this.isGraduateAssistant + "\nGraduate Assistant Type: " + this.graduateAssistantType + "\nCourses Enrolled: " + this.coursesEnrolled
                + "\nPayable Amount: " + getPayableAmount();
    }

}