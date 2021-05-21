package com.shuxi.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
public class TdmRecentYearLockageYearIncreaseDf implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 船闸/,默认汇总
     */
    private String snid;

    /**
     * 年份
     */
    private String fzDate;

    /**
     * 总吨合计同比增长
     */
    private String totTonIncrease;

    /**
     * 核载吨位同比增长
     */
    private String nclsCrryTnsIncrease;

    /**
     * 实载吨位同比增长
     */
    private String crgDdwghtTnsIncrease;

    /**
     * 过闸船数/艘次同比增长
     */
    private String czCountIncrease;

    /**
     * 过闸缴费同比增长
     */
    private String actualPaymentIncrease;

    /**
     * 闸次同比增长
     */
    private String fzCountIncrease;


}
