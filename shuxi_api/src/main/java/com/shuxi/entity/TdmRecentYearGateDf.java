package com.shuxi.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 西江流域近年(历年同期)过闸数据统计表
 * </p>
 *
 * @author yu hao
 * @since 2021-05-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TdmRecentYearGateDf implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 展示维度:流域城市船闸
     */
    private String showDimension;

    /**
     * 流域城市船闸下级值
     */
    private String dimensionValues;

    /**
     * 年份
     */
    private String fzDate;

    /**
     * 总吨合计
     */
    private String totTon;

    /**
     * 核载吨位
     */
    private String nclsCrryTns;

    /**
     * 实载吨位
     */
    private String crgDdwghtTns;

    /**
     * 过闸船数/艘次
     */
    private String czCount;


}
