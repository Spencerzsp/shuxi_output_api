package com.shuxi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shuxi.dto.TdmThisYearShipLockageTypeDfDTO;
import com.shuxi.entity.TdmThisYearShipLockageTypeDf;
import com.shuxi.mapper.TdmThisYearShipLockageTypeDfMapper;
import com.shuxi.service.ITdmThisYearShipLockageTypeDfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 船舶(本年)报道方式统计 服务实现类
 * </p>
 *
 * @author yu hao
 * @since 2021-05-21
 */
@Service
public class TdmThisYearShipLockageTypeDfServiceImpl extends ServiceImpl<TdmThisYearShipLockageTypeDfMapper, TdmThisYearShipLockageTypeDf> implements ITdmThisYearShipLockageTypeDfService {
    @Autowired
    private TdmThisYearShipLockageTypeDfMapper tdmThisYearShipLockageTypeDfMapper;
    @Override
    public TdmThisYearShipLockageTypeDfDTO getTdmThisYearShipLockageTypeDfDTO() {
        return tdmThisYearShipLockageTypeDfMapper.getThisYearBdLockageCount();
    }
}
