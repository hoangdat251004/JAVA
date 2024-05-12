/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binsearch;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author hoang.dat
 */
public class Utility {

    static int getIntput(String msg) {
        Scanner sc = new Scanner(System.in);
        System.out.println(msg);
        // check input format and value of number greater than ZERO
        while (true) {
            try {
                int number = Integer.parseInt(sc.nextLine());
                // check value of number is greater then ZERO or not
                if (number > 0) {
                    return number;
                } else {
                    System.out.println("Number input can not below or equal ZERO");
                }
                // check number format
            } catch (NumberFormatException e) {
                System.err.println("Wrong format input. Enter again.");
            }
        }
    }

    static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        // loop to generate each element of array in range number 
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(array.length);
        }
        return array;
    }

}
