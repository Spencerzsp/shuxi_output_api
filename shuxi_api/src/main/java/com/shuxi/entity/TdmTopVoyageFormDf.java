package com.shuxi.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 西江流域31大航航线
 * </p>
 *
 * @author yu hao
 * @since 2021-05-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TdmTopVoyageFormDf implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 年份
     */
    private String countYear;

    /**
     * 出发地
     */
    private String dprtPt;

    /**
     * 抵达地
     */
    private String arrPt;

    /**
     * 运力
     */
    private String nclsCrryTns;

    /**
     * 货量
     */
    private String crgDdwghtTns;

    /**
     * 占比
     */
    private String proportion;


}
