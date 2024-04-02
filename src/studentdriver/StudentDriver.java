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

        while (input.hasNextLine()) {
            String[] arr = input.nextLine().split(",", 10);
            int a = Integer.parseInt(arr[0]);
            String b = arr[1];
            boolean c = Boolean.parseBoolean(arr[2]);
            int d = Integer.parseInt(arr[3]);
            boolean e = Boolean.parseBoolean(arr[4]);
            double f = Double.parseDouble(arr[5]);

            UGStudent stu = new UGStudent(b, a, c, f, d, e);
            System.out.println(stu + "\n");

        }
        input.close();

        for (StudentFees j : fees) {
            System.out.println(j);
        }

    }

}
