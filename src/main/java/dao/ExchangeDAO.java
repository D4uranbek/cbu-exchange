package dao;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import entity.CBU_Curr;
import entity.CcyNtry;

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

    public List<CcyNtry> getCurrencyList() {

        try {
            URL url = new URL("https://cbu.uz/uz/arkhiv-kursov-valyut/xml/");

            XmlMapper mapper = new XmlMapper();
            CBU_Curr curr = mapper.readValue(url, CBU_Curr.class);

            return curr.CcyNtry;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }
}
