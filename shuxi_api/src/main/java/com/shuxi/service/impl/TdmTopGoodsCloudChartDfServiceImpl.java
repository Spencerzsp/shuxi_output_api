package com.shuxi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shuxi.dto.TdmTopGoodsCloudChartDfDTO;
import com.shuxi.entity.TdmTopGoodsCloudChartDf;
import com.shuxi.mapper.TdmTopGoodsCloudChartDfMapper;
import com.shuxi.service.ITdmTopGoodsCloudChartDfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 货物云图 服务实现类
 * </p>
 *
 * @author yu hao
 * @since 2021-05-21
 */
@Service
public class TdmTopGoodsCloudChartDfServiceImpl extends ServiceImpl<TdmTopGoodsCloudChartDfMapper, TdmTopGoodsCloudChartDf> implements ITdmTopGoodsCloudChartDfService {
    @Autowired
    private TdmTopGoodsCloudChartDfMapper tdmTopGoodsCloudChartDfMapper;
    @Override
    public List<TdmTopGoodsCloudChartDfDTO> getGetOrSendGoodsInfo() {
        return tdmTopGoodsCloudChartDfMapper.getGetOrSendGoodsInfo();
    }
}
