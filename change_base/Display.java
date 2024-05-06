/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package change_base_fn;

/**
 *
 * @author hoang.dat
 */
public class Display {
    void displayMenu(){
        System.out.println("Menu:");
        System.out.println("\t1. Binary");
        System.out.println("\t2. Decimal");
        System.out.println("\t3. Hexadecimal");
        System.out.println("\t4. Exit");
    }
    void displayResult(int baseInput, int baseOutput,String inputValue, String outputValue){
        System.out.println("\n");
        System.out.println("Base input: " + baseInput);
        System.out.println("Base output: " + baseOutput);
        System.out.println("Input value: " + inputValue);
        System.out.println("Output value: " + outputValue);
        System.out.println("\n");
    }
}
