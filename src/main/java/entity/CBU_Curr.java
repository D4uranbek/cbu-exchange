package entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author D4uranbek чт. 12:42. 24.03.2022
 */

public class CBU_Curr {

    private String name;
    private String textContent;
    @JsonProperty("CcyNtry")
    private List<CcyNtry> ccyNtryList;

    public CBU_Curr() {
    }

    public CBU_Curr(String name, String textContent, List<CcyNtry> ccyNtryList) {
        this.name = name;
        this.textContent = textContent;
        this.ccyNtryList = ccyNtryList;
    }

    @XmlAttribute(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlAttribute(name = "TextContent")
    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    @XmlElement(name = "CcyNtry")
    public List<CcyNtry> getCcyNtryList() {
        if (ccyNtryList == null)
            ccyNtryList = new ArrayList<CcyNtry>();
        return ccyNtryList;
    }

    public void setCcyNtryList(List<CcyNtry> ccyNtryList) {
        this.ccyNtryList = ccyNtryList;
    }

}

