package com.shuxi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author ZhangQi
 * @version 1.0.0
 * @ClassName TdmThisYearShipLockageTypeDfDTO.java
 * @Description TODO
 * @createTime 2021年05月24日 15:02:00
 */
@Data
@AllArgsConstructor
public class TdmThisYearShipLockageTypeDfDTO {
    private String showType; // 本年月
    private String lockName;
    private String bdLockageCount;
    private String ckLockageCount;
    private String totoalLockageCount;
}
