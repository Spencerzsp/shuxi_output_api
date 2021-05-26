package com.shuxi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shuxi.dto.TdmTopGoodsCloudChartDfDTO;
import com.shuxi.entity.TdmTopGoodsCloudChartDf;

import java.util.List;

/**
 * <p>
 * 货物云图 服务类
 * </p>
 *
 * @author yu hao
 * @since 2021-05-21
 */
public interface ITdmTopGoodsCloudChartDfService extends IService<TdmTopGoodsCloudChartDf> {
    List<TdmTopGoodsCloudChartDfDTO> getGetOrSendGoodsInfo();
}
