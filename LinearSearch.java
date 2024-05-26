/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linearsearch;

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;


/**
 *
 * @author hoang.dat
 */
public class LinearSearch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // step1: 
        int number = enterNumberOfArray();
        // step2:
        int[] array = generateRandomArray(number);
        // step3:
        int searchValue = enterSearchValue();
        // step4:
        display(array, searchValue);
    }

    static int enterNumberOfArray() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of array:");
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

    static int enterSearchValue() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter search value:");
        // check input format
        while (true) {
            try {
                int searchValue = Integer.parseInt(sc.nextLine());
                return searchValue;

                // check number format
            } catch (NumberFormatException e) {
                System.err.println("Wrong format input. Enter again.");
            }
        }
    }

    static int[] generateRandomArray(int number) {
        int[] array = new int[number];
        // loop to generate each element of array in range number 
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(array.length);
        }
        System.out.println("The array: " + Arrays.toString(array));
        return array;
    }

    static void display(int[] array, int searchValue) {
        boolean found = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == searchValue) {
                System.out.println("Found " + searchValue + " at index: " + i);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Not Found");
        }
    }

}
