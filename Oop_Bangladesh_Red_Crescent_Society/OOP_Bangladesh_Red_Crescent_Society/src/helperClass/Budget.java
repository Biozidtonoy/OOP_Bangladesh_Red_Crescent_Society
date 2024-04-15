/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helperClass;

import java.io.Serializable;

/**
 *
 * @author HP
 */
public class Budget implements Serializable{
    private double revenueAmount,expensesAmount,remainingAmount,budgetAmount;
    private String budget;

    public Budget(double revenueAmount, double expensesAmount, double remainingAmount, double budgetAmount, String budget) {
        this.revenueAmount = revenueAmount;
        this.expensesAmount = expensesAmount;
        this.remainingAmount = remainingAmount;
        this.budgetAmount = budgetAmount;
        this.budget = budget;
    }

    public double getRevenueAmount() {
        return revenueAmount;
    }

    public void setRevenueAmount(double revenueAmount) {
        this.revenueAmount = revenueAmount;
    }

    public double getExpensesAmount() {
        return expensesAmount;
    }

    public void setExpensesAmount(double expensesAmount) {
        this.expensesAmount = expensesAmount;
    }

    public double getRemainingAmount() {
        return remainingAmount;
    }

    public void setRemainingAmount(double remainingAmount) {
        this.remainingAmount = remainingAmount;
    }

    public double getBudgetAmount() {
        return budgetAmount;
    }

    public void setBudgetAmount(double budgetAmount) {
        this.budgetAmount = budgetAmount;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    @Override
    public String toString() {
        return "Budget{" + "revenueAmount=" + revenueAmount + ", expensesAmount=" + expensesAmount + ", remainingAmount=" + remainingAmount + ", budgetAmount=" + budgetAmount + ", budget=" + budget + '}';
    }

    
    
    
    
}
