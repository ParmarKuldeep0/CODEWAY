package CODEWAY.Task_01.task_03;

public class Atm {
    private BankAccount Account;
    public Atm(BankAccount Account){
        this.Account = Account;
    }

    public void  deposits(double amount){
        Account.deposits(amount);
    }
    public boolean withdraw(double amount){
        return  Account.withdraw(amount);
    }

    public  void transfer(double amount, BankAccount recipient){
        Account.transfer(amount,recipient);
    }
    public double checkBalance(){
        return Account.getBalance();
    }

    public boolean validatePin(int enteredPin){return Account.validatePin(enteredPin);}
}

