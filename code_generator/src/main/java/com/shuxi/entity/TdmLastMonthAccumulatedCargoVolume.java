package com.shuxi.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 上个月累计货运量
 * </p>
 *
 * @author yu hao
 * @since 2021-05-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TdmLastMonthAccumulatedCargoVolume implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 累计货运量
     */
    private String amount;


}
