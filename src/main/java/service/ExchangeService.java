package service;

import dao.ExchangeDAO;
import dto.CurrencyDateRateDTO;
import entity.Currency;

import java.math.BigDecimal;
import java.math.RoundingMode;
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

    public BigDecimal exchange(String amount, String fromCurrencyCode, String toCurrencyCode) {

        Currency fromCurrency = getCurrency(fromCurrencyCode);
        Currency toCurrency = getCurrency(toCurrencyCode);

        return new BigDecimal(fromCurrency.getRate())
                .multiply(new BigDecimal(amount))
                .divide(new BigDecimal(toCurrency.getRate()), 2, RoundingMode.HALF_UP);
    }

    public Currency getCurrency(String currencyCode) {

        List<Currency> currencies = getAllCurrency();

        return currencies.stream()
                .filter(currency -> currencyCode.equals(currency.getCode()))
                .findAny()
                .orElseThrow(() -> new RuntimeException("Not Found"));

    }

    public String getCurrencyCcy(String currencyCode) {

        List<Currency> currencies = getAllCurrency();

        return currencies.stream()
                .filter(currency -> currencyCode.equals(currency.getCode()))
                .findAny()
                .orElseThrow(() -> new RuntimeException("Not Found")).getCcy();

    }

    private static ExchangeService instance;

    public static ExchangeService getInstance() {

        if (Objects.isNull(instance)) {
            instance = new ExchangeService();
        }
        return instance;

    }


    public List<CurrencyDateRateDTO> lastFiveDayByCode(String code) {
        String ccy = getCurrencyCcy(code);

        return DAO.lastFiveDayByCcy(ccy);
    }
}
