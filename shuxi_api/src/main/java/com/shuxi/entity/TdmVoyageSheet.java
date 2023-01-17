package com.shuxi.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 航线表前30大航线的表格
 * </p>
 *
 * @author yu hao
 * @since 2021-05-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TdmVoyageSheet implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 航向
     */
    private String cursCd;
    /**
     * 出发地
     */
    private String dprtPt;

    /**
     * 抵达地
     */
    private String arrPt;

    /**
     * 货量
     */
    private String crgDdwghtTns;

    /**
     * 实载
     */
    private String nclsCrryTns;

    /**
     * 占比
     */
    private String proportion;

    /**
     * 同比
     */
    private String yearOnYearBasis;


}
