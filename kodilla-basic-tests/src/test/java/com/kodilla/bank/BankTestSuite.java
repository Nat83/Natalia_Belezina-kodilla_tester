package com.kodilla.bank;

import com.kodilla.bank.homework.Bank;
import com.kodilla.bank.homework.CashMachine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankTestSuite {
    Bank bank;
    CashMachine mBank1;
    CashMachine mBank2;
    CashMachine mBank3;

    @BeforeEach
    public void setUp(){
        bank = new Bank();
        mBank1 = new CashMachine();
        mBank2 = new CashMachine();
        mBank3 = new CashMachine();
    }

    @Test
    public void shouldDisplayTotalBalanceZeroIfNoTransactionAdded(){
        bank.addCashMachine(mBank1);
        bank.addCashMachine(mBank2);
        bank.addCashMachine(mBank3);

        double totalBalance = bank.getTotalCashMachineBalance();
        assertEquals(0, totalBalance);
    }

    @Test
    public void shouldDisplayCorrectTotalBalance(){
        bank.addCashMachine(mBank1);
        bank.addCashMachine(mBank2);
        bank.addCashMachine(mBank3);

        //balance 218,12
        mBank1.addTransaction(532.23);
        mBank1.addTransaction(-345.00);
        mBank1.addTransaction(78.87);
        mBank1.addTransaction(-47.98);

        //balance 323,72
        mBank2.addTransaction(67.25);
        mBank2.addTransaction(-3.00);
        mBank2.addTransaction(345.90);
        mBank2.addTransaction(-86.43);

        //balance 138,74
        mBank3.addTransaction(90.11);
        mBank3.addTransaction(-5.05);
        mBank3.addTransaction(65.02);
        mBank3.addTransaction(-11.34);

        double totalBalance = bank.getTotalCashMachineBalance();
        assertEquals(680.58, totalBalance);
    }

    @Test
    public void shouldDisplayTotalCountOfPaidInTransactions(){
        bank.addCashMachine(mBank1);
        bank.addCashMachine(mBank2);
        bank.addCashMachine(mBank3);

        mBank1.addTransaction(532.23);
        mBank1.addTransaction(-345.00);
        mBank1.addTransaction(78.87);
        mBank1.addTransaction(-47.98);

        mBank2.addTransaction(67.25);
        mBank2.addTransaction(-3.00);
        mBank2.addTransaction(345.90);
        mBank2.addTransaction(-86.43);

        mBank3.addTransaction(90.11);
        mBank3.addTransaction(-5.05);
        mBank3.addTransaction(65.02);
        mBank3.addTransaction(-11.34);

        int totalCountOfPaidInTransactions = bank.getTotalCountInPaidOutTransactions();
        assertEquals(6, totalCountOfPaidInTransactions);
    }

    @Test
    public void shouldDisplayCorrectTotalCountOfPaidOutTransactions(){
        bank.addCashMachine(mBank1);
        bank.addCashMachine(mBank2);
        bank.addCashMachine(mBank3);

        mBank1.addTransaction(532.23);
        mBank1.addTransaction(-345.00);
        mBank1.addTransaction(-35.00);

        mBank2.addTransaction(67.25);
        mBank2.addTransaction(-3.00);

        mBank3.addTransaction(90.11);
        mBank3.addTransaction(-5.05);

        int totalCountOfPaidOutTransactions = bank.getTotalCountOfPaidOutTransactions();
        assertEquals(4, totalCountOfPaidOutTransactions);
    }

    @Test
    public void shouldDisplayCorrectTotalAverageForPaidInTransactions(){
        bank.addCashMachine(mBank1);
        bank.addCashMachine(mBank2);
        bank.addCashMachine(mBank3);

        //Average for paid in transaction is 305,55
        mBank1.addTransaction(532.23);
        mBank1.addTransaction(-345.00);
        mBank1.addTransaction(78.87);
        mBank1.addTransaction(-47.98);

        //Average for paid in transaction is 206,575
        mBank2.addTransaction(67.25);
        mBank2.addTransaction(-3.00);
        mBank2.addTransaction(345.90);
        mBank2.addTransaction(-86.43);

        //Average for paid in transaction is 77,565
        mBank3.addTransaction(90.11);
        mBank3.addTransaction(-5.05);
        mBank3.addTransaction(65.02);
        mBank3.addTransaction(-11.34);

        double totalAverageForPaidIn = bank.getAverageForTotalPaidInTransactions();
        assertEquals(196.56, totalAverageForPaidIn, 0.004);
    }

    @Test
    public void shouldDisplayCorrectTotalAverageForPaidOutTransactions(){
        bank.addCashMachine(mBank1);
        bank.addCashMachine(mBank2);
        bank.addCashMachine(mBank3);

        //Average for paid in transaction is -196,49
        mBank1.addTransaction(532.23);
        mBank1.addTransaction(-345.00);
        mBank1.addTransaction(78.87);
        mBank1.addTransaction(-47.98);

        //Average for paid in transaction is -44,715
        mBank2.addTransaction(67.25);
        mBank2.addTransaction(-3.00);
        mBank2.addTransaction(345.90);
        mBank2.addTransaction(-86.43);

        //Average for paid in transaction is -8,195
        mBank3.addTransaction(90.11);
        mBank3.addTransaction(-5.05);
        mBank3.addTransaction(65.02);
        mBank3.addTransaction(-11.34);

        double totalAverageForPaidOut = bank.getAverageForTotalPaidOutTransactions();
        assertEquals(-83.13, totalAverageForPaidOut, 0.004);
    }
}
