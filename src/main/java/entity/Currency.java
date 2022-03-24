package entity;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Currency {

    @SerializedName("id")
    private Integer id;

    @SerializedName("CcyNm_EN")
    private String ccyNmEN;

    @SerializedName("CcyNm_RU")
    private String ccyNmRU;

    @SerializedName("CcyNm_UZ")
    private String ccyNmUZ;

    @SerializedName("CcyNm_UZC")
    private String ccyNmUZC;

    @SerializedName("Diff")
    private String diff;

    @SerializedName("Rate")
    private String rate;

    @SerializedName("Ccy")
    private String ccy;

    @SerializedName("Code")
    private String code;

    @SerializedName("Nominal")
    private String nominal;

    @SerializedName("Date")
    private String date;
}