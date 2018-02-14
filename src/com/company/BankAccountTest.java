package com.company;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class BankAccountTest {
    private static int count=0;
    @org.junit.Before
    public void setup(){
    System.out.println("Running test... " );
    }
    @org.junit.BeforeClass
    public static void beforeClass(){
    System.out.println("Before classes "+ count++);
    }
    @org.junit.AfterClass
    public static void afterClass(){
        System.out.println("After classes "+ count++);
    }
    @org.junit.After
    public void after(){
        System.out.println("After: "+ count++);
    }
    @Test
    public void deposit() throws Exception {
        BankAccount account=new BankAccount("Tim", "Buchalka", 1000.00);
        double balance = account.deposit(200.00, true);
        assertEquals(1200.00, balance, 0);
    }

    @Test
    public void withDraw_Branch() throws Exception {
        BankAccount account=new BankAccount("Tim", "Buchalka", 1000.00);
        account.withDraw(200.00, true);
        assertEquals(800.00, account.getBalance(),0);
    }
    @Test(expected=IllegalArgumentException.class)
    public void withDraw_NotBranch() throws Exception {
        BankAccount account=new BankAccount("Tim", "Buchalka", 1000.00);
        account.withDraw(600.00, false);
        assertEquals(400.00, account.getBalance(),0);
    }
    @Test
    public void getBalance() throws Exception {
        BankAccount account=new BankAccount("Tim", "Buchalka", 1000.00);
        account.deposit(200.00, true);
        assertEquals(1200.00, account.getBalance(),0);
    }

    @Test
    public void isChecking(){
        BankAccount account=new BankAccount("Tim", "Buchalka", 1000.00, BankAccount.CHECKING);
        assertTrue("The account is not checking", account.isChecking());
    }
}