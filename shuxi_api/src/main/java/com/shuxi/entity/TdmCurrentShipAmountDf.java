package com.shuxi.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 西江流域船舶类型分布（当前）近一月
 * </p>
 *
 * @author yu hao
 * @since 2021-05-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TdmCurrentShipAmountDf implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 是否为北斗船舶
     */
    private String terminalType;

    /**
     * 数量
     */
    private String amount;

    /**
     * 运力
     */
    private String shipment;


}
