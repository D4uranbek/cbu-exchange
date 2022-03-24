package dao;

import entity.Currency;
import mapper.CurrencyMapper;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

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

    private static final CurrencyMapper CURRENCY_MAPPER = CurrencyMapper.getInstance();

    private static ExchangeDAO instance;

    public static ExchangeDAO getInstance() {

        if (Objects.isNull(instance)) {
            instance = new ExchangeDAO();
        }
        return instance;

    }

    public List<Currency> getCurrencyList() {

        try {
            URL url = new URL("https://cbu.uz/uz/arkhiv-kursov-valyut/xml/");

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(url.openStream());
            document.getDocumentElement().normalize();

            Element cbuCurr = document.getDocumentElement();

            List<Element> currencyElementList = getChildElements(cbuCurr, "CcyNtry");

            return CURRENCY_MAPPER.toCurrencyList(currencyElementList);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }

    public static List<Element> getChildElements(Element element, String tagName) {
        List<Element> elementList = new ArrayList<>();
        NodeList nodeList = element.getChildNodes();

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE && tagName.equals(node.getNodeName())) {
                Element childElm = (Element) node;
                elementList.add(childElm);
            }
        }

        return elementList;
    }
}
