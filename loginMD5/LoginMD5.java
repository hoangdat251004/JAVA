package loggggginmd5;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import javax.xml.bind.DatatypeConverter;
import loggggginmd5.Account;

public class LoginMD5 {

    public static void main(String[] args) throws IOException {
        ArrayList<Account> la = new ArrayList<>();
        boolean isLogin = false;
        while (true) {
            Manager.printMenu(isLogin);
            int choice = Manager.checkInputChoice(isLogin);
            if (isLogin) {
                switch (choice) {
                    case 1:
                        isLogin = false;
                        System.out.println("Logout successful.");
                        break;
                    case 2:
                        System.exit(0);
                        break;
                }
            } else {
                switch (choice) {
                    case 1:
                        Manager.addAccount(la);
                        break;
                    case 2:
                        isLogin = Manager.login(la);
                        break;
                    case 3:
                        System.exit(0);
                        break;
                }
            }
        }
    }
}
