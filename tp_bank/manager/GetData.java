
package controller;

import java.util.Scanner;

public class GetData {

    public static  Scanner sc = new Scanner(System.in);

    public static int getInt() {
        while (true) {
            try {
                System.out.print("Enter your choice: ");
                int choice = Integer.parseInt(sc.nextLine());
                if (1 <= choice && choice <= 3) {
                    return choice;
                }
                System.err.println("Must from: 1 -> 3");
            } catch (NumberFormatException ex) {
                System.err.println("Wrong format");
            }
        }
    }

    public static String getString(String msg) {
        while (true) {
            System.out.print(msg);
            String s = sc.nextLine();
            if (!s.isEmpty()) {
                return s;
            }
            System.err.println("Empty string is not allowed");
        }
    }
}
