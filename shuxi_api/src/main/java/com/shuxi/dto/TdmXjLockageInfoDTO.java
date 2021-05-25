package com.shuxi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TdmXjLockageInfoDTO {
    private String snid;
    private String pastTonnage;
    private String nowTonnage;
    private String pastGateTimes;
    private String nowGateTimes;
    private String pastNclsCrryTns;
    private String nowNclsCrryTns;
    private String pastCrgDdwghtTns;
    private String nowCrgDdwghtTns;
    private String pastCzCount;
    private String nowCzCount;
    private String pastActFeePd;
    private String nowActFeePd;
}
