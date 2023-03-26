package com.kodilla.bank.homework;

public class Bank {
    private CashMachine[] cashMachineTable;
    private int size;

    public Bank() {
        this.cashMachineTable = new CashMachine[0];
        this.size = 0;
    }

    public void addCashMachine(CashMachine cashMachine) {
        this.size++;
        CashMachine[] newTab = new CashMachine[this.size];
        System.arraycopy(cashMachineTable, 0, newTab, 0, cashMachineTable.length);
        newTab[this.size - 1] = cashMachine;
        this.cashMachineTable = newTab;
    }

    public double getTotalCashMachineBalance() {
        double totalBalance = 0;

        for (int i = 0; i < this.size; i++) {
            totalBalance = totalBalance + cashMachineTable[i].getCashMachineBalance();
        }
        return totalBalance;
    }

    public int getTotalCountOfPaidOutTransactions() {
        int countOfPaidOut = 0;
        for (int i = 0; i < this.size; i++) {
            countOfPaidOut = countOfPaidOut + cashMachineTable[i].getCashMachinePaidOutTransactionsCount();
        }
        return countOfPaidOut;
    }

    public int getTotalCountInPaidOutTransactions() {
        int countInPaidOut = 0;
        for (int i = 0; i < this.size; i++) {
            countInPaidOut = countInPaidOut + cashMachineTable[i].getCashMachinePaidOutTransactionsCount();
        }
        return countInPaidOut;
    }

    public double getAverageForTotalPaidOutTransactions() {
        double TotalForPaidOut = 0;
        for (int i = 0; i < this.size; i++) {
            TotalForPaidOut = TotalForPaidOut + cashMachineTable[i].getAverageForPaidOutTransactions();
        }
        return TotalForPaidOut / this.size;
    }

    public double getAverageForTotalPaidInTransactions() {
        double totalForPaidIn = 0;
        for (int i = 0; i < this.size; i++) {
            totalForPaidIn = totalForPaidIn + cashMachineTable[i].getAverageForPaidInTransactions();
        }
        return totalForPaidIn / this.size;
    }
}