package com.example.yi.lbsystem;

public class Transaction {
    public boolean isCAD;
    public double amount;
    public double exchangeRate;//
    public double balance;//min own ji
    public String loaner;
    public String borrower;
    public String clr;//green yellow grey
    public String comments;
    public String timestamp;

    public Transaction(){

    }
    public Transaction(double amount, String loaner, String borrower, String comments) {
        this.amount = amount;
        this.loaner = loaner;
        this.borrower = borrower;
        this.comments = comments;
    }

    public boolean isCAD() {
        return isCAD;
    }

    public double getAmount() {
        return amount;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    public double getBalance() {
        return balance;
    }

    public String getLoaner() {
        return loaner;
    }

    public String getBorrower() {
        return borrower;
    }

    public String getClr() {
        return clr;
    }

    public String getComments() {
        return comments;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setCAD(boolean CAD) {
        isCAD = CAD;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setLoaner(String loaner) {
        this.loaner = loaner;
    }

    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    public void setClr(String clr) {
        this.clr = clr;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
