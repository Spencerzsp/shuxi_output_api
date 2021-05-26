package com.shuxi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shuxi.dto.TdmPastYearLokageBasinGoodsDfDTO;
import com.shuxi.entity.TdmPastYearLokageBasinGoodsDf;

import java.util.List;

/**
 * <p>
 * 流域船闸货运量趋势图 Mapper 接口
 * </p>
 *
 * @author yu hao
 * @since 2021-05-21
 */
public interface TdmPastYearLokageBasinGoodsDfMapper extends BaseMapper<TdmPastYearLokageBasinGoodsDf> {
    List<TdmPastYearLokageBasinGoodsDfDTO> getUpAndDownCrgDdwghtTns();
}
