package com.shuxi.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 各船闸本月过闸效率分析
 * </p>
 *
 * @author yu hao
 * @since 2021-05-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TdmLoackageEfficiency implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 月份
     */
    private String monthDate;

    /**
     * 枢纽id
     */
    private String snid;

    /**
     * 闸室利用率
     */
    private String lockroomUtilization;


}
