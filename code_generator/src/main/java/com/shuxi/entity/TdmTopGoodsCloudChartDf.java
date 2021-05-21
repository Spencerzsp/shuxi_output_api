package com.shuxi.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 货物云图
 * </p>
 *
 * @author yu hao
 * @since 2021-05-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TdmTopGoodsCloudChartDf implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 展示维度:流域城市船闸
     */
    private String showDimension;

    /**
     * 流域城市船闸下级值
     */
    private String dimensionValues;

    /**
     * 航向收发
     */
    private String countType;

    /**
     * 货物名称
     */
    private String goodsName;

    /**
     * 货量
     */
    private String crgDdwghtTns;


}
