package dto;

import lombok.*;

/**
 * @author D4uranbek пт. 10:46. 25.03.2022
 */

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyDateRateDTO {

    private String nameEn;

    private String date;

    private String rate;

}
