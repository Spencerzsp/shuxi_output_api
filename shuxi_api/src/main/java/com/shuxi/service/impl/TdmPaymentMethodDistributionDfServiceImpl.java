package com.shuxi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shuxi.dto.TdmPaymentMethodDistributionDfDTO;
import com.shuxi.entity.TdmPaymentMethodDistributionDf;
import com.shuxi.mapper.TdmPaymentMethodDistributionDfMapper;
import com.shuxi.service.ITdmPaymentMethodDistributionDfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 缴费方式分布表 服务实现类
 * </p>
 *
 * @author yu hao
 * @since 2021-05-26
 */
@Service
public class TdmPaymentMethodDistributionDfServiceImpl extends ServiceImpl<TdmPaymentMethodDistributionDfMapper, TdmPaymentMethodDistributionDf> implements ITdmPaymentMethodDistributionDfService {
    @Autowired
    private TdmPaymentMethodDistributionDfMapper tdmPaymentMethodDistributionDfMapper;
    @Override
    public List<TdmPaymentMethodDistributionDfDTO> getOnlineAndTotal() {
        return tdmPaymentMethodDistributionDfMapper.getOnlineAndTotal();
    }
}
