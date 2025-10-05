package com.qianlou.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qianlou.admin.mapper.LeaseTermMapper;
import com.qianlou.admin.service.LeaseTermService;
import com.qianlou.model.entity.LeaseTerm;
import org.springframework.stereotype.Service;

/**
* @description 针对表【lease_term(租期)】的数据库操作Service实现
*/
@Service
public class LeaseTermServiceImpl extends ServiceImpl<LeaseTermMapper, LeaseTerm>
    implements LeaseTermService {

}




