package com.springactiviti.domain.controller;

import com.springactiviti.domain.entity.ActHiActinst;
import com.springactiviti.domain.service.ActHiActinstService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (ActHiActinst)表控制层
 *
 * @author makejava
 * @since 2020-04-08 20:46:24
 */
@RestController
@RequestMapping("actHiActinst")
public class ActHiActinstController {
    /**
     * 服务对象
     */
    @Resource
    private ActHiActinstService actHiActinstService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public ActHiActinst selectOne(String id) {
        return this.actHiActinstService.queryById(id);
    }

}