package service;

import dao.ExchangeDAO;
import entity.Currency;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

/**
 * @author D4uranbek чт. 10:02. 24.03.2022
 */
public class ExchangeService {

    private static final ExchangeDAO DAO = ExchangeDAO.getInstance();

    public List<Currency> getAllCurrency() {
        return DAO.getCurrencyList();
    }

    public BigDecimal exchange(BigDecimal amount, String fromCurrencyCode, String toCurrencyCode) {

        Currency fromCurrency = getCurrency(fromCurrencyCode);
        Currency toCurrency = getCurrency(toCurrencyCode);

        return new BigDecimal(fromCurrency.getRate())
                .divide(new BigDecimal(toCurrency.getRate()), 2)
                .multiply(amount);
    }

    public Currency getCurrency(String currencyCode) {

        List<Currency> currencies = getAllCurrency();

        Currency fromCurrency = currencies.stream()
                .filter(currency -> currencyCode.equals(currency.getCode()))
                .findAny()
                .orElseThrow(() -> new RuntimeException("Not Found"));
        return fromCurrency;

    }

    private static ExchangeService instance;

    public static ExchangeService getInstance() {

        if (Objects.isNull(instance)) {
            instance = new ExchangeService();
        }
        return instance;

    }
}
