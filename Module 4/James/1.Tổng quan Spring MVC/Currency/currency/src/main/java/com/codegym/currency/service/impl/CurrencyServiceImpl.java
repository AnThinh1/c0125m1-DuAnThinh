package com.codegym.currency.service.impl;
import com.codegym.currency.service.CurrencyService;
import org.springframework.stereotype.Service;
@Service
public class CurrencyServiceImpl implements CurrencyService {
    private static final double Rate= 25000;

    @Override
    public double convertToVnd(double usd){
    return usd * Rate;
    }
    @Override
    public double convertToUsd(double vnd){
        return vnd / Rate;
    }


}
