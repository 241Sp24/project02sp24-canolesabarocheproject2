/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentdriver;

/**
 *
 * @author dianar
 */
import java.util.*;
import java.io.*;

public class StudentDriver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Project02");

        File inputFile = new File("input.csv");
        Scanner input = new Scanner(inputFile);
        StudentFees[] fees = new StudentFees[12];
        int i = 0;
        while (input.hasNextLine()) {
            if (i < 5) {
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
            }

            if (i < 9) {
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
            }

            if (i < 12) {
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
        input.close();

        for (StudentFees a : fees) {
            System.out.println(a);
            System.out.println("");
        }

    }

}
