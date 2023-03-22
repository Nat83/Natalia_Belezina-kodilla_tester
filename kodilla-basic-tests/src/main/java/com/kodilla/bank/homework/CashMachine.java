package com.kodilla.bank.homework;

public class CashMachine {
    private double[] transactionTable;
    private int size;

    public CashMachine() {
        this.size = 0;
        this.transactionTable = new double[0];
    }

    public void addTransaction(double transactionValue) {
        this.size++;
        double[] newTab = new double[this.size];
        System.arraycopy(transactionTable, 0, newTab, 0, transactionTable.length);
        newTab[this.size - 1] = transactionValue;
        this.transactionTable = newTab;
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
        int count = 0;
        for (int i = 0; i < this.size; i++) {
            count++;
        }
        return count;
    }
    public int getCashMachinePaidInTransactionsCount() {
        int count = 0;
        for (int i = 0; i < this.size; i++) {
            if(transactionTable[i] > 0)
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

        double averagePaidOut = 0;
        for (int i = 0; i < this.size; i++) {
            if (transactionTable[i] < 0)
                averagePaidOut = (averagePaidOut + transactionTable[i]);
        }
        return averagePaidOut/getCashMachinePaidOutTransactionsCount();
    }
    public double getAverageForPaidInTransactions() {

        double averagePaidIn = 0;
        for (int i = 0; i < this.size; i++) {
            if (transactionTable[i] > 0)
                averagePaidIn = (averagePaidIn + transactionTable[i]);
        }
        return averagePaidIn/getCashMachinePaidInTransactionsCount();
    }
}