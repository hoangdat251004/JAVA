/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hoang.dat
 */
// Add this new class in a separate file or within EbankManager file as a static class.
package controller;

public class Account {

    private String accountNumber;
    private String password;

    public Account(String accountNumber, String password) {
        this.accountNumber = accountNumber;
        this.password = password;
    }

    @Override
    public String toString() {
        return accountNumber +"\t|\t" + password;
    }
}
