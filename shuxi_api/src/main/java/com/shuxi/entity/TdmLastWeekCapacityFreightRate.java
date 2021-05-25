package com.shuxi.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 上周货运指数&运力指数表
 * </p>
 *
 * @author yu hao
 * @since 2021-05-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TdmLastWeekCapacityFreightRate implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 上周运力指数
     */
    private String lastWeekCapacityRate;

    /**
     * 上周货运指数
     */
    private String lastWeekFreightRate;


}
