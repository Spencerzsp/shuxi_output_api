package com.shuxi.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 各船闸(本年)预测过闸数据
 * </p>
 *
 * @author yu hao
 * @since 2021-05-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TdmThisYearEachShiplockForecastDf implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 本年/本月
     */
    private String showType;

    /**
     * 枢纽ID
     */
    private String snid;

    /**
     * 实际过闸/预测过闸
     */
    private String dataType;

    /**
     * 实载吨位
     */
    private String crgDdwghtTns;

    /**
     * 过闸船数/艘次
     */
    private String czCount;


}
