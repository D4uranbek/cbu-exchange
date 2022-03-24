package dao;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import entity.Currency;

import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author D4uranbek чт. 10:03. 24.03.2022
 */
public class ExchangeDAO {

    private static ExchangeDAO instance;

    public static ExchangeDAO getInstance() {

        if (Objects.isNull(instance)) {
            instance = new ExchangeDAO();
        }
        return instance;

    }

    public List<Currency> getCurrencyList() {
        try {

            URL url = new URL("https://cbu.uz/uz/arkhiv-kursov-valyut/json/");
            InputStreamReader reader = new InputStreamReader(url.openStream());

            Type currencyListType = new TypeToken<List<Currency>>() {
            }.getType();

            return new GsonBuilder().create().fromJson(reader, currencyListType);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }
}
