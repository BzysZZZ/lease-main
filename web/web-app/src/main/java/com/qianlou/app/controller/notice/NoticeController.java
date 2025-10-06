package com.qianlou.app.controller.notice;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qianlou.app.service.NoticeInfoService;
import com.qianlou.app.vo.NoticeItemVo;
import com.qianlou.app.vo.room.RoomItemVo;
import com.qianlou.app.vo.room.RoomQueryVo;
import com.qianlou.common.result.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name="变更通知管理")
@RequestMapping("/app/notice")
public class NoticeController {

    @Resource
    NoticeInfoService noticeInfoService;

    @Operation(summary = "分页查询通知列表")
    @GetMapping("pageNotice")
    public Result<IPage<NoticeItemVo>> pageItem(@RequestParam long current, @RequestParam long size, @RequestParam Long userId) {
        Page<NoticeItemVo> page = new Page<>(current, size);
        IPage<NoticeItemVo> list= noticeInfoService.getNoticeItemForPage(page,userId);
        return Result.ok(list);
    }

}
