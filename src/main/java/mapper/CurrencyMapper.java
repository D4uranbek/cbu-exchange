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

                .ccy(currencyElement.getElementsByTagName("Ccy").item(0).getTextContent())
                .ccyMnrUnts(currencyElement.getElementsByTagName("CcyMnrUnts").item(0).getTextContent())
                .ccyNmEN(currencyElement.getElementsByTagName("CcyNm_EN").item(0).getTextContent())
                .ccyNmRU(currencyElement.getElementsByTagName("CcyNm_RU").item(0).getTextContent())
                .ccyNmUZ(currencyElement.getElementsByTagName("CcyNm_UZ").item(0).getTextContent())
                .ccyNmUZC(currencyElement.getElementsByTagName("CcyNm_UZC").item(0).getTextContent())
                .nominal(currencyElement.getElementsByTagName("Nominal").item(0).getTextContent())
                .rate(currencyElement.getElementsByTagName("Rate").item(0).getTextContent())
                .date(currencyElement.getElementsByTagName("date").item(0).getTextContent())

                .build();
    }
}
