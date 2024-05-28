/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package change_base_fn;

import java.math.BigInteger;

/**
 *
 * @author hoang.dat
 */
public class Convert {

    public String convertNumber(int baseInput, int baseOutput, String inputValue) {
        String outputValue = null;
        if (baseInput == baseOutput) {
            outputValue = inputValue;
        } else if (baseInput == 2) {
            switch (baseOutput) {
                case 10: {
                    outputValue = binaryToDecimal(inputValue);
                    break;
                }
                case 16: {
                    outputValue = binaryToHex(inputValue);
                    break;
                }
            }
        } else if (baseInput == 10) {
            switch (baseOutput) {
                case 2: {
                    outputValue = decimalToBinary(inputValue);
                    break;
                }
                case 16: {
                    outputValue = decimalToHex(inputValue);
                    break;
                }
            }
        } else if (baseInput == 16) {
            switch (baseOutput) {
                case 2: {
                    outputValue = hexToBinary(inputValue);
                    break;
                }
                case 10: {
                    outputValue = hexToDecimal(inputValue);
                    break;
                }
            }
        }
        return outputValue = outputValue.toUpperCase();
    }

    public String binaryToDecimal(String inputValue) {
        BigInteger valueDec = BigInteger.ZERO; //To save value after convert
        //Take element multi with reverse index
        int startIdx = inputValue.length() - 1; //Start idx is length --> 0
        //Traversal inputValue string to multi each element
        for (int i = 0; i < inputValue.length(); i++) {
            //If matches '1' --> calc and add to value
            if (inputValue.charAt(i) == '1') {
                valueDec = valueDec.add((BigInteger.valueOf(2).pow(startIdx)));
            }
            startIdx--; //Decrease index
        }

        return valueDec.toString();
    }

    public String decimalToHex(String inputValue) {
        String valueHex = "";
        BigInteger inputDec = new BigInteger(inputValue);
        // Div until divisor = 0;
        // Take remainder into String from last --> 0
        while (inputDec.compareTo(new BigInteger("0")) != 0) {
            BigInteger[] divAndRemain = inputDec.divideAndRemainder(new BigInteger("16"));
            inputDec = divAndRemain[0]; // update quotient
            BigInteger remainder = divAndRemain[1]; // update remainder
            valueHex = insertRemainderIntoHexValue(remainder, valueHex);
        }
        return valueHex;
    }

    public String insertRemainderIntoHexValue(BigInteger remainder, String valueHex) {
        // If remainder between [0, 9] --> insert directly 
        if (remainder.compareTo(BigInteger.ZERO) >= 0 && remainder.compareTo(new BigInteger("9")) <= 0) {
            valueHex = remainder.toString() + valueHex;
            return valueHex;
        }
        //If remainder between [10, 15] --> convert to right format and insert
        if (remainder.compareTo(new BigInteger("10")) >= 0 && remainder.compareTo(new BigInteger("15")) <= 0) {
            char hexChar = (char) ('a' + remainder.intValue() - 10);
            valueHex = hexChar + valueHex;
        }
        return valueHex;
    }

    public String binaryToHex(String inputValue) {
        String decimalNum = binaryToDecimal(inputValue);
        return decimalToHex(decimalNum);
    }

    public String decimalToBinary(String inputValue) {
        boolean isNegative = inputValue.startsWith("-");
        String value = isNegative ? inputValue.substring(1) : inputValue;
        
        String valueBinary = "";
        BigInteger inputDec = new BigInteger(value);
        // Div until divisor = 0;
        // Take remainder into String from last --> 0
        while (inputDec.compareTo(new BigInteger("0")) != 0) {
            BigInteger[] divAndRemain = inputDec.divideAndRemainder(new BigInteger("2"));
            inputDec = divAndRemain[0];
            BigInteger remainder = divAndRemain[1];
            valueBinary = remainder + valueBinary;
        }
        
        if(valueBinary.isEmpty()){
            valueBinary = "0";
        }
        if(isNegative){
            valueBinary = invertBits(valueBinary);
            valueBinary = addBinary(valueBinary,"1");
        }
        
        return valueBinary;
    }
    
    public String invertBits(String value){
        StringBuilder invert = new StringBuilder();
        char[] bits = value.toCharArray();
        for(int i = 0; i < value.length(); i++){
            invert.append(bits[i] == '0' ? '1' : '0');
        }
        return invert.toString();
    }
    
    public String addBinary(String bin1, String bin2){
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int index1 = bin1.length() - 1;
        int index2 = bin2.length() - 1;
        
        for(int i = 0; i < bin1.length(); i++){
            int bit1 = index1 >= 0 ? bin1.charAt(index1--) - '0' : 0;
            int bit2 = index2 >= 0 ? bin2.charAt(index2--) - '0' : 0;
            int sum = bit1 + bit2 + carry;
            result.insert(0, sum % 2);
            carry = sum / 2;
        }
        if(carry > 0){
            result.insert(0, carry);
        }
        result.insert(0,1);
        return result.toString();
    }

    public String hexToDecimal(String inputValue) {
        BigInteger valueDec = BigInteger.ZERO; //To save value after convert
        //Take element multi with reverse index
        int startIdx = inputValue.length() - 1; //Start idx is length --> 0
        //Traversal inputValue string to multi each element with 16
        for (int i = 0; i < inputValue.length(); i++) {
            int element = inputValue.charAt(i) - '0';
            // process [0, 9] first and [a,f] last
            // if [0, 9] --> calc directly
            // else convert element to numeric data [10, 15] to calc
            BigInteger powerOfIdx = BigInteger.valueOf(16).pow(startIdx);
            if (element >= 0 && element <= 9) {
                valueDec = valueDec.add(BigInteger.valueOf(element).multiply(powerOfIdx));
            } else {
                int valueOfElement = (10 + (inputValue.charAt(i) - 'a'));
                valueDec = valueDec.add(BigInteger.valueOf(valueOfElement).multiply(powerOfIdx));
            }
            startIdx--; //Decrease index
        }
        return valueDec.toString();
    }

    public String hexToBinary(String inputValue) {
        String numDec = hexToDecimal(inputValue);
        return decimalToBinary(numDec);
    }
}
