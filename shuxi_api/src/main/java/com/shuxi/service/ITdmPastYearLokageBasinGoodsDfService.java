package com.shuxi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shuxi.dto.TdmPastYearLokageBasinGoodsDfDTO;
import com.shuxi.entity.TdmPastYearLokageBasinGoodsDf;

import java.util.List;

/**
 * <p>
 * 流域船闸货运量趋势图 服务类
 * </p>
 *
 * @author yu hao
 * @since 2021-05-21
 */
public interface ITdmPastYearLokageBasinGoodsDfService extends IService<TdmPastYearLokageBasinGoodsDf> {
    List<TdmPastYearLokageBasinGoodsDfDTO> getUpAndDownCrgDdwghtTns();
}
