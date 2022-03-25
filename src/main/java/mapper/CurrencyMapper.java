package mapper;

import entity.Currency;
import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author D4uranbek чт. 17:54. 24.03.2022
 */
public class CurrencyMapper {

    private static CurrencyMapper instance;

    public static CurrencyMapper getInstance() {

        if (Objects.isNull(instance)) {
            instance = new CurrencyMapper();
        }
        return instance;

    }

    public List<Currency> toCurrencyList(List<Element> currencyElementList) {

        List<Currency> currencies = new ArrayList<>();
        for (Element currencyElement : currencyElementList) {
            Currency currency = toCurrency(currencyElement);
            currencies.add(currency);
        }
        return currencies;

    }

    public Currency toCurrency(Element currencyElement) {

        return Currency.builder()
                .id(currencyElement.getAttribute("ID"))

                .ccy(getField(currencyElement, "Ccy"))
                .ccyMnrUnts(getField(currencyElement, "CcyMnrUnts"))
                .ccyNmEN(getField(currencyElement, "CcyNm_EN"))
                .ccyNmRU(getField(currencyElement, "CcyNm_RU"))
                .ccyNmUZ(getField(currencyElement, "CcyNm_UZ"))
                .ccyNmUZC(getField(currencyElement, "CcyNm_UZC"))
                .nominal(getField(currencyElement, "Nominal"))
                .rate(getField(currencyElement, "Rate"))
                .date(getField(currencyElement, "date"))

                .build();
    }

    private String getField(Element currencyElement, String fieldName) {
        return currencyElement.getElementsByTagName(fieldName).item(0).getTextContent();
    }
}
