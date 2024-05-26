/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binsearch;

import java.util.*;


/**
 *
 * @author hoang.dat
 */
public class BinSearch {

    // Returns index of x if it is present in arr[l.. 
    // r], else return -1 
    static int binarySearch(int[] arr, int x) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;

            // Check if x is present at mid 
            if (arr[m] == x) {
                return m;
            }

            // If x greater, ignore left half 
            if (arr[m] < x) {
                l = m + 1;
            } // If x is smaller, ignore right half 
            else {
                r = m - 1;
            }
        }

        // if we reach here, then element was not present 
        return -1;
    }

    static void insertionSort(int[] arr) 
    {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are 
               greater than key, to one position ahead 
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
    
    static void display(int[] arr, int searchValue){
        if (binarySearch(arr, searchValue) != -1) {
            System.out.println("Found " + searchValue + " at index: " + binarySearch(arr, searchValue));
        } else {
            System.out.println("Value not found!!");
        }
    }

    public static void main(String[] args) {

        // 1
        int arr_size = Utility.getIntput("Enter number of array: ");
        // 2
        int arr[] = Utility.generateRandomArray(arr_size);
        // 3
        insertionSort(arr);
        // 4
        int searchValue = Utility.getIntput("Enter search value: ");
        // 5
        display(arr, searchValue);
    }

}
