package com.qianlou.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qianlou.admin.mapper.GraphInfoMapper;
import com.qianlou.admin.service.GraphInfoService;
import com.qianlou.model.entity.GraphInfo;
import org.springframework.stereotype.Service;

/**
* @description 针对表【graph_info(图片信息表)】的数据库操作Service实现
*/
@Service
public class GraphInfoServiceImpl extends ServiceImpl<GraphInfoMapper, GraphInfo>
    implements GraphInfoService {

}




