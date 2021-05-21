package com.shuxi.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 西江主干线货运指数表
 * </p>
 *
 * @author yu hao
 * @since 2021-05-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TdmXjMainLineFreightRateDf implements Serializable {

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
     * 年月
     */
    private String monthDate;

    /**
     * 上行指数
     */
    private String upRate;

    /**
     * 上行货运量
     */
    private String upFreightVolume;

    /**
     * 上行核载量
     */
    private String upNuclearCapacity;

    /**
     * 上行装载率
     */
    private String upLoadingRate;

    /**
     * 下行指数
     */
    private String downRate;

    /**
     * 下行货运量
     */
    private String downFreightVolume;

    /**
     * 下行核载量
     */
    private String downNuclearCapacity;

    /**
     * 下行装载率
     */
    private String downLoadingRate;


}
