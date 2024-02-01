package CODEWAY.Task_01.task_03;

import javax.swing.*;

public class main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                BankAccount userAccount = new BankAccount(1000,1234);
                Atm atm = new Atm(userAccount);
                new Atmapp(atm);
            }
        });
    }
}
