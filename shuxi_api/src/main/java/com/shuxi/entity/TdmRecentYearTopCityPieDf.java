package com.shuxi.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 西江流域今年/去年前31大出发地目的地饼图
 * </p>
 *
 * @author yu hao
 * @since 2021-05-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TdmRecentYearTopCityPieDf implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 统计年份
     */
    private String countYear;

    /**
     * 出发地还是目的地
     */
    private String cityType;

    /**
     * 城市
     */
    private String city;

    /**
     * 货量
     */
    private String crgDdwghtTns;

    /**
     * 占比
     */
    private String proportion;


}
