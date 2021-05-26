package com.shuxi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shuxi.dto.TdmPastYearLokageBasinGoodsIncrementDfDTO;
import com.shuxi.entity.TdmPastYearLokageBasinGoodsIncreaseDf;
import com.shuxi.mapper.TdmPastYearLokageBasinGoodsDfMapper;
import com.shuxi.mapper.TdmPastYearLokageBasinGoodsIncreaseDfMapper;
import com.shuxi.service.ITdmPastYearLokageBasinGoodsIncreaseDfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 流域船闸货运量趋势图同比 服务实现类
 * </p>
 *
 * @author yu hao
 * @since 2021-05-21
 */
@Service
public class TdmPastYearLokageBasinGoodsIncreaseDfServiceImpl extends ServiceImpl<TdmPastYearLokageBasinGoodsIncreaseDfMapper, TdmPastYearLokageBasinGoodsIncreaseDf> implements ITdmPastYearLokageBasinGoodsIncreaseDfService {
    @Autowired
    private TdmPastYearLokageBasinGoodsIncreaseDfMapper tdmPastYearLokageBasinGoodsIncreaseDfMapper;
    @Override
    public List<TdmPastYearLokageBasinGoodsIncrementDfDTO> getUpAndDownCrgDdwghtTns() {
        return tdmPastYearLokageBasinGoodsIncreaseDfMapper.getUpAndDownCrgDdwghtTns();
    }
}
