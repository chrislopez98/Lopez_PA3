package com.company;
import java.util.Scanner;


//Main class
public class Application {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);


        SavingsAccount saver1 = new SavingsAccount(); //Instantiate two SavingsAccount objects, saver1 and saver2
        SavingsAccount saver2 = new SavingsAccount(); //with balances of $2000.00 and $3000.00
        saver1.modifySavings(2000.00);
        saver2.modifySavings(3000.00);
        saver1.modifyInterestRate(.04); //Problem 2: Test program sets the annualInterestRate to 4%
        saver2.modifyInterestRate(.04);
        System.out.println("Test results for an annual interest rate of .04% are below:");
        for(int i = 0; i < 13; i++){
            System.out.print("saver1 month " + i + " savings is: ");
            System.out.printf("%.2f", saver1.getSavings());
            System.out.print(", monthly interest is: ");
            System.out.printf("%.2f\n", saver1.getMonthly());
            System.out.print("saver2 month " + i + " savings is: ");
            System.out.printf("%.2f", saver2.getSavings());
            System.out.print(", monthly interest is: ");
            System.out.printf("%.2f\n", saver2.getMonthly());
            saver1.calculateMonthlyInterest();
            saver2.calculateMonthlyInterest();
            System.out.print("saver1 monthly interest next month is: ");
            System.out.printf("%.2f\n", saver1.getMonthly());
            System.out.print("saver2 monthly interest next month is: ");
            System.out.printf("%.2f\n", saver2.getMonthly());
            System.out.println("");
        }
        saver1.modifySavings(2000.00);
        saver2.modifySavings(3000.00);
        saver1.modifyInterestRate(.05); //Problem 2: Test program sets the annualInterestRate to 4%
        saver2.modifyInterestRate(.05);
        saver1.modifyMonthly(0.0);
        saver2.modifyMonthly(0.0);
        System.out.println("Test results for an annual interest rate of .05% are below:");
        for(int i = 0; i < 13; i++){
            System.out.print("saver1 month " + i + " savings is: ");
            System.out.printf("%.2f", saver1.getSavings());
            System.out.print(", monthly interest is: ");
            System.out.printf("%.2f\n", saver1.getMonthly());
            System.out.print("saver2 month " + i + " savings is: ");
            System.out.printf("%.2f", saver2.getSavings());
            System.out.print(", monthly interest is: ");
            System.out.printf("%.2f\n", saver2.getMonthly());
            saver1.calculateMonthlyInterest();
            saver2.calculateMonthlyInterest();
            System.out.print("saver1 monthly interest next month is: ");
            System.out.printf("%.2f\n", saver1.getMonthly());
            System.out.print("saver2 monthly interest next month is: ");
            System.out.printf("%.2f\n", saver2.getMonthly());
            System.out.println("");
        }
        return ;


    }
}

//Problem 2: Class named SavingsAccount exists
class SavingsAccount{
    private double annualInterestRate = 0; //Problem 2: annualInterestRate is a private class variable
    private double savingsBalance = 0; //Problem 2: savingsBalance is a private instance variable, each class will have
    private double monthlyInterest = 0.0;

    //An instance variable is a variable which is declared in a class but outside the constructor and the method/function.
    public void modifySavings(double balance) {
        savingsBalance = balance; //modifyInterestRate is correctly implemented
        return;
    }

    //Problem 2: calculateMonthlyInterest is a public instance method
    public void calculateMonthlyInterest() {
        monthlyInterest = ((savingsBalance * annualInterestRate) / 12);
        savingsBalance +=  monthlyInterest;// calculateMonthlyInterest is correctly implemented
        return;
    }
    //Problem 2: modifyInterestRate is a public class method
    public void modifyInterestRate(double newRate) {
        annualInterestRate = newRate; //modifyInterestRate is correctly implemented
        return;
    }

    public void modifyMonthly(double newMonthly) {
        monthlyInterest = newMonthly; //modifyInterestRate is correctly implemented
        return;
    }
    public double getSavings() {
        return savingsBalance;
    }
    public double getMonthly() {
        return monthlyInterest;
    }

}
