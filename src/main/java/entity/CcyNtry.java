package entity;


import javax.xml.bind.annotation.XmlAttribute;

public class CcyNtry {
    private String ccy;
    private String ccyMnrUnts;
    private String ccyNm_EN;
    private String ccyNm_RU;
    private String ccyNm_UZ;
    private String ccyNm_UZC;
    private String iD;
    private String isMulti;
    private String nominal;
    private String rate;
    private String date;
    private String textContent;

    public CcyNtry(String ccy, String ccyMnrUnts, String ccyNm_EN, String ccyNm_RU, String ccyNm_UZ, String ccyNm_UZC, String iD, String isMulti, String nominal, String rate, String date, String textContent) {
        this.ccy = ccy;
        this.ccyMnrUnts = ccyMnrUnts;
        this.ccyNm_EN = ccyNm_EN;
        this.ccyNm_RU = ccyNm_RU;
        this.ccyNm_UZ = ccyNm_UZ;
        this.ccyNm_UZC = ccyNm_UZC;
        this.iD = iD;
        this.isMulti = isMulti;
        this.nominal = nominal;
        this.rate = rate;
        this.date = date;
        this.textContent = textContent;
    }

    @XmlAttribute(name = "Ccy")
    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    @XmlAttribute(name = "CcyMnrUnts")
    public String getCcyMnrUnts() {
        return ccyMnrUnts;
    }

    public void setCcyMnrUnts(String ccyMnrUnts) {
        this.ccyMnrUnts = ccyMnrUnts;
    }

    @XmlAttribute(name = "CcyNm_EN")
    public String getCcyNm_EN() {
        return ccyNm_EN;
    }

    public void setCcyNm_EN(String ccyNm_EN) {
        this.ccyNm_EN = ccyNm_EN;
    }

    @XmlAttribute(name = "CcyNm_RU")
    public String getCcyNm_RU() {
        return ccyNm_RU;
    }

    public void setCcyNm_RU(String ccyNm_RU) {
        this.ccyNm_RU = ccyNm_RU;
    }

    @XmlAttribute(name = "CcyNm_UZ")
    public String getCcyNm_UZ() {
        return ccyNm_UZ;
    }

    public void setCcyNm_UZ(String ccyNm_UZ) {
        this.ccyNm_UZ = ccyNm_UZ;
    }

    @XmlAttribute(name = "CcyNm_UZC")
    public String getCcyNm_UZC() {
        return ccyNm_UZC;
    }

    public void setCcyNm_UZC(String ccyNm_UZC) {
        this.ccyNm_UZC = ccyNm_UZC;
    }

    @XmlAttribute(name = "ID")
    public String getID() {
        return iD;
    }

    public void setID(String iD) {
        this.iD = iD;
    }

    @XmlAttribute(name = "IsMulti")
    public String getIsMulti() {
        return isMulti;
    }

    public void setIsMulti(String isMulti) {
        this.isMulti = isMulti;
    }

    @XmlAttribute(name = "Nominal")
    public String getNominal() {
        return nominal;
    }

    public void setNominal(String nominal) {
        this.nominal = nominal;
    }

    @XmlAttribute(name = "Rate")
    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    @XmlAttribute(name = "date")
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @XmlAttribute(name = "TextContent")
    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public CcyNtry() {
    }


}