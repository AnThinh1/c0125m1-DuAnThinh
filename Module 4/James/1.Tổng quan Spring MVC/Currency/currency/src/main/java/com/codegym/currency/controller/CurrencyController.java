package com.codegym.currency.controller;

import com.codegym.currency.model.Currency;
import com.codegym.currency.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class CurrencyController {
    @Autowired
    private CurrencyService currencyService;

    @GetMapping("/convert1")
    public ModelAndView showConvertUsdToVnd() {
        ModelAndView mav = new ModelAndView("convert1");
        mav.addObject("currency", new Currency());
        return mav;
    }

    @PostMapping("/convert1")
    public ModelAndView convertUsdToVnd(Currency currency) {
        double result = currencyService.convertToVnd(currency.getUsd());
        currency.setVnd(result);
        ModelAndView mav = new ModelAndView("convert1");
        mav.addObject("currency", currency);
        return mav;
    }

    @GetMapping("/convert2")
    public ModelAndView showConvertVndToUsd() {
        ModelAndView mav = new ModelAndView("convert2");
        mav.addObject("currency", new Currency());
        return mav;
    }

    @PostMapping("/convert2")
    public ModelAndView convertVndToUsd(Currency currency) {
        double result = currencyService.convertToUsd(currency.getVnd());
        currency.setUsd(result);
        ModelAndView mav = new ModelAndView("convert2");
        mav.addObject("currency", currency);
        return mav;
    }
}