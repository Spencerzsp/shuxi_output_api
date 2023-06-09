package com.shuxi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shuxi.dto.TdmPastYearLokageBasinGoodsDfDTO;
import com.shuxi.dto.TdmPastYearLokageBasinGoodsIncrementDfDTO;
import com.shuxi.entity.TdmPastYearLokageBasinGoodsIncreaseDf;

import java.util.List;

/**
 * <p>
 * 流域船闸货运量趋势图同比 Mapper 接口
 * </p>
 *
 * @author yu hao
 * @since 2021-05-21
 */
public interface TdmPastYearLokageBasinGoodsIncreaseDfMapper extends BaseMapper<TdmPastYearLokageBasinGoodsIncreaseDf> {
    List<TdmPastYearLokageBasinGoodsIncrementDfDTO> getUpAndDownCrgDdwghtTns();
}
