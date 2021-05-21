package com.shuxi.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 西江流域船舶类型分布图
 * </p>
 *
 * @author yu hao
 * @since 2021-05-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TdmShipTypeDistributionDf implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 北斗船舶数量
     */
    private String beidouShipCount;

    /**
     * 北斗船舶数量占比
     */
    private String beidouShipCountProportion;

    /**
     * 非北斗船舶数量
     */
    private String notBeidouShipCount;

    /**
     * 非北斗船舶数量占比
     */
    private String notBeidouShipCountProportion;


}
