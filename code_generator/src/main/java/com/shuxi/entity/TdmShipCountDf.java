package com.shuxi.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 船舶艘数
 * </p>
 *
 * @author yu hao
 * @since 2021-05-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TdmShipCountDf implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 船舶艘数
     */
    private String amount;


}
