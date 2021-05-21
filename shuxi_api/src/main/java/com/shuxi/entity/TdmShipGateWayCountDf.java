package com.shuxi.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 报到方式统计表
 * </p>
 *
 * @author yu hao
 * @since 2021-05-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TdmShipGateWayCountDf implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 枢纽id/总览
     */
    private String snid;

    /**
     * 北斗报闸
     */
    private String beidouCount;

    /**
     * 非北斗报闸
     */
    private String notBeidouCount;

    /**
     * 合计
     */
    private String totalCount;


}
