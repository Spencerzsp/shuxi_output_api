package com.shuxi.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
     * 北斗船舶数量
     */
    private String amount;

    /**
     * 北斗船舶运力
     */
    private String shipment;


}
