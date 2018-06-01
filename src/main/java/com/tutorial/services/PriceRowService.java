package com.tutorial.services;

import com.tutorial.domain.entities.Currency;
import com.tutorial.domain.entities.PriceRow;
import com.tutorial.domain.entities.Product;
import com.tutorial.repository.CurrencyRepository;
import com.tutorial.repository.PriceRowRepository;
import com.tutorial.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceRowService {

    @Autowired
    private PriceRowRepository priceRowRepository;

    @Autowired
    private CurrencyRepository currencyRepository;

    @Autowired
    private ProductRepository productRepository;

    public boolean createNewPriceRow(double price, Currency currency) {
        try {
            currencyRepository.read(currency.getId());
        } catch (Exception ex) {
            return false;
        }
        try {
            priceRowRepository.getPriceRowByPriceAndCurrency(price, currency);
        } catch (Exception ex) {
            PriceRow priceRow = new PriceRow(price, currency, true);
            priceRowRepository.create(priceRow);
            return true;
        }
        return false;
    }

    public boolean createNewPriceForProduct(double price, Currency currency, Product product) {
        try {
            currencyRepository.read(currency.getId());
            productRepository.read(product.getId());
        } catch (Exception ex) {
            return false;
        }
        try {
            priceRowRepository.getPriceRowByPriceAndCurrencyAndProduct(price, currency, product);
        } catch (Exception ex) {
            PriceRow priceRow = new PriceRow(price, currency, product, true);
            priceRowRepository.create(priceRow);
            return true;
        }
        return false;
    }

    public boolean changePriceForPriceRow(long id, double newPrice) {
        PriceRow priceRowOld;
        try {
            priceRowOld = priceRowRepository.read(id);
            if(!priceRowOld.isActive()){
                return false;
            }
        } catch (Exception ex) {
            return false;
        }
        priceRowOld.setActive(false);
        priceRowRepository.update(priceRowOld);
        PriceRow priceRowNew = new PriceRow();
        priceRowNew.setPrice(newPrice);
        priceRowNew.setActive(true);
        priceRowNew.setProduct(priceRowOld.getProduct());
        priceRowNew.setCurrency(priceRowOld.getCurrency());
        priceRowRepository.create(priceRowNew);
        return true;
    }

    public boolean disablePriceRow(long id){
        PriceRow priceRow;
        try {
            priceRow = priceRowRepository.read(id);
            if(!priceRow.isActive()){
                return false;
            }
        } catch (Exception ex){
            return false;
        }
        priceRow.setActive(false);
        priceRowRepository.update(priceRow);
        return true;
    }

    public boolean enablePriceRow(long id){
        PriceRow priceRow;
        try {
            priceRow = priceRowRepository.read(id);
            if(priceRow.isActive()){
                return false;
            }

        } catch (Exception ex){
            return false;
        }
        priceRow.setActive(true);
        priceRowRepository.update(priceRow);
        return true;
    }

    public long clearDisabledPriceRows(){
        List<PriceRow> disabledPriceRows;
        long counter = 0;
        try {
            disabledPriceRows = priceRowRepository.getAllDisabledPriceRows();
        } catch (Exception ex){
            return counter;
        }
        for(PriceRow disabledPriceRow: disabledPriceRows){
            priceRowRepository.delete(disabledPriceRow.getId());
            counter++;
        }
        return counter;
    }

    public List<PriceRow> getAllNoProductPriceRows(){
        return priceRowRepository.getAllNoProductPriceRows();
    }
}
