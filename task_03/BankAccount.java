package CODEWAY.Task_01.task_03;

public class BankAccount {
    private double balance;
    private  int pin;
    public BankAccount(double initialBalance, int pin){
        this.balance = initialBalance;
        this.pin =pin;
    }

    public double getBalance() {
        return balance;
    }

    public void deposits(double amount){
        balance +=amount;
    }
    public boolean withdraw(double amount){
        if(balance < amount){
            return false;
        }
        balance -=amount;
        return true;
    }

    public void transfer(double amount, BankAccount recipient){
        if (withdraw(amount)){
            recipient.deposits(amount);
        }

    }
    public boolean validatePin(int enteredPin){
        return pin ==enteredPin;
    }
}


