/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package change_base_fn;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author hoang.dat
 */
public class GetData {

    public int getBaseInput() {
        Scanner sc = new Scanner(System.in);
        int base = 0;
        //Loop until get right base
        while (true) {
            try {
                System.out.print("Enter base number input: ");
                int choice = Integer.parseInt(sc.nextLine());
                if (choice >= 1 && choice <= 4) {
                    switch (choice) {
                        case 1:
                            base = 2;
                            break;
                        case 2:
                            base = 10;
                            break;
                        case 3:
                            base = 16;
                            break;
                        case 4:
                            System.exit(0);
                    }
                    return base;
                } else {
                    System.out.println("Pls, choose true base system !!!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Pls, enter numberic data only !!!");
            }
        }
    }

    public int getBaseOutput(int baseInput) {
        Scanner sc = new Scanner(System.in);
        int base = 0;
        //Loop until get right base
        while (true) {
            try {
                System.out.print("Enter base number output: ");
                int choice = Integer.parseInt(sc.nextLine());
                if (choice >= 1 && choice <= 4) {
                    switch (choice) {
                        case 1:
                            base = 2;
                            break;
                        case 2:
                            base = 10;
                            break;
                        case 3:
                            base = 16;
                            break;
                        case 4:
                            System.exit(0);
                    }
                    if (base != baseInput) {
                        return base;
                    } else {
                        System.out.println("Base output can not be the same with base input");
                    }
                } else {
                    System.out.println("Pls, enter true base system !!!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Pls, enter numberic data only !!!");
            }
        }
    }

    public String getInputValue(int baseInput) {
        Scanner sc = new Scanner(System.in);
        //Loop until enter right format number within base number input
        while (true) {
            String number;
            switch (baseInput) {
                case 2: //If base number = 1 --> enter Binary number only
                    number = enterBinaryNumber();
                    break;
                case 10: //If base number = 2 --> enter Dec number only
                    number = enterDecimalNumber();
                    break;
                default: //If base number = 3 --> enter Hex number only
                    number = enterHexNumber();
                    break;
            }
            return number.toLowerCase();
        }
    }

    private static String enterBinaryNumber() {
        Scanner sc = new Scanner(System.in);
        String binaryNum;
        //Loop until enter right Binary Format Number
        while (true) {
            System.out.print("Enter the input value: ");
            binaryNum = sc.nextLine();
            if (binaryNum.isEmpty()) {
                System.out.println("You must be enter Binary Format Number!!!");
            } else {
                if (checkBinaryNumber(binaryNum)) {
                    return binaryNum;
                } else {
                    System.out.println("Your number entered not right format");
                }
            }
        }
    }

    private static boolean checkBinaryNumber(String binaryNum) {
        //Use Regex to check String contains 0 and 1.
        Pattern pattern = Pattern.compile("^[01]+$");
        Matcher matcher = pattern.matcher(binaryNum);
        return matcher.matches();
    }

    private static String enterDecimalNumber() {
        Scanner sc = new Scanner(System.in);
        String decimalNum;
        //Loop until enter right Binary Format Number
        while (true) {
            System.out.print("Enter the input value: ");
            decimalNum = sc.nextLine();
            if (decimalNum.isEmpty()) {
                System.out.println("You must be enter Decimal Format Number!!!");
            } else {
                if (checkDecNumber(decimalNum) == true) {
                    return decimalNum;
                } else {
                    System.out.println("Your number entered not right format");
                }
            }
        }
    }

    private static boolean checkDecNumber(String decimalNum) {
        //Use Regex to check String contains 0 to 9
        Pattern pattern = Pattern.compile("^-?[0-9]+$");
        Matcher matcher = pattern.matcher(decimalNum);
        return matcher.matches();
    }

    private static String enterHexNumber() {
        Scanner sc = new Scanner(System.in);
        String hexNum;
        //Loop until enter right Binary Format Number
        while (true) {
            System.out.print("Enter the input value: ");
            hexNum = sc.nextLine();
            if (hexNum.isEmpty()) {
                System.out.println("You must be enter Hexadecimal Format Number!!!");
            } else {
                if (checkHexNumber(hexNum) == true) {
                    return hexNum;
                } else {
                    System.out.println("Your number entered not right format");
                }
            }
        }
    }

    private static boolean checkHexNumber(String hexNum) {
        Pattern pattern = Pattern.compile("^[0-9a-fA-F]+$");
        Matcher matcher = pattern.matcher(hexNum);
        return matcher.matches();
    }
}
