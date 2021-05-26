package com.shuxi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shuxi.dto.TdmPastYearLokageBasinGoodsDfDTO;
import com.shuxi.entity.TdmPastYearLokageBasinGoodsDf;
import com.shuxi.mapper.TdmPastYearLokageBasinGoodsDfMapper;
import com.shuxi.service.ITdmPastYearLokageBasinGoodsDfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 流域船闸货运量趋势图 服务实现类
 * </p>
 *
 * @author yu hao
 * @since 2021-05-21
 */
@Service
public class TdmPastYearLokageBasinGoodsDfServiceImpl extends ServiceImpl<TdmPastYearLokageBasinGoodsDfMapper, TdmPastYearLokageBasinGoodsDf> implements ITdmPastYearLokageBasinGoodsDfService {
    @Autowired
    private TdmPastYearLokageBasinGoodsDfMapper tdmPastYearLokageBasinGoodsDfMapper;
    @Override
    public List<TdmPastYearLokageBasinGoodsDfDTO> getUpAndDownCrgDdwghtTns() {
        return tdmPastYearLokageBasinGoodsDfMapper.getUpAndDownCrgDdwghtTns();
    }
}
