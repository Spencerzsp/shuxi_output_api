package com.shuxi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shuxi.dto.TdmThisYearEachShiplockForecastDfDTO;
import com.shuxi.entity.TdmThisYearEachShiplockForecastDf;

import java.util.List;

/**
 * <p>
 * 各船闸(本年)预测过闸数据 Mapper 接口
 * </p>
 *
 * @author yu hao
 * @since 2021-05-21
 */
public interface TdmThisYearEachShiplockForecastDfMapper extends BaseMapper<TdmThisYearEachShiplockForecastDf> {
    List<TdmThisYearEachShiplockForecastDfDTO> getForecastAndActual();
}
