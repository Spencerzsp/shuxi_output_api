package com.shuxi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shuxi.dto.TdmTopGoodsCloudChartDfDTO;
import com.shuxi.entity.TdmTopGoodsCloudChartDf;

import java.util.List;

/**
 * <p>
 * 货物云图 Mapper 接口
 * </p>
 *
 * @author yu hao
 * @since 2021-05-21
 */
public interface TdmTopGoodsCloudChartDfMapper extends BaseMapper<TdmTopGoodsCloudChartDf> {
    List<TdmTopGoodsCloudChartDfDTO> getGetOrSendGoodsInfo();
}
