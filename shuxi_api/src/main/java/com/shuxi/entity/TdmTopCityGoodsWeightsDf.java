package com.shuxi.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 2021年热门城市货量
 * </p>
 *
 * @author yu hao
 * @since 2021-05-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TdmTopCityGoodsWeightsDf implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 城市
     */
    private String city;

    /**
     * 发货货量
     */
    private String dprtCrgDdwghtTns;

    /**
     * 收货货量
     */
    private String arrTypeCrgDdwghtTns;


}
