package com.qianlou.admin.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qianlou.admin.vo.graph.GraphVo;
import com.qianlou.model.entity.GraphInfo;
import com.qianlou.model.enums.ItemType;

import java.util.List;

/**
* @description 表【graph_info(图片信息表)】Mapper
*/
public interface GraphInfoMapper extends BaseMapper<GraphInfo> {

    List<GraphVo> selectListByItemTypeAndId(ItemType itemType, Long itemId);
}




