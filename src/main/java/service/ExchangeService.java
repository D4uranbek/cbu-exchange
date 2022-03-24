package service;

import dao.ExchangeDAO;
import entity.CcyNtry;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Objects;

/**
 * @author D4uranbek чт. 10:02. 24.03.2022
 */
public class ExchangeService {

    private static final ExchangeDAO DAO = ExchangeDAO.getInstance();
    private static ExchangeService instance;

    public static ExchangeService getInstance() {

        if (Objects.isNull(instance)) {
            instance = new ExchangeService();
        }
        return instance;

    }

    public List<CcyNtry> getAllCurrency() {
        return DAO.getCurrencyList();
    }

    public BigDecimal exchange(String amount, String fromCurrencyCode, String toCurrencyCode) {

        CcyNtry fromCurrency = getCurrency(fromCurrencyCode);
        CcyNtry toCurrency = getCurrency(toCurrencyCode);

        return new BigDecimal(fromCurrency.Rate)
                .multiply(new BigDecimal(amount))
                .divide(new BigDecimal(toCurrency.Rate), 2, RoundingMode.HALF_UP);
    }

    public CcyNtry getCurrency(String currencyCode) {

        List<CcyNtry> currencies = getAllCurrency();

        return currencies.stream()
                .filter(currency -> currencyCode.equals(currency.ID))
                .findAny()
                .orElseThrow(() -> new RuntimeException("Not Found"));

    }
}
