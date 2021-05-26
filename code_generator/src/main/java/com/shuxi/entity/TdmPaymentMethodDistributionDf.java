package com.shuxi.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 缴费方式分布表
 * </p>
 *
 * @author yu hao
 * @since 2021-05-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TdmPaymentMethodDistributionDf implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 枢纽id
     */
    private String snid;

    /**
     * 现金金额
     */
    private String cashAmount;

    /**
     * 现金次数
     */
    private String cashCount;

    /**
     * 刷卡金额
     */
    private String swipingCardAmount;

    /**
     * 刷卡次数
     */
    private String swipingCardCount;

    /**
     * 西江e支付金额
     */
    private String ePayAmount;

    /**
     * 西江e支付次数
     */
    private String ePayCount;

    /**
     * 微信，支付宝金额
     */
    private String wxZfbAmount;

    /**
     * 微信，支付宝次数
     */
    private String wxZfbCount;

    /**
     * 托收金额
     */
    private String collectionAmount;

    /**
     * 托收次数
     */
    private String collectionCount;

    /**
     * 总金额
     */
    private String totalAmount;

    /**
     * 总次数
     */
    private String totalCount;


}
