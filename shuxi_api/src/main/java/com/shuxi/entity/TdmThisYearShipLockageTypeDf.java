package com.shuxi.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 船舶(本年)报道方式统计
 * </p>
 *
 * @author yu hao
 * @since 2021-05-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TdmThisYearShipLockageTypeDf implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 船闸名称
     */
    private String lockName;

    /**
     * 本年/本月
     */
    private String showType;

    /**
     * 枢纽ID
     */
    private String snid;

    /**
     * 北斗过闸次数
     */
    private String bdLockageCount;

    /**
     * 非北斗(窗口)过闸次数
     */
    private String ckLockageCount;

    /**
     * 总过闸次数
     */
    private String totoalLockageCount;


}
