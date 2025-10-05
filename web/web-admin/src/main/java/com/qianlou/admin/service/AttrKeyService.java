package com.qianlou.admin.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.qianlou.admin.vo.attr.AttrKeyVo;
import com.qianlou.model.entity.AttrKey;

import java.util.List;

/**
* @description 针对表【attr_key(房间基本属性表)】的数据库操作Service
*/
public interface AttrKeyService extends IService<AttrKey> {

    List<AttrKeyVo> listAttrInfo();

}
