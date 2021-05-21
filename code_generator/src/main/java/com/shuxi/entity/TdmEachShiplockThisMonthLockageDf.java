package com.shuxi.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 西江流域各船闸本月过闸数据
 * </p>
 *
 * @author yu hao
 * @since 2021-05-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TdmEachShiplockThisMonthLockageDf implements Serializable {

    private static final long serialVersionUID = 1L;

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


}
