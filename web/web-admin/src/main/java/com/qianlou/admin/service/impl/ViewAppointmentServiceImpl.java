package com.qianlou.admin.service.impl;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qianlou.admin.mapper.ViewAppointmentMapper;
import com.qianlou.admin.service.ViewAppointmentService;
import com.qianlou.admin.vo.appointment.AppointmentQueryVo;
import com.qianlou.admin.vo.appointment.AppointmentVo;
import com.qianlou.model.entity.ViewAppointment;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @description 针对表【view_appointment(预约看房信息表)】的数据库操作Service实现
 */
@Service
public class ViewAppointmentServiceImpl extends ServiceImpl<ViewAppointmentMapper, ViewAppointment>
        implements ViewAppointmentService {

    @Resource
    private ViewAppointmentMapper viewAppointmentMapper;

    @Override
    public IPage<AppointmentVo> getAppointmentByQueryForPage(IPage<AppointmentVo> page, AppointmentQueryVo queryVo) {
        return viewAppointmentMapper.getAppointmentByQueryForPage(page, queryVo);
    }
}




