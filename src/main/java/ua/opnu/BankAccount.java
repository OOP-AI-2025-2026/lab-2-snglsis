package ua.opnu;

public class BankAccount {
    String name;
    double balance;
    double transactionFee = 0;

    void deposit(double amount) {
        // TODO: modify method body
        if (amount > 0) {
            balance += amount;
        }
    }

    double getBalance() {
        return this.balance;
    }

    boolean withdraw(double amount) {
        // TODO: modify method body
        if (amount > 0 && balance >= amount + transactionFee) {
            balance -= (amount + transactionFee);
            return true;
        }
        return false;
    }

    boolean transfer(BankAccount receiver, double amount) {
        // TODO: modify method body
        if (receiver == null || amount <= 0) {
            return false;
    }
        if (balance >= amount + transactionFee) {
            balance -= (amount + transactionFee); // списываем у отправителя
            receiver.deposit(amount);             // пополняем у получателя
            return true;
        }
        return false;
    }
}