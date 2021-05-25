package com.shuxi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TdmThisYearEachShiplockForecastDfDTO {
    private String showType;
    private String dataType;
    private String forecastCzCount;
    private String forecastCrgDdwghtTns;
    private String actualCzCount;
    private String actualCrgDdwghtTns;
}
