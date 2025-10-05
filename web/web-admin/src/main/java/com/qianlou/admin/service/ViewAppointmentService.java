package com.qianlou.admin.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qianlou.admin.vo.appointment.AppointmentQueryVo;
import com.qianlou.admin.vo.appointment.AppointmentVo;
import com.qianlou.model.entity.ViewAppointment;

/**
* @description 针对表【view_appointment(预约看房信息表)】的数据库操作Service
*/
public interface ViewAppointmentService extends IService<ViewAppointment> {

    IPage<AppointmentVo> getAppointmentByQueryForPage(IPage<AppointmentVo> page, AppointmentQueryVo queryVo);

}
