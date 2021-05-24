package com.shuxi.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 西江流域运力周指数
 * </p>
 *
 * @author yu hao
 * @since 2021-05-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TdmXjTransportCapacityWeekRate implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 指标
     */
    private String target;

    /**
     * 指标名
     */
    private String targetName;

    /**
     * 年份
     */
    private String yearIncrease;

    /**
     * 周数
     */
    private String weekCount;

    /**
     * 上行指数
     */
    private String upRate;

    /**
     * 下行指数
     */
    private String downRate;


}
