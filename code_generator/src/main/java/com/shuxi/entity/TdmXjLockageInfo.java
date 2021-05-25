package com.shuxi.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 西江流域船闸过闸数据
 * </p>
 *
 * @author yu hao
 * @since 2021-05-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TdmXjLockageInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 今年/去年
     */
    private String target;

    /**
     * 年份
     */
    private String year;

    /**
     * 船闸
     */
    private String snid;

    /**
     * 同期总吨
     */
    private String tonnage;

    /**
     * 同期闸次
     */
    private String gateTimes;

    /**
     * 同期核载
     */
    private String nclsCrryTns;

    /**
     * 同期实载
     */
    private String crgDdwghtTns;

    /**
     * 艘次
     */
    private String czCount;

    /**
     * 过闸费
     */
    private String actFeePd;


}
