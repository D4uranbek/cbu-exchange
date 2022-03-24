package entity;

import lombok.*;

/**
 * @author D4uranbek чт. 15:51. 24.03.2022
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Currency {

    private String ccy;

    private String ccyNmRU;

    private String ccyNmUZ;

    private String ccyNmUZC;

    private String ccyNmEN;

    private String ccyMnrUnts;

    private String nominal;

    private String rate;

    private String date;

    private String id;

    private String text;

}
