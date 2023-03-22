package com.kodilla.bank;

import com.kodilla.bank.homework.CashMachine;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CashMachineTestSuite {

    @Test
    public void shouldHaveZeroLengthWhenNoTransaction() {
        CashMachine cashMachine = new CashMachine();
        double[] transactionTable = cashMachine.getAllTransactions();
        assertEquals(0, transactionTable.length);
    }

    @Test
    public void shouldAddTwoTransaction() {
        CashMachine cashMachine = new CashMachine();
        cashMachine.addTransaction(4564.63);
        cashMachine.addTransaction( -223.56);

        double[] transactionTable = cashMachine.getAllTransactions();
        assertEquals(2, transactionTable.length);
        assertEquals(4564.63, transactionTable[0]);
        assertEquals(-223.56, transactionTable[1]);
    }

    @Test
    public void shouldReturnCorrectCashMachineBalance(){
        CashMachine cashMachine = new CashMachine();
        cashMachine.addTransaction(200.63);
        cashMachine.addTransaction( -3.63);
        cashMachine.addTransaction( 39.99);

        double currentBalance = cashMachine.getCashMachineBalance();
        assertEquals(236.99, currentBalance);
    }

    @Test
    public void shouldReturnNegativeCashMachineBalanceIfPaidOutTransactionExceedPaidIn(){
        CashMachine cashMachine = new CashMachine();
        cashMachine.addTransaction(200.63);
        cashMachine.addTransaction( -300.63);
        cashMachine.addTransaction( 39.99);

        double currentBalance = cashMachine.getCashMachineBalance();
        assertEquals(-60.01, currentBalance);
    }

    @Test
    public void shouldReturnCorrectTransactionCount(){
        CashMachine cashMachine = new CashMachine();
        cashMachine.addTransaction(200.63);
        cashMachine.addTransaction( -3.63);
        cashMachine.addTransaction( 39.99);
        cashMachine.addTransaction( -50.99);

        int transactionsCount = cashMachine.getCashMachineTransactionsCount();
        assertEquals(4, transactionsCount);
    }

    @Test
    public void shouldReturnCorrectPaidInTransactionCount(){
        CashMachine cashMachine = new CashMachine();
        cashMachine.addTransaction(200.63);
        cashMachine.addTransaction( -3.63);
        cashMachine.addTransaction( 39.99);
        cashMachine.addTransaction( -50.99);

        int paidInTransactionsCount = cashMachine.getCashMachinePaidInTransactionsCount();
        assertEquals(2, paidInTransactionsCount);
    }

    @Test
    public void shouldReturnCorrectPaidOutTransactionCount(){
        CashMachine cashMachine = new CashMachine();
        cashMachine.addTransaction(200.63);
        cashMachine.addTransaction( -3.63);
        cashMachine.addTransaction( 39.99);
        cashMachine.addTransaction( -50.99);
        cashMachine.addTransaction( -50.99);
        cashMachine.addTransaction( -50.99);

        int paidOutTransactionsCount = cashMachine.getCashMachinePaidOutTransactionsCount();
        assertEquals(4, paidOutTransactionsCount);
    }

    @Test
    public void shouldReturnCorrectAverageForPaidOutTransaction(){
        CashMachine cashMachine = new CashMachine();
        cashMachine.addTransaction(200.63);
        cashMachine.addTransaction( -25.00);
        cashMachine.addTransaction( 39.99);
        cashMachine.addTransaction( -50.00);
        cashMachine.addTransaction( -15.00);
        cashMachine.addTransaction( -10.00);

        double AverageForPaidOutTransactions = cashMachine.getAverageForPaidOutTransactions();
        assertEquals(-25, AverageForPaidOutTransactions, 0.005);
    }

    @Test
    public void shouldReturnCorrectAverageForPaidInTransaction(){
        CashMachine cashMachine = new CashMachine();
        cashMachine.addTransaction(200.63);
        cashMachine.addTransaction( -25.00);
        cashMachine.addTransaction( 39.99);
        cashMachine.addTransaction( -50.00);
        cashMachine.addTransaction( 15.00);
        cashMachine.addTransaction( 10.00);

        double AverageForPaidInTransactions = cashMachine.getAverageForPaidInTransactions();
        assertEquals(66.405, AverageForPaidInTransactions);
    }
}