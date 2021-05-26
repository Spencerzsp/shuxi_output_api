package com.shuxi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @Author: Yu Hao
 * DateTime: 2021-05-26 14:52
 */
@Data
@AllArgsConstructor
public class TdmPastYearLokageBasinGoodsIncrementDfDTO {
    private String showDimension;
    private String fzDate;
    private String dimensionValues;
    private String upYearChange;
    private String downYearChange;
}
