package com.shuxi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shuxi.dto.TdmThisYearEachShiplockForecastDfDTO;
import com.shuxi.entity.TdmThisYearEachShiplockForecastDf;
import com.shuxi.mapper.TdmThisYearEachShiplockForecastDfMapper;
import com.shuxi.service.ITdmThisYearEachShiplockForecastDfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 各船闸(本年)预测过闸数据 服务实现类
 * </p>
 *
 * @author yu hao
 * @since 2021-05-21
 */
@Service
public class TdmThisYearEachShiplockForecastDfServiceImpl extends ServiceImpl<TdmThisYearEachShiplockForecastDfMapper, TdmThisYearEachShiplockForecastDf> implements ITdmThisYearEachShiplockForecastDfService {
    @Autowired
    private TdmThisYearEachShiplockForecastDfMapper tdmThisYearEachShiplockForecastDfMapper;
    @Override
    public List<TdmThisYearEachShiplockForecastDfDTO> getForecastAndActual() {
        return tdmThisYearEachShiplockForecastDfMapper.getForecastAndActual();
    }
}
