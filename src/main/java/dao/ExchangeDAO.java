package dao;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import dto.CurrencyDateRateDTO;
import entity.Currency;
import mapper.CurrencyMapper;

import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.text.MessageFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author D4uranbek чт. 10:03. 24.03.2022
 */
public class ExchangeDAO {

    public static final CurrencyMapper MAPPER = CurrencyMapper.getInstance();

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

    public List<CurrencyDateRateDTO> lastFiveDayByCcy(String ccy) {

        List<CurrencyDateRateDTO> dtoList = new ArrayList<>();

        try {

            for (int i = 0; i > -10; i--) {
                String date = LocalDate.now().plusDays(i).toString();
                String urlString = MessageFormat.format("https://cbu.uz/uz/arkhiv-kursov-valyut/json/{0}/{1}/", ccy, date);
                URL url = new URL(urlString);

                InputStreamReader reader = new InputStreamReader(url.openStream());
                Type currencyListType = new TypeToken<List<Currency>>() {
                }.getType();

                List<Currency> currency = new GsonBuilder().create().fromJson(reader, currencyListType);
                CurrencyDateRateDTO dto = MAPPER.toCurrencyDateRateDTO(currency.get(0));
                dtoList.add(dto);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return dtoList;
    }


}
