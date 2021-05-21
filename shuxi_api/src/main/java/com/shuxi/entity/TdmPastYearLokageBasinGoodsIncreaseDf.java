package com.shuxi.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 流域船闸货运量趋势图同比
 * </p>
 *
 * @author yu hao
 * @since 2021-05-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TdmPastYearLokageBasinGoodsIncreaseDf implements Serializable {

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
     * 同比
     */
    private String yearIncrease;


}
