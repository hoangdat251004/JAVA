/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix;

import java.util.Scanner;

/**
 *
 * @author hoang.dat
 */
public class Manager {

    public static final Scanner in = new Scanner(System.in);

    public static int getChoice() {
        System.out.println("1. Addition Matrix");
        System.out.println("2. Subtraction Matrix");
        System.out.println("3. Multiplication Matrix");
        System.out.println("4. Quit");
        System.out.print("Enter your choice: ");
        int choice = checkChoice();
        return choice;
    }

    public static int checkChoice() {
        while (true) {
            try {
                int choice = Integer.parseInt(in.nextLine());
                if (choice < 1 || choice > 4) {
                    throw new NumberFormatException();
                }
                return choice;
            } catch (NumberFormatException ex) {
                System.err.print("Re-enter your choice:");
            }
        }
    }

    public static int checkInputInt(String msg) {
        while (true) {
            System.out.print(msg);
            try {
                int result = Integer.parseInt(in.nextLine());
                return result;
            } catch (NumberFormatException ex) {
                System.err.println("Re-input");
            }
        }
    }
    
    public static int checkMatrix() {
        while (true) {
            try {
                int input = Integer.parseInt(in.nextLine());
                if(input > 0){
                    return input;
                } else {
                    System.out.println("Row or col must be positive.");
                    System.out.print("Enter again:");
                }
            } catch (NumberFormatException ex) {
                System.err.println("Re-input");
            }
        }
    }

    public static int[][] inputMatrix1() {
        System.out.print("Enter Row Matrix 1: ");
        int row = checkMatrix();
        System.out.print("Enter Colum Matrix 1: ");
        int col = checkMatrix();
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                String msg = String.format("Enter Matrix1: [" + (i + 1) + "]" + "[" + (j + 1) + "]:");
                matrix[i][j] = checkInputInt(msg);
            }
        }
        return matrix;
    }
    
    public static int[][] inputMatrix2(int[][] matrix1, int choice) {
        
        int row = 0;
        int col = 0;
        if(choice == 3){
            while(true){
                System.out.print("Enter Row Matrix2: ");
                row = checkMatrix();
                if(row == matrix1[0].length){
                    break;
                }
            }
            col = checkMatrix();
        } else {
            while(true){
                System.out.print("Enter Row Matrix2:");
                row = checkMatrix();
                if(row == matrix1.length){
                    break;
                } else {
                    System.out.println("Row matrix 2 must equal row matrix 1.");
                }
            }
            
            while(true){
                System.out.print("Enter Col Matrix2:");
                col = checkMatrix();
                if(col == matrix1[0].length){
                    break;
                } else{
                    System.out.println("Col matrix 2 must equal col matrix 1.");
                }
            }
        }
        
        
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                String msg = String.format("Enter Matrix2: [" + (i + 1) + "]" + "[" + (j + 1) + "]:");
                matrix[i][j] = checkInputInt(msg);
            }
        }
        return matrix;
    }

    public static void displayMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            //loop to traversal all element in one col
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print("[" + matrix[row][col] + "]");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public static void additionMatrix(int choice) {
        System.out.println("---------- Addition ----------");
        int[][] matrix1 = inputMatrix1();
        int[][] matrix2 = inputMatrix2(matrix1, choice);
        System.out.println("---------- Result ----------");
        displayMatrix(matrix1);
        System.out.println("+");
        displayMatrix(matrix2);
        System.out.println("=");
        
        int[][] result = new int[matrix1.length][matrix1[0].length];
        for (int row = 0; row < matrix1.length; row++) {
            for (int col = 0; col < matrix1[row].length; col++) {
                result[row][col] = matrix1[row][col] + matrix2[row][col];
            }
        }
        displayMatrix(result);
    }

    public static void subtractionMatrix(int choice) {
        System.out.println("---------- Subtraction ----------");
        int[][] matrix1 = inputMatrix1();
        int[][] matrix2 = inputMatrix2(matrix1, choice);
        System.out.println("---------- Result ----------");
        displayMatrix(matrix1);
        System.out.println("-");
        displayMatrix(matrix2);
        System.out.println("=");
        
        int[][] result = new int[matrix1.length][matrix1[0].length];
        for (int row = 0; row < matrix1.length; row++) {
            for (int col = 0; col < matrix1[row].length; col++) {
                result[row][col] = matrix1[row][col] - matrix2[row][col];
            }
        }
        displayMatrix(result);
    }

    public static void multiplicationMatrix(int choice) {
        System.out.println("---------- Multiplication ----------");
        int[][] matrix1 = inputMatrix1();
        int[][] matrix2 = inputMatrix2(matrix1, choice);
        System.out.println("---------- Result ----------");
        displayMatrix(matrix1);
        System.out.println("*");
        displayMatrix(matrix2);
        System.out.println("=");
        int row = matrix1.length; //result's row
        int col = matrix2[0].length; //result's col
        int col1 = matrix1[0].length; //matrix1's col 
        
        int[][] result = new int[matrix1.length][matrix2[0].length];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result[i][j] = 0;
                for (int k = 0; k < matrix1[0].length; k++) {
                    result[i][j] += matrix1[i][k]*matrix2[k][j];
                }
            }
        }
        displayMatrix(result);
    }
}
