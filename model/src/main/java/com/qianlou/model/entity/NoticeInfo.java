package com.qianlou.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
@TableName(value = "notice")
@Schema(description = "租约状态变更通知表")
public class NoticeInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;


    @NotNull(message="[关联用户ID]不能为空")
    @Schema(description = "关联用户ID")
    @TableField(value = "user_id")
    private Long userId;

    @NotNull(message="[通知类型,1-租户通知，2-管理员通知]不能为空")
    @Schema(description = "通知类型,1-租户通知，2-管理员通知")
    @TableField(value="notice_type")
    private Integer noticeType;
    /**
    * 通知标题
    */

    @TableField(value = "title")
    @Schema(description = "通知标题")
    private String title;

    @Schema(description = "通知内容")
    @TableField(value = "content")
    private String content;

    @NotNull(message="[阅读状态:0未读]不能为空")
    @Schema(description = "阅读状态,0未读,1已读")
    @TableField(value = "read_status")
    private Integer readStatus;

    @Schema(description = "关联租约ID")
    @TableField(value = "lease_id")
    private Long leaseId;

    @TableField(value = "remark")
    @Schema(description = "操作备注")
    private String remark;

}
