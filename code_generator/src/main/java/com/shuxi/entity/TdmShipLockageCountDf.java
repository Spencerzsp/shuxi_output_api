package com.shuxi.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 船舶数据统计
 * </p>
 *
 * @author yu hao
 * @since 2021-05-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TdmShipLockageCountDf implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 北斗报闸收费
     */
    private String bdLockagePayment;

    /**
     * 北斗过闸
     */
    private String bdLockageCount;

    /**
     * 窗口登记收费
     */
    private String ckLockagePayment;

    /**
     * 窗口登记
     */
    private String ckLockageCount;


}
