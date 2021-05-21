package com.shuxi.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 西江流域各船闸货物统计
 * </p>
 *
 * @author yu hao
 * @since 2021-05-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TdmEachLokageBasinTopGoodsDf implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 展示维度(船闸/流域)
     */
    private String showDimension;

    /**
     * 流域船闸下级值
     */
    private String dimensionValues;

    /**
     * 航向
     */
    private String cursCd;

    /**
     * 货物名称
     */
    private String goodsName;

    /**
     * 货量
     */
    private String crgDdwghtTns;

    /**
     * 占比
     */
    private String proportion;


}
