package com.shuxi.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 近一年月均过闸船舶
 * </p>
 *
 * @author yu hao
 * @since 2021-05-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TdmMonthLockageAvgDf implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 月均过闸船舶
     */
    private String czCount;


}
