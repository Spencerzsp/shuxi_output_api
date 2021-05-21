package com.shuxi.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 近一年日均过闸船舶
 * </p>
 *
 * @author yu hao
 * @since 2021-05-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TdmDayLockageAvgDf implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 日均过闸船舶
     */
    private String czCount;


}
