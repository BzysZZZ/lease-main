package com.qianlou.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qianlou.app.vo.NoticeItemVo;
import com.qianlou.model.entity.NoticeInfo;

public interface NoticeInfoMapper extends BaseMapper<NoticeInfo> {
    IPage<NoticeItemVo> getNoticeItem(Page<NoticeItemVo> page,Long userId);
}
