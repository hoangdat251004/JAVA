package controller;

import controller.EbankController;
import controller.EbankController;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author admin
 */
public class Ebank {

    public static void main(String[] args) {
        while (true) {
            Display.menu();
            int choice = GetData.getInt();
            switch (choice) {
                case 1: case 2:
                    EbankController.inputInformation(choice);
                    break;
                case 3:
                    System.exit(0);
            }
        }
    }
}
