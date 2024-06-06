
package controller;

import java.util.List;

public class Display {

    public static void menu() {
        System.out.println("====== Login Program ======");
        System.out.println("1. Vietnamese");
        System.out.println("2. English");
        System.out.println("3. Print valid accounts");
        System.out.println("4. Exit");
    }
    public static void displayErr(String err) {
        System.err.println(err);
    }
    public static void printValidAccounts(List<Account> validAccounts) {
        if (validAccounts.isEmpty()) {
            System.out.println("No valid accounts to display.");
        } else {
            System.out.println("ACCOUNT                 PASSWORD");
            for (Account account : validAccounts) {
                System.out.println(account);
            }
        }
    }
}
