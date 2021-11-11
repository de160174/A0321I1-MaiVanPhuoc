package com.service;

public class ChangeMoneyImpl implements ChangeMoney{
    @Override
    public double change(double usd) {
        return usd*23000;
    }
}
