package com.shuxi.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 各船闸(本年)预测过闸数据
 * </p>
 *
 * @author yu hao
 * @since 2021-05-27
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
     * 荷载吨位
     */
    private String nclsCrryTns;

    /**
     * 总吨
     */
    private String totTon;

    /**
     * 过闸船数/艘次
     */
    private String czCount;


}
