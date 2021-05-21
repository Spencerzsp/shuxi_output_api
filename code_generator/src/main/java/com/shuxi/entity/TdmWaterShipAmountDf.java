package com.shuxi.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 西江流域水运发货量
 * </p>
 *
 * @author yu hao
 * @since 2021-05-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TdmWaterShipAmountDf implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 年份
     */
    private String countYear;

    /**
     * 发货量(含粤发)
     */
    private String shipment;

    /**
     * 广西发
     */
    private String gxShipment;

    /**
     * 广东发(入桂)
     */
    private String gdShipment;

    /**
     * 艘次
     */
    private String czCount;


}
