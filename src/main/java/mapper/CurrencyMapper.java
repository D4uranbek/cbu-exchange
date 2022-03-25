package mapper;

import dto.CurrencyDateRateDTO;
import entity.Currency;

import java.util.Objects;

/**
 * @author D4uranbek пт. 10:46. 25.03.2022
 */
public class CurrencyMapper {

    public CurrencyDateRateDTO toCurrencyDateRateDTO(Currency currency) {
        return CurrencyDateRateDTO.builder()
                .nameEn(currency.getCcyNmEN())
                .date(currency.getDate())
                .rate(currency.getRate())
                .build();
    }


    private static CurrencyMapper instance;

    public static CurrencyMapper getInstance() {

        if (Objects.isNull(instance)) {
            instance = new CurrencyMapper();
        }
        return instance;

    }
}
