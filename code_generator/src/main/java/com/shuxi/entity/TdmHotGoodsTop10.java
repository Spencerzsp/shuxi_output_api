package com.shuxi.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 上个月累计货运量
 * </p>
 *
 * @author yu hao
 * @since 2021-05-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TdmHotGoodsTop10 implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 维度
     */
    private String target;

    /**
     * 维度下级值
     */
    private String targetName;

    /**
     * 货物名
     */
    private String goodsName;

    /**
     * 占比
     */
    private String propertion;


}
