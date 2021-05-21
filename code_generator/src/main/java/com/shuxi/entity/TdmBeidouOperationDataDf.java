package com.shuxi.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 北斗运行数据表
 * </p>
 *
 * @author yu hao
 * @since 2021-05-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TdmBeidouOperationDataDf implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 总艘数
     */
    private String totalShipCount;

    /**
     * 所有过闸艘数
     */
    private String totalLockageShipCount;

    /**
     * 经常过闸艘数
     */
    private String oftenLockageShipCount;

    /**
     * 常过重点闸艘数
     */
    private String importantGateWayShipCount;

    /**
     * 总运力
     */
    private String totalTransportCapacity;

    /**
     * 所有过闸运力
     */
    private String totalLockageTransportCapacity;

    /**
     * 经常过闸运力
     */
    private String oftenLockageTransportCapacity;

    /**
     * 常过重点闸运力
     */
    private String importantGateWayTransportCapacity;


}
