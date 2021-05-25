package com.shuxi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shuxi.dto.TdmThisYearEachShiplockForecastDfDTO;
import com.shuxi.entity.TdmThisYearEachShiplockForecastDf;

import java.util.List;

/**
 * <p>
 * 各船闸(本年)预测过闸数据 服务类
 * </p>
 *
 * @author yu hao
 * @since 2021-05-21
 */
public interface ITdmThisYearEachShiplockForecastDfService extends IService<TdmThisYearEachShiplockForecastDf> {
    List<TdmThisYearEachShiplockForecastDfDTO> getForecastAndActual();
}
