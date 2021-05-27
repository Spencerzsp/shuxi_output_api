package com.shuxi.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 航线信息表
 * </p>
 *
 * @author yu hao
 * @since 2021-05-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TdmVoyageInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 广东，广西，总数，今年新增航线数
     */
    private String target;

    /**
     * 数值
     */
    private String targetValue;


}
