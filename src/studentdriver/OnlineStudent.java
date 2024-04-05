package studentdriver;

/**
 *
 * @author s567597
 */
public class OnlineStudent extends StudentFees {

    private int noOfMonths;
    private final double MONTHLY_FEE = 1245.25;

    /**
     *
     * @param studentName
     * @param studentID
     * @param isEnrolled
     * @param noOfMonths
     */
    public OnlineStudent(String studentName, int studentID, boolean isEnrolled, int noOfMonths) {
        super(studentName, studentID, isEnrolled);
        this.noOfMonths = noOfMonths;
    }

    /**
     *
     * @return
     */
    @Override
    public double getPayableAmount() {
        return noOfMonths * MONTHLY_FEE;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return super.toString() + "\nNo of months: " + noOfMonths + "\nPayable Amount: " + String.format("%.2f", getPayableAmount());
    }
}
