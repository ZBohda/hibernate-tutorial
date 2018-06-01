package com.tutorial.services;

import com.tutorial.domain.entities.Currency;
import com.tutorial.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyService {

    @Autowired
    private CurrencyRepository currencyRepository;

    public long addNewCurrency(String code) {
        Currency currency = new Currency();
        currency.setCode(code);
        return currencyRepository.create(currency);
    }

    public void remove(long id) {
        currencyRepository.delete(id);
    }

    public List<Currency> getAllCurrencies(){
        return currencyRepository.getAll();
    }
}
