package com.shuxi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shuxi.dto.TdmXjLockageInfoDTO;
import com.shuxi.entity.TdmXjLockageInfo;

import java.util.List;

/**
 * <p>
 * 西江流域船闸过闸数据 Mapper 接口
 * </p>
 *
 * @author yu hao
 * @since 2021-05-25
 */
public interface TdmXjLockageInfoMapper extends BaseMapper<TdmXjLockageInfo> {
    List<TdmXjLockageInfoDTO> getNowAndPast();
}
