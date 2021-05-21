package com.shuxi.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 西江流域近年(历年同期)各月过闸数据统计表(分船闸)
 * </p>
 *
 * @author yu hao
 * @since 2021-05-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TdmThisYearEachMonthLockageDf implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 枢纽ID/默认汇总
     */
    private String snid;

    /**
     * 月份
     */
    private String fzMonth;

    /**
     * 总吨合计
     */
    private String totTon;

    /**
     * 总吨合计同比增长
     */
    private String totTonIncrease;

    /**
     * 核载吨位
     */
    private String nclsCrryTns;

    /**
     * 核载吨位同比增长
     */
    private String nclsCrryTnsIncrease;

    /**
     * 实载吨位
     */
    private String crgDdwghtTns;

    /**
     * 实载吨位同比增长
     */
    private String crgDdwghtTnsIncrease;

    /**
     * 过闸船数/艘次
     */
    private String czCount;

    /**
     * 过闸船数/艘次同比增长
     */
    private String czCountIncrease;


}
