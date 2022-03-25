package ui;

import dto.CurrencyDateRateDTO;
import entity.Currency;
import service.ExchangeService;

import java.text.MessageFormat;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * @author D4uranbek чт. 10:02. 24.03.2022
 */
public class BaseUI {

    private static final ExchangeService SERVICE = ExchangeService.getInstance();
    private static final Scanner SCANNER_STR = new Scanner(System.in);
    private static BaseUI instance;

    public static BaseUI getInstance() {

        if (Objects.isNull(instance)) {
            instance = new BaseUI();
        }
        return instance;

    }

    public void exchange() {

        showAllCurrency();

        System.out.print("From (enter code) >> ");
        String fromCurrencyCode = SCANNER_STR.nextLine();
        System.out.print("To (enter code) >> ");
        String toCurrencyCode = SCANNER_STR.nextLine();
        System.out.print("Amount >> ");
        String amount = SCANNER_STR.nextLine();

        System.out.println(SERVICE.exchange(amount, fromCurrencyCode, toCurrencyCode));

        System.out.println("Q >> quit");
        String choice = SCANNER_STR.nextLine();

        if (choice.startsWith("q")) {
            return;
        }

        exchange();
    }

    public void showAllCurrency() {
        List<Currency> currencies = SERVICE.getAllCurrency();

        for (Currency currency : currencies) {
            System.out.println(currency.getCode() + " \t " + currency.getCcyNmEN() + " || " + currency.getCcy());
        }
    }

    public void lastFiveDay() {
        showAllCurrency();

        System.out.print("Enter code >> ");
        String code = SCANNER_STR.nextLine();

        List<CurrencyDateRateDTO> lastFiveDayList = SERVICE.lastFiveDayByCode(code);

        lastFiveDayList.forEach(dto -> {
            System.out.println(MessageFormat.format("{0} \t {1} \t {2}", dto.getNameEn(), dto.getDate(), dto.getRate()));
        });
    }
}
