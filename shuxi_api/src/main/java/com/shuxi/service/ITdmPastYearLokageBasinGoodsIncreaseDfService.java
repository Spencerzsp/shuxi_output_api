package com.shuxi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shuxi.dto.TdmPastYearLokageBasinGoodsIncrementDfDTO;
import com.shuxi.entity.TdmPastYearLokageBasinGoodsIncreaseDf;

import java.util.List;

/**
 * <p>
 * 流域船闸货运量趋势图同比 服务类
 * </p>
 *
 * @author yu hao
 * @since 2021-05-21
 */
public interface ITdmPastYearLokageBasinGoodsIncreaseDfService extends IService<TdmPastYearLokageBasinGoodsIncreaseDf> {
    List<TdmPastYearLokageBasinGoodsIncrementDfDTO> getUpAndDownCrgDdwghtTns();
}
