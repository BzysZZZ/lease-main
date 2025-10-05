package com.qianlou.admin.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qianlou.admin.vo.appointment.AppointmentQueryVo;
import com.qianlou.admin.vo.appointment.AppointmentVo;
import com.qianlou.model.entity.ViewAppointment;

/**
* @description 针对表【view_appointment(预约看房信息表)】的数据库操作Mapper
*/
public interface ViewAppointmentMapper extends BaseMapper<ViewAppointment> {

    IPage<AppointmentVo> getAppointmentByQueryForPage(IPage<AppointmentVo> page, AppointmentQueryVo queryVo);

}




