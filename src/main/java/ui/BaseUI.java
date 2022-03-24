package ui;

import entity.Currency;
import service.ExchangeService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * @author D4uranbek чт. 10:02. 24.03.2022
 */
public class BaseUI {

    private static final ExchangeService SERVICE = ExchangeService.getInstance();
    private static BaseUI instance;

    public static BaseUI getInstance() {

        if (Objects.isNull(instance)) {
            instance = new BaseUI();
        }
        return instance;

    }

    public void exchange() {

        showAllCurrency();

        Scanner scanner = new Scanner(System.in);
        Scanner scannerStr = new Scanner(System.in);

        System.out.print("From (enter code) >> ");
        String fromCurrencyCode = scannerStr.nextLine();
        System.out.print("To (enter code) >> ");
        String toCurrencyCode = scannerStr.nextLine();
        System.out.print("Amount >> ");
        BigDecimal amount = scanner.nextBigDecimal();

        System.out.println(SERVICE.exchange(amount, fromCurrencyCode, toCurrencyCode));

        System.out.println("Q >> quit");
        String choice = scannerStr.nextLine();

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

}
