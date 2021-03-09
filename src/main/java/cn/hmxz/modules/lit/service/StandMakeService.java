package cn.hmxz.modules.lit.service;


import cn.hmxz.modules.lit.entity.StandMake;

import java.util.List;

/**
 * 薪资爆料表态表(StandMake)表服务接口
 *
 * @author liangjiang
 * @since 2020-12-27 16:00:07
 */
public interface StandMakeService {

    /**
     * 通过ID查询单条数据
     *
     * @param standId 主键
     * @return 实例对象
     */
    StandMake queryById(Long standId);
    /**
     * 通过条件查询
     *
     * @param standMake standMake
     * @return 实例对象
     */
    List<StandMake> queryStandByCondition(StandMake standMake);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<StandMake> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param standMake 实例对象
     * @return 实例对象
     */
    StandMake insert(StandMake standMake);

    /**
     * 修改数据
     *
     * @param standMake 实例对象
     * @return 实例对象
     */
    StandMake update(StandMake standMake);

    /**
     * 通过主键删除数据
     *
     * @param standId 主键
     * @return 是否成功
     */
    boolean deleteById(Long standId);

}