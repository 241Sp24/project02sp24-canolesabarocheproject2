package studentdriver;

/**
 *
 * Class: 44-241 Computer Programming II
 *
 * Author: Hunter Canole, Juvaan Sabaroche
 *
 * Description: Project for module 6. Create a program that will calculate and
 * display the fee amount to be paid by students at the university. Calculate
 * the average fee paid by UG students, Graduate students and Online students.
 * Print out the count of UG students who received a scholarship and Graduate
 * students who received an assistantship.
 *
 * Due: 5/10/2024
 *
 * I pledge that I have completed the programming assignment independently.
 *
 * I have not copied the code from a student or any source.
 *
 * I have not given my code to any other student and will not share this code
 * with anyone under any circumstances.
 *
 */
//import java api
import java.util.*;
import java.io.*;

public class StudentDriver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Project02");

        //Creating inputFile File object
        File inputFile = new File("input.csv");
        //Created Scanner objects
        Scanner user = new Scanner(System.in);
        Scanner input = new Scanner(inputFile);
        //Created Studentfees array
        StudentFees[] fees = new StudentFees[12];

        //Declared and Initialized Variables
        int i = 0;
        int noOfUGStudents;
        int noOfGrads;
        int noOfOS;
        int noOfScholarships = 0;
        double ugFees = 0;
        int ugCourse = 0;
        double gradFees = 0;
        int gradCourses = 0;
        int gradAssistants = 0;
        double osFees = 0;

        //Gather user inputs
        System.out.print("Enter the number of UG Students: ");
        noOfUGStudents = user.nextInt();
        System.out.print("Enter the number of Graduate Students: ");
        noOfGrads = user.nextInt();
        System.out.print("Enter the number of Online Students: ");
        noOfOS = user.nextInt();
        System.out.println("");

        //Reading from input file
        while (input.hasNextLine()) {

            //Creates UGStudent objects and adds them to Array fees
            if (i < noOfUGStudents) {
                String[] arr = input.nextLine().split(",");
                int a = Integer.parseInt(arr[0]);
                String b = arr[1];
                boolean c = Boolean.parseBoolean(arr[2]);
                int d = Integer.parseInt(arr[3]);
                boolean e = Boolean.parseBoolean(arr[4]);
                double f = Double.parseDouble(arr[5]);

                UGStudent stu = new UGStudent(b, a, c, f, d, e);
                fees[i] = stu;
                i++;

                //Creates Graduate Student Objects and adds them to Array fees
            } else if (i < noOfGrads + noOfUGStudents) {
                String[] ar = input.nextLine().split(",");
                if (ar.length == 6) {
                    int a = Integer.parseInt(ar[0]);
                    String b = ar[1];
                    boolean c = Boolean.parseBoolean(ar[2]);
                    int d = Integer.parseInt(ar[3]);
                    boolean e = Boolean.parseBoolean(ar[4]);
                    String f = ar[5];

                    GraduateStudent stu = new GraduateStudent(b, a, c, e, f, d);
                    fees[i] = stu;
                } else {
                    int a = Integer.parseInt(ar[0]);
                    String b = ar[1];
                    boolean c = Boolean.parseBoolean(ar[2]);
                    int d = Integer.parseInt(ar[3]);
                    boolean e = Boolean.parseBoolean(ar[4]);

                    GraduateStudent stu = new GraduateStudent(b, a, c, e, d);
                    fees[i] = stu;
                }
                i++;
            } //Creates OnlineStudent Objects and adds them to Array fees
            else {
                String[] arr = input.nextLine().split(",", 10);
                int a = Integer.parseInt(arr[0]);
                String b = arr[1];
                boolean c = Boolean.parseBoolean(arr[2]);
                int d = Integer.parseInt(arr[3]);

                OnlineStudent stu = new OnlineStudent(b, a, c, d);
                fees[i] = stu;
                i++;
            }
        }

        //Stops reading input file
        input.close();

        //Prints Undergraduate Objects
        System.out.println("**********Undergraduate students list**********");
        for (StudentFees a : fees) {
            if (a instanceof UGStudent) {
                System.out.println(a);
                System.out.println("");

                //Undergraduate details computations
                if (a.isIsEnrolled() == true) {
                    ugFees += a.getPayableAmount();
                    ugCourse += ((UGStudent) a).getCoursesEnrolled();
                    if (((UGStudent) a).isHasScholarship() == true) {
                        noOfScholarships++;
                    }
                }
            }
        }

        //Prints Graduate Objects
        System.out.println("**********Graduate students list**********");
        for (StudentFees a : fees) {
            if (a instanceof GraduateStudent) {
                System.out.println(a);
                System.out.println("");

                //Graduate Students details computations
                gradFees += a.getPayableAmount();
                gradCourses += ((GraduateStudent) a).getCoursesEnrolled();
                if (((GraduateStudent) a).isIsGraduateAssistant() == true) {
                    gradAssistants++;
                }
            }
        }

        //Prints Online Student Objects
        System.out.println("**********Online students list**********");
        for (StudentFees a : fees) {
            if (a instanceof OnlineStudent) {
                System.out.println(a);
                System.out.println("");

                //Online Students details computations
                osFees += a.getPayableAmount();
            }
        }

        //Prints out Undergraduate Students details with header
        System.out.println("**********Undergraduate Students details**********");
        System.out.printf("Average Student fees: %.2f\n", +(ugFees / 4));
        System.out.println("Scholarship count: " + noOfScholarships);
        System.out.println("Total number of courses: " + (ugCourse));
        System.out.println("");

        //Prints out Gradaute Students details with header
        System.out.println("**********Graduate Students details**********");
        System.out.printf("Average Student fees: %.2f\n", +(gradFees / noOfGrads));
        System.out.println("Graduate Assistant Count: " + gradAssistants);
        System.out.println("Total number of courses: " + gradCourses);
        System.out.println("");

        //Prints out Online Students details with header
        System.out.println("**********Online Students details**********");
        System.out.printf("Average Student fees: %.2f\n", +(osFees / noOfOS));
    }

}
