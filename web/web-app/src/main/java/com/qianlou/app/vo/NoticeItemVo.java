package com.qianlou.app.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "通知列表展示Vo")
public class NoticeItemVo {

    @Schema(description = "通知ID")
    public Long id;

    @Schema(description = "通知标题")
    private String title;

    @Schema(description = "通知内容")
    private String content;

    @Schema(description = "通知类型文本描述（租户通知/管理员通知）")
    private String noticeTypeDesc;

    @Schema(description = "阅读状态（0-未读，1-已读）")
    private Integer readStatus;


}
