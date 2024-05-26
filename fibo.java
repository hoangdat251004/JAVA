// 50 loc passed

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fibo;

import java.util.*;

/**
 *
 * @author hoang.dat
 */
public class Fibo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        boolean test = true;
        int[] sequenceFibonacci = new int[45];
        // Step1. Create the sequence Fibonacci by recursion
        recursion(sequenceFibonacci, 0);
        // Step2. Display the sequence Fibonacci
        display(sequenceFibonacci, test);
    }

    static void recursion(int[] array, int i) {

        // Forming the platform element
        if (i <= 1) {
            array[i] = i;
            i++;
        }

        // Each element created by adding two element before it
        if (i > 1) {
            array[i] = array[i - 1] + array[i - 2];
            i++;
        }

        // Create 45 sequence Fibonacci using the recursion
        if (i < 45) {
            recursion(array, i);
        }
    }

    static void display(int[] array, boolean test) {
        System.out.println("The 45 sequence Fibonacii");
        // Display 45 sequence Fibonacci
        for (int i = 0; i < 45; i++) {
            if (test == false) {
                if (i < 44) {
                    System.out.print(array[i] + ",");
                } else {
                    System.out.println(array[i]);
                }
            } else {
                System.out.println("Index " + (i + 1) + ": " + array[i]);
            }
        }
        Scanner sc = new Scanner(System.in);
        int stop = sc.nextInt();
    }

}
