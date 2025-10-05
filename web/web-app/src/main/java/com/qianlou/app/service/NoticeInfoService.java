package com.qianlou.app.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qianlou.app.vo.NoticeItemVo;
import org.springframework.stereotype.Service;

@Service
public interface NoticeInfoService {
    IPage<NoticeItemVo> getNoticeItemForPage(Page<NoticeItemVo> page, Long userId);
}
