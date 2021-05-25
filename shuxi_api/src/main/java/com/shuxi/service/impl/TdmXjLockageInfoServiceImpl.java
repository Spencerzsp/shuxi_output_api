package com.shuxi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shuxi.dto.TdmXjLockageInfoDTO;
import com.shuxi.entity.TdmXjLockageInfo;
import com.shuxi.mapper.TdmXjLockageInfoMapper;
import com.shuxi.service.ITdmXjLockageInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 西江流域船闸过闸数据 服务实现类
 * </p>
 *
 * @author yu hao
 * @since 2021-05-25
 */
@Service
public class TdmXjLockageInfoServiceImpl extends ServiceImpl<TdmXjLockageInfoMapper, TdmXjLockageInfo> implements ITdmXjLockageInfoService {
    @Autowired
    private TdmXjLockageInfoMapper tdmXjLockageInfoMapper;
    @Override
    public List<TdmXjLockageInfoDTO> getNowAndPast() {
        return tdmXjLockageInfoMapper.getNowAndPast();
    }
}
