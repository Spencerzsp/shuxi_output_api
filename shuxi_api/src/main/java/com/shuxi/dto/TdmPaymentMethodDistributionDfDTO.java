package com.shuxi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @Author: Yu Hao
 * DateTime: 2021-05-26 9:58
 */
@Data
@AllArgsConstructor
public class TdmPaymentMethodDistributionDfDTO {
    private String snid;
    private String onLinePayCount;
    private String totalPayCount;
}
