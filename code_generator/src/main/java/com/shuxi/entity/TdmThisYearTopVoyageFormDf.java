package com.shuxi.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
public class TdmThisYearTopVoyageFormDf implements Serializable {

    private static final long serialVersionUID = 1L;

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


}
