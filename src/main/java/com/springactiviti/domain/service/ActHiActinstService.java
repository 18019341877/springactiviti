package com.springactiviti.domain.service;

import com.springactiviti.domain.entity.ActHiActinst;
import java.util.List;

/**
 * (ActHiActinst)表服务接口
 *
 * @author makejava
 * @since 2020-04-08 20:46:23
 */
public interface ActHiActinstService {

    /**
     * 通过ID查询单条数据
     *
     * @param id_ 主键
     * @return 实例对象
     */
    ActHiActinst queryById(String id_);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ActHiActinst> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param actHiActinst 实例对象
     * @return 实例对象
     */
    ActHiActinst insert(ActHiActinst actHiActinst);

    /**
     * 修改数据
     *
     * @param actHiActinst 实例对象
     * @return 实例对象
     */
    ActHiActinst update(ActHiActinst actHiActinst);

    /**
     * 通过主键删除数据
     *
     * @param id_ 主键
     * @return 是否成功
     */
    boolean deleteById(String id_);

}