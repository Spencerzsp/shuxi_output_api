package com.shuxi.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 船舶过闸效率分析（过闸耗时）
 * </p>
 *
 * @author yu hao
 * @since 2021-05-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TdmShipLockageEfficientAnalyse implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 船闸
     */
    private String snid;

    /**
     * 最高时间
     */
    private String maxTime;

    /**
     * 最低时间
     */
    private String minTime;

    /**
     * 平均时间
     */
    private String avgTime;


}
