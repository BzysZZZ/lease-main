package com.qianlou.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qianlou.admin.mapper.SystemPostMapper;
import com.qianlou.admin.service.SystemPostService;
import com.qianlou.model.entity.SystemPost;
import org.springframework.stereotype.Service;

/**
* @description 针对表【system_post(岗位信息表)】的数据库操作Service实现
*/
@Service
public class SystemPostServiceImpl extends ServiceImpl<SystemPostMapper, SystemPost>
    implements SystemPostService {

}




