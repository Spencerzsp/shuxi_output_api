package com.shuxi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shuxi.dto.TdmPaymentMethodDistributionDfDTO;
import com.shuxi.entity.TdmPaymentMethodDistributionDf;

import java.util.List;

/**
 * <p>
 * 缴费方式分布表 服务类
 * </p>
 *
 * @author yu hao
 * @since 2021-05-26
 */
public interface ITdmPaymentMethodDistributionDfService extends IService<TdmPaymentMethodDistributionDf> {
    List<TdmPaymentMethodDistributionDfDTO> getOnlineAndTotal();
}
