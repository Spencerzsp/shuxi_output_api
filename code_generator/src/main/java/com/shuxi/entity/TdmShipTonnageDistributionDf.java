package com.shuxi.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 西江流域船舶吨位分布图
 * </p>
 *
 * @author yu hao
 * @since 2021-05-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TdmShipTonnageDistributionDf implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 船舶吨位
     */
    private String shipTonnage;

    /**
     * 船舶艘数
     */
    private String amount;

    /**
     * 所占比例
     */
    private String proportion;


}
