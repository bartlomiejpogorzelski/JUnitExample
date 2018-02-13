package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class BankAccountTest {
    @Test
    public void deposit() throws Exception {
        BankAccount account=new BankAccount("Tim", "Buchalka", 1000.00);
        double balance = account.deposit(200.00, true);
        assertEquals(1200.00, balance, 0);
    }

    @Test
    public void withDraw() throws Exception {
        fail("This test has yet to be implemented");
    }

    @Test
    public void getBalance() throws Exception {
        BankAccount account=new BankAccount("Tim", "Buchalka", 1000.00);
        account.deposit(200.00, true);
        assertEquals(1200.00, account.getBalance(),0);
    }

}