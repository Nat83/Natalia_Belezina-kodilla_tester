package com.kodilla.bank.homework;

public class CashMachine {
    private double[] transactionTable;
    private int size;

    public CashMachine() {
        this.size = 0;
        this.transactionTable = new double[0];
    }

    public void addTransaction(double transactionValue) {

        double currentBalance = this.getCashMachineBalance();
        boolean isEnoughFunds = (currentBalance + transactionValue) >= 0;
        if (isEnoughFunds) {
            this.size++;
            double[] newTab = new double[this.size];
            System.arraycopy(transactionTable, 0, newTab, 0, transactionTable.length);
            newTab[this.size - 1] = transactionValue;
            this.transactionTable = newTab;
        } else {
            System.out.println("Not enough funds in cash machine");
        }
    }

    public double[] getAllTransactions() {
        return transactionTable;
    }

    public double getCashMachineBalance() {
        double balance = 0;
        for (int i = 0; i < this.size; i++) {
            balance = balance + transactionTable[i];
        }
        return balance;
    }

    public int getCashMachineTransactionsCount() {
        return this.size;
    }

    public int getCashMachinePaidInTransactionsCount() {

        int count = 0;
        for (int i = 0; i < this.size; i++) {
            if (transactionTable[i] > 0)
                count++;
        }
        return count;
    }

    public int getCashMachinePaidOutTransactionsCount() {

        int count = 0;
        for (int i = 0; i < this.size; i++) {
            if (transactionTable[i] < 0)
                count++;
        }
        return count;
    }

    public double getAverageForPaidOutTransactions() {

        double sumPaidOut = 0;
        for (int i = 0; i < this.size; i++) {
            if (transactionTable[i] < 0)
                sumPaidOut = (sumPaidOut + transactionTable[i]);
        }
        return sumPaidOut / getCashMachinePaidOutTransactionsCount();
    }

    public double getAverageForPaidInTransactions() {

        double sumPaidIn = 0;
        for (int i = 0; i < this.size; i++) {
            if (transactionTable[i] > 0)
                sumPaidIn = (sumPaidIn + transactionTable[i]);
        }
        return sumPaidIn / getCashMachinePaidInTransactionsCount();
    }
}