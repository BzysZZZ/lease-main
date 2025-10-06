package com.qianlou.app.controller.room;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qianlou.app.service.RoomInfoService;
import com.qianlou.app.vo.room.RoomDetailVo;
import com.qianlou.app.vo.room.RoomItemVo;
import com.qianlou.app.vo.room.RoomQueryVo;
import com.qianlou.common.result.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "房间信息")
@RestController
@RequestMapping("/app/room")
public class RoomController {

    @Resource
    private RoomInfoService roomInfoService;

    @Operation(summary = "分页查询房间列表")
    @GetMapping("pageItem")
    public Result<IPage<RoomItemVo>> pageItem(@RequestParam long current, @RequestParam long size, RoomQueryVo queryVo) {
        Page<RoomItemVo> page = new Page<>(current, size);
        IPage<RoomItemVo> list = roomInfoService.getRoomItemByQueryForPage(page, queryVo);
        return Result.ok(list);
    }

    @Operation(summary = "根据id获取房间的详细信息")
    @GetMapping("getDetailById")
    public Result<RoomDetailVo> getDetailById(@RequestParam Long id) {
        RoomDetailVo roomDetailVo = roomInfoService.getRoomDetailById(id);
        return Result.ok(roomDetailVo);
    }

    @Operation(summary = "根据公寓id分页查询房间列表")
    @GetMapping("pageItemByApartmentId")
    public Result<IPage<RoomItemVo>> pageItemByApartmentId(@RequestParam long current,
                                                           @RequestParam long size,
                                                           @RequestParam Long id) {
        Page<RoomItemVo> page = new Page<>(current, size);
        IPage<RoomItemVo> list = roomInfoService.pageItemByApartmentId(page, id);
        return Result.ok(list);
    }
    
    /**
     * 获取热门房间列表
     * @param limit 返回的房间数量上限，默认值为10
     * @return 返回包含热门房间列表的Result对象，其中数据为RoomItemVo列表
     */
    @Operation(summary = "获取热门房间列表")  // Swagger API操作注解，用于API文档描述
    @GetMapping("getHotRooms")
    public Result<List<RoomItemVo>> getHotRooms(@RequestParam(defaultValue = "10") int limit) {
        List<RoomItemVo> hotRooms = roomInfoService.getHotRooms(limit);
        return Result.ok(hotRooms);
    }

}
