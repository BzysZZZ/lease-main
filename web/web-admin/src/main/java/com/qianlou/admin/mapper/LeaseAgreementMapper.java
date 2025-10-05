package com.qianlou.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qianlou.admin.vo.agreement.AgreementQueryVo;
import com.qianlou.admin.vo.agreement.AgreementVo;
import com.qianlou.model.entity.LeaseAgreement;

/**
* @description 表【lease_agreement(租约信息表)】Mapper
*/
public interface LeaseAgreementMapper extends BaseMapper<LeaseAgreement> {

    IPage<AgreementVo> getAgreementByQueryForPage(IPage<AgreementVo> page, AgreementQueryVo queryVo);

}




