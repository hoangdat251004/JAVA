/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loggggginmd5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import javax.xml.bind.DatatypeConverter;
import java.util.Calendar ; // Add this import statement

/**
 *
 * @author hoang.dat
 */
public class Manager {

    public static Scanner in = new Scanner(System.in);
    public static String EMAIL_VALID = "^[0-9A-Za-z+_.%]+@[0-9A-Za-z.-]+\\.[A-Za-z]{2,4}$";

    public static void printMenu(boolean isLogin) {
        if (isLogin) {
            System.out.println("1. Logout");
            System.out.println("2. Exit");
        } else {
            System.out.println("1. Add user");
            System.out.println("2. Login");
            System.out.println("3. Exit");
        }
    }

    public static int checkInputChoice(boolean isLogin) {
        int maxChoice = isLogin ? 2 : 3;
        while (true) {
            try {
                System.out.print("Enter your choice: ");
                int choice = Integer.parseInt(in.nextLine());
                if (choice >= 1 && choice <= maxChoice) {
                    return choice;
                } else {
                    System.out.println("Must be in range 1-" + maxChoice);
                }
            } catch (Exception e) {
                System.err.println("Enter again.");
            }
        }
    }

    

    public static String checkInputDate(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                String input = in.nextLine().trim();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Date date = sdf.parse(input);

                // Check if the entered date is today or in the future
                Date today = Calendar.getInstance().getTime();
                if (date.equals(today) || date.after(today)) {
                    System.err.println("Date must be in the past. Re-input.");
                    continue;
                }

                if (input.equalsIgnoreCase(sdf.format(date))) {
                    return input;
                } else {
                    System.err.println("Re-input");
                }
            } catch (Exception ex) {
                System.err.println("Re-input");
            }
        }
    }

    public static String checkInputPhone(String msg) {
        while (true) {
            System.out.print(msg);
            String result = in.nextLine().trim();
            if (result.matches("^[0-9]{10}$")) {
                return result;
            } else {
                System.err.println("Re-input");
            }
        }
    }

    public static String checkInputEmail(String msg) {
        while (true) {
            System.out.print(msg);
            String result = in.nextLine().trim();
            if (!result.isEmpty() && result.matches(EMAIL_VALID)) {
                return result;
            } else {
                System.err.println("Re-input");
            }
        }
    }

    public static String checkInputString(String msg) {
        while (true) {
            System.out.print(msg);
            String result = in.nextLine().trim();
            if (result.length() == 0) {
                System.err.println("Not empty");
            } else {
                return result;
            }
        }
    }

//    public static String checkInputUsername(ArrayList<Account> la, String msg) {
//        while (true) {
//            String result = checkInputString(msg);
//            for (int i = 0; i < la.size(); i++) {
//                if (result.equalsIgnoreCase(la.get(i).getUsername())) {
//                    System.err.println("Username exist!!!");
//                    break;
//                }
//            }
//            return result;
//        }
//    }
    public static String checkInputUsername(ArrayList<Account> la, String msg) {
        while (true) {
            String result = checkInputString(msg);
            boolean exists = false;
            for (int i = 0; i < la.size(); i++) {
                if (result.equalsIgnoreCase(la.get(i).getUsername())) {
                    System.err.println("Username exists!!!");
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                return result;
            }
        }
    }

    private static String MD5Encryption(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            return DatatypeConverter.printHexBinary(md.digest()).toLowerCase();
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static void addAccount(ArrayList<Account> la) {

        String username = checkInputUsername(la, "Enter Username: ");
        String password = checkInputString("Enter Password: ");
        String name = checkInputString("Enter Name: ");
        String phone = checkInputPhone("Enter Phone: ");
        String email = checkInputEmail("Enter email: ");
        String address = checkInputString("Enter Address: ");
        String dateOfBirth = checkInputDate("Enter Date Of Birth: ");

        la.add(new Account(username, MD5Encryption(password), name, phone, email, address, dateOfBirth));
        System.out.println("Add success!!!");
    }

    public static boolean login(ArrayList<Account> la) {
        if (la.isEmpty()) {
            System.err.println("Accout empty.");
            return false;
        }
        String username = checkInputString("Enter username: ");
        String password = checkInputString("Enter Password: ");
        Account accoutLogin = findAccount(la, username, password);
        if (accoutLogin != null) {
            System.out.println("Wellcome");
            System.out.print("Hi " + accoutLogin.getUsername() + ", do you want chage password now? Y/N: ");
            changePassword(accoutLogin);
            return true;
        } else {
            System.err.println("Invalid username or password.");
            return false;
        }
    }

    public static Account findAccount(ArrayList<Account> la, String username, String password) {
        for (int i = 0; i < la.size(); i++) {
            if (username.equalsIgnoreCase(la.get(i).getUsername())) {
                if (MD5Encryption(password).equalsIgnoreCase(la.get(i).getPassword())) {
                    return la.get(i);
                } else {
                    return null;
                }
            }
        }
        return null;
    }

    public static void changePassword(Account accoutLogin) {
        String choice;
        while (true) {
            choice = in.nextLine().trim();
            if (choice.length() == 0) {
                System.err.println("Not empty!!!");
            } else if (choice.length() == 1 && choice.equalsIgnoreCase("Y") || choice.equalsIgnoreCase("N")) {
                break;
            } else {
                System.err.print("Enter again:");
            }
        }
        if (choice.equalsIgnoreCase("Y")) {

            //////////////////
            int wrong = 0;
            while (wrong < 3) {
                String oldPassword = checkInputString("Old password: ");
                String newPassword = checkInputString("New password: ");
                String renewPassword = checkInputString("Renew password: ");

                boolean oldPasswordCorrect = MD5Encryption(oldPassword).equalsIgnoreCase(accoutLogin.getPassword());
                boolean newPasswordsMatch = newPassword.equalsIgnoreCase(renewPassword);

                if (!oldPasswordCorrect) {
                    System.err.println("Old password incorrect.");
                }

                if (!newPasswordsMatch) {
                    System.err.println("New password and Renew password not the same.");
                }

                if (oldPasswordCorrect && newPasswordsMatch) {
                    accoutLogin.setPassword(MD5Encryption(newPassword));
                    System.out.println("Change password success");
                    break; // Exit the loop since the password was changed successfully
                } else {
                    wrong++; // Increment the wrong attempt counter
                    if (wrong >= 3) {
                        System.err.println("Too many failed attempts. Exiting.");
                        break; // Exit the loop since the maximum number of attempts was reached
                    } else {
                        System.out.println("Please try again.");
                    }
                }
            }

            //////////////////
//            String oldPassword = checkInputString("Old password: ");
//            String newPassword = checkInputString("New password: ");
//            String renewPassword = checkInputString("Renew password: ");
//            if (MD5Encryption(oldPassword).equalsIgnoreCase(accoutLogin.getPassword()) == false) {
//                System.err.println("Old password incorrect.");
//            }
//            if (newPassword.equalsIgnoreCase(renewPassword) == false) {
//                System.err.println("New password and Renew password not the same.");
//            }
//            if (MD5Encryption(oldPassword).equalsIgnoreCase(accoutLogin.getPassword()) == true && newPassword.equalsIgnoreCase(renewPassword) == true) {
//                accoutLogin.setPassword(MD5Encryption(newPassword));
//                System.out.println("Change password success");
//            }
        }
    }
}
