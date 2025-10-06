package com.qianlou.app.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qianlou.app.mapper.NoticeInfoMapper;
import com.qianlou.app.service.NoticeInfoService;
import com.qianlou.app.vo.NoticeItemVo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class NoticeInfoServiceImpl implements NoticeInfoService {

    @Resource
    NoticeInfoMapper noticeInfoMapper;


    public IPage<NoticeItemVo> getNoticeItemForPage(Page<NoticeItemVo> page, Long userId) {
        return noticeInfoMapper.getNoticeItem(page, userId);
    }
}
