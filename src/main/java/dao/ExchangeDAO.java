package dao;

import entity.CBU_Curr;
import entity.CcyNtry;
import mapper.ExchangeMapper;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author D4uranbek чт. 10:03. 24.03.2022
 */
public class ExchangeDAO {

    public List<CcyNtry> getCurrencyList() {

        try {
            URL url = new URL("https://cbu.uz/uz/arkhiv-kursov-valyut/xml/");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(url.openStream());

            CBU_Curr cbu_curr = ExchangeMapper.getInstance().xmlToCBU_Curr(doc);
            return cbu_curr.getCcyNtryList();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }


    private static ExchangeDAO instance;

    public static ExchangeDAO getInstance() {

        if (Objects.isNull(instance)) {
            instance = new ExchangeDAO();
        }
        return instance;

    }
}
