package controller;

import controller.EbankManager;

public class Ebank {

    public static void main(String[] args) {
        while (true) {
            Display.menu();
            int choice = GetData.getInt();
            switch (choice) {
                case 1: case 2:
                    EbankManager.inputInformation(choice);
                    break;
                case 3:
                    System.exit(0);
            }
        }
    }
}
