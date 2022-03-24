package mapper;

/**
 * @author D4uranbek чт. 15:26. 24.03.2022
 */

import entity.CBU_Curr;
import entity.CcyNtry;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import util.XMLUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ExchangeMapper {

    public CBU_Curr xmlToCBU_Curr(Document doc) throws Exception {

        Element cBU_CurrElm = doc.getDocumentElement();
        CBU_Curr cBU_CurrBean = new CBU_Curr();


        cBU_CurrBean.setName(cBU_CurrElm.getAttribute("name"));
        cBU_CurrBean.setTextContent(XMLUtil.getFirstLevelTextContent(cBU_CurrElm));

        List<Element> ccyNtryNdList = XMLUtil.getChildElements(cBU_CurrElm, "CcyNtry");
        List<CcyNtry> ccyNtryList = new ArrayList<>();
        cBU_CurrBean.setCcyNtryList(ccyNtryList);
        for (Element ccyNtryElm : ccyNtryNdList) {
            CcyNtry ccyNtry = new CcyNtry();
            ccyNtryList.add(ccyNtry);

            ccyNtry.setCcy(ccyNtryElm.getAttribute("Ccy"));
            ccyNtry.setCcyMnrUnts(ccyNtryElm.getAttribute("CcyMnrUnts"));
            ccyNtry.setCcyNm_EN(ccyNtryElm.getAttribute("CcyNm_EN"));
            ccyNtry.setCcyNm_RU(ccyNtryElm.getAttribute("CcyNm_RU"));
            ccyNtry.setCcyNm_UZ(ccyNtryElm.getAttribute("CcyNm_UZ"));
            ccyNtry.setCcyNm_UZC(ccyNtryElm.getAttribute("CcyNm_UZC"));
            ccyNtry.setID(ccyNtryElm.getAttribute("ID"));
            ccyNtry.setIsMulti(ccyNtryElm.getAttribute("IsMulti"));
            ccyNtry.setNominal(ccyNtryElm.getAttribute("Nominal"));
            ccyNtry.setRate(ccyNtryElm.getAttribute("Rate"));
            ccyNtry.setDate(ccyNtryElm.getAttribute("date"));

        }

        return cBU_CurrBean;
    }

    private static ExchangeMapper instance;

    public static ExchangeMapper getInstance() {

        if (Objects.isNull(instance)) {
            instance = new ExchangeMapper();
        }
        return instance;

    }
}
