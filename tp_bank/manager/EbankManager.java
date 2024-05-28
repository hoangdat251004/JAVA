
package controller;

import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;

public class EbankManager {

    static GetData gd = new GetData();
    static Display dp = new Display();
    static Locale locale;
    static ResourceBundle bundle;

    public static void inputInformation(int choice) {
        if (choice == 1) {
            setLocale(new Locale.Builder().setLanguage("Vi").setRegion("VN").build());
            bundle = ResourceBundle.getBundle("language.Vi", locale);
        } else {
            setLocale(new Locale.Builder().setLanguage("En").setRegion("US").build());
            bundle = ResourceBundle.getBundle("language/En", locale);
        }

        while (true) {
            String accountNumber = gd.getString(bundle.getString("account"));
            String msg = checkAccountNumber(accountNumber);
            if (msg.isEmpty()) {
                break;
            }
            dp.displayErr(msg);
        }

        while (true) {
            String password = gd.getString(bundle.getString("password"));
            String msg = checkPassword(password);
            if (msg.isEmpty()) {
                break;
            }
            dp.displayErr(msg);
        }

        while (true) {
            String captchaGenerate = generateCaptcha();
            System.out.println(bundle.getString("captcha") + captchaGenerate);
            String captchaInput = gd.getString(bundle.getString("captcha"));
            String msg = checkCaptcha(captchaInput, captchaGenerate);
            if (msg.isEmpty()) {
                break;
            }
            dp.displayErr(msg);
        }
    }

    public static void setLocale(Locale locale) {
        EbankController.locale = locale;
    }

    public static String checkAccountNumber(String accountNumber) {
        if (accountNumber.matches("^[0-9]{10}$")) {
            return "";
        }
        return bundle.getString("check.account");
    }

    public static String checkPassword(String password) {
        if (password.matches("^[0-9a-zA-Z]{8,31}$")
                && password.matches(".*[a-zA-Z].*")
                && password.matches(".*[0-9].*")) {
            return "";
        }
        return bundle.getString("wrong.password");
    }

    public static String checkCaptcha(String captchaInput, String captchaGenerate) {
        if (captchaGenerate.equals(captchaInput)) {
            return "";
        }
        return bundle.getString("wrong.captcha");
    }

    public static String generateCaptcha() {
        String s = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random r = new Random();
        String captcha = "";
        for (int i = 0; i < 5; i++) {
            int index = r.nextInt(s.length());
            captcha = captcha + s.charAt(index);
            s = s.substring(0, index) + s.substring(index + 1);
        }
        return captcha;
    }
}
