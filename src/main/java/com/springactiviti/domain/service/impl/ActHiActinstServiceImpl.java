package com.springactiviti.domain.service.impl;

import com.springactiviti.domain.entity.ActHiActinst;
import com.springactiviti.domain.dao.ActHiActinstDao;
import com.springactiviti.domain.service.ActHiActinstService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ActHiActinst)表服务实现类
 *
 * @author makejava
 * @since 2020-04-08 20:46:23
 */
@Service("actHiActinstService")
public class ActHiActinstServiceImpl implements ActHiActinstService {
    @Resource
    private ActHiActinstDao actHiActinstDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id_ 主键
     * @return 实例对象
     */
    @Override
    public ActHiActinst queryById(String id_) {
        return this.actHiActinstDao.queryById(id_);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ActHiActinst> queryAllByLimit(int offset, int limit) {
        return this.actHiActinstDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param actHiActinst 实例对象
     * @return 实例对象
     */
    @Override
    public ActHiActinst insert(ActHiActinst actHiActinst) {
        this.actHiActinstDao.insert(actHiActinst);
        return actHiActinst;
    }

    /**
     * 修改数据
     *
     * @param actHiActinst 实例对象
     * @return 实例对象
     */
    @Override
    public ActHiActinst update(ActHiActinst actHiActinst) {
        this.actHiActinstDao.update(actHiActinst);
        return this.queryById(actHiActinst.getId_());
    }

    /**
     * 通过主键删除数据
     *
     * @param id_ 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id_) {
        return this.actHiActinstDao.deleteById(id_) > 0;
    }
}