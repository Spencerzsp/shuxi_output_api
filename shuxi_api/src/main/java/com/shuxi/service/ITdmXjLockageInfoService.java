package com.shuxi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shuxi.dto.TdmXjLockageInfoDTO;
import com.shuxi.entity.TdmXjLockageInfo;

import java.util.List;

/**
 * <p>
 * 西江流域船闸过闸数据 服务类
 * </p>
 *
 * @author yu hao
 * @since 2021-05-25
 */
public interface ITdmXjLockageInfoService extends IService<TdmXjLockageInfo> {
    List<TdmXjLockageInfoDTO> getNowAndPast();
}
