package com.springactiviti.domain.dao;

import com.springactiviti.domain.entity.ActHiActinst;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (ActHiActinst)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-08 20:46:21
 */
@Mapper
public interface ActHiActinstDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id_ 主键
     * @return 实例对象
     */
    ActHiActinst queryById(String id_);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ActHiActinst> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param actHiActinst 实例对象
     * @return 对象列表
     */
    List<ActHiActinst> queryAll(ActHiActinst actHiActinst);

    /**
     * 新增数据
     *
     * @param actHiActinst 实例对象
     * @return 影响行数
     */
    int insert(ActHiActinst actHiActinst);

    /**
     * 修改数据
     *
     * @param actHiActinst 实例对象
     * @return 影响行数
     */
    int update(ActHiActinst actHiActinst);

    /**
     * 通过主键删除数据
     *
     * @param id_ 主键
     * @return 影响行数
     */
    int deleteById(String id_);

}