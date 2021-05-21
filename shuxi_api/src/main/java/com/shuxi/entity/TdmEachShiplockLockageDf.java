package com.shuxi.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 西江流域各船闸累计过闸数据统计表
 * </p>
 *
 * @author yu hao
 * @since 2021-05-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TdmEachShiplockLockageDf implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 年份
     */
    private String fzYear;

    /**
     * 报道枢纽
     */
    private String snid;

    /**
     * 闸次
     */
    private String fzCount;

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

    /**
     * 过闸费
     */
    private String czMoney;

    /**
     * 排队中船舶数
     */
    private String queuingShipCount;

    /**
     * 调度中船舶数
     */
    private String schedulingShipCount;

    /**
     * 今日过闸
     */
    private String todayLockageCount;

    /**
     * 昨日过闸
     */
    private String yesterdayLockageCount;

    /**
     * 上游水位
     */
    private String upWaterLevel;

    /**
     * 上游水位
     */
    private String downWaterLevel;

    /**
     * 调度中船舶吃水
     */
    private String schedulingShipDraft;

    /**
     * 排队中船舶吃水
     */
    private String queuingShipDraft;


}
