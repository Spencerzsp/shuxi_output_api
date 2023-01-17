package com.shuxi.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 北斗船舶数量、运力统计
 * </p>
 *
 * @author yu hao
 * @since 2021-05-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TdmBeidouShipAmountDf implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 北斗传播数量 vsl_cd_count_total
     */
    private String vslCdCountTotal;

    /**
     * 北斗传播运力 ncls_crry_tns_sum_total
     */
    private String nclsCrryTnsSumTotal;

    /**
     * 船闸
     */
    private String lockName;

    /**
     * 单个船闸北斗船舶数量
     */
    private String amount;

    /**
     * 单个船闸北斗船舶运力
     */
    private String shipment;


}
