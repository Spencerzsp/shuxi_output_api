package com.shuxi.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 城市经纬度对应关系表
 * </p>
 *
 * @author yu hao
 * @since 2021-05-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class DimCityPosition implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 城市
     */
    private String city;

    /**
     * 经度
     */
    private String longitude;

    /**
     * 纬度
     */
    private String latitude;


}
