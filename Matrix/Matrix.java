package matrix;

import java.io.IOException;
import java.util.Scanner;

public class Matrix {

    public static void main(String[] args) {

        while (true) {
            int choice = Manager.getChoice();
            switch (choice) {
                case 1:
                    Manager.additionMatrix(choice);
                    break;
                case 2:
                    Manager.subtractionMatrix(choice);
                    break;
                case 3:
                    Manager.multiplicationMatrix(choice);
                    break;
                case 4:
                    return;
            }
        }
    }
}

