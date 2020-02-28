package com.company.chuan;

import jdk.nashorn.internal.parser.JSONParser;

import java.util.Date;

public class Transaction implements Comparable<Transaction>{

    private String who;
    private String when;
    private double amount;
    public Transaction(String who, Date when, double amount) {


    }

    // 解析字符串的构造函数
    public Transaction(String transaction) {
        String[] data = transaction.split(",");
        who = data[0];
        when = data[1];
        amount = Double.parseDouble(data[2]);

    }

    @Override
    public int compareTo(Transaction o) {
        double result = amount - o.amount;
        if(result > 0) {
            return 1;
        } else if(result < 0) {
            return -1;
        }
        return 0;
    }
}
