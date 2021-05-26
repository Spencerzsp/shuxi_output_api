package com.shuxi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shuxi.dto.TdmPaymentMethodDistributionDfDTO;
import com.shuxi.entity.TdmPaymentMethodDistributionDf;

import java.util.List;

/**
 * <p>
 * 缴费方式分布表 Mapper 接口
 * </p>
 *
 * @author yu hao
 * @since 2021-05-26
 */
public interface TdmPaymentMethodDistributionDfMapper extends BaseMapper<TdmPaymentMethodDistributionDf> {
    List<TdmPaymentMethodDistributionDfDTO> getOnlineAndTotal();
}
