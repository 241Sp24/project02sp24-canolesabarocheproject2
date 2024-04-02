/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentdriver;

/**
 *
 * @author s567597
 */
public class UGStudent extends StudentFees {

    private double scholarshipAmount;
    private int coursesEnrolled;
    private boolean hasScholarship;
    private final double ADDITIONAL_FEE = 820.70;

    public UGStudent(String studentName, int studentId, boolean isEnrolled, double scholarshipAmount,
            int coursesEnrolled, boolean hasScholarship) {
        super(studentName, studentId, isEnrolled);
        this.scholarshipAmount = scholarshipAmount;
        this.coursesEnrolled = coursesEnrolled;
        this.hasScholarship = hasScholarship;
    }

    /**
     * @return the scholarshipAmount
     */
    public double getScholarshipAmount() {
        return scholarshipAmount;
    }

    /**
     * @return the coursesEnrolled
     */
    public int getCoursesEnrolled() {
        return coursesEnrolled;
    }

    /**
     * @return the hasScholarship
     */
    public boolean isHasScholarship() {
        return hasScholarship;
    }

    @Override
    public double getPayableAmount() {
        return (this.coursesEnrolled * super.getCREDIT_PER_COURSE() * super.getPER_CREDIT_FEE())
                + ADDITIONAL_FEE - scholarshipAmount;
    }

    @Override
    public String toString() {
        return super.toString() + "\nScholarship: " + this.hasScholarship
                + "\nScholarship Amount: " + this.scholarshipAmount + "\nCourses Enrolled: " + this.coursesEnrolled
                + "\nPayable Amount: " + String.format("%.2f", getPayableAmount());
    }

}
