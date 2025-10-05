package com.qianlou.admin.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qianlou.admin.vo.agreement.AgreementQueryVo;
import com.qianlou.admin.vo.agreement.AgreementVo;
import com.qianlou.model.entity.LeaseAgreement;

/**
* @description 针对表【lease_agreement(租约信息表)】的数据库操作Service
*/
public interface LeaseAgreementService extends IService<LeaseAgreement> {

    IPage<AgreementVo> getAgreementByQueryForPage(IPage<AgreementVo> page, AgreementQueryVo queryVo);

    AgreementVo getAgreementById(Long id);

}
