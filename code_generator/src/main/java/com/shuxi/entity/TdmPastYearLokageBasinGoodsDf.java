package com.shuxi.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 流域船闸货运量趋势图
 * </p>
 *
 * @author yu hao
 * @since 2021-05-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TdmPastYearLokageBasinGoodsDf implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 展示维度(船闸/流域)
     */
    private String showDimension;

    /**
     * 放闸月份
     */
    private String fzDate;

    /**
     * 流域船闸下级值
     */
    private String dimensionValues;

    /**
     * 航向
     */
    private String cursCd;

    /**
     * 货量
     */
    private String crgDdwghtTns;


}
