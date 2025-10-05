package com.qianlou.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qianlou.admin.mapper.LabelInfoMapper;
import com.qianlou.admin.service.LabelInfoService;
import com.qianlou.model.entity.LabelInfo;
import org.springframework.stereotype.Service;

/**
* @description 针对表【label_info(标签信息表)】的数据库操作Service实现
*/
@Service
public class LabelInfoServiceImpl extends ServiceImpl<LabelInfoMapper, LabelInfo>
    implements LabelInfoService {

}




