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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Display dp = new Display();
        GetData gd = new GetData();
        Convert cv = new Convert();
        do {
            // Step 1: Display all option
            dp.displayMenu();
            // Step 2: Get user's base number input
            int baseInput = gd.getBaseInput();
            // Step 3: Get user's base number output
            int baseOutput = gd.getBaseOutput(baseInput);
            // Step 4: Get user's input value
            String inputValue = gd.getInputValue(baseInput);
            // Step 5: Convert number
            String outputValue = cv.convertNumber(baseInput, baseOutput, inputValue);
            // Step 6: Display result value to screen
            dp.displayResult(baseInput, baseOutput, inputValue, outputValue);
        } while (true);
    }

}
