package cn.hmxz.modules.lit.service;


import cn.hmxz.modules.lit.entity.WorkCity;

import java.util.List;

/**
 * 工作城市(WorkCity)表服务接口
 *
 * @author liangjiang
 * @since 2020-12-19 14:26:12
 */
public interface WorkCityService {

    /**
     * 通过ID查询单条数据
     *
     * @param cityId 主键
     * @return 实例对象
     */
    WorkCity queryById(Long cityId);

    /**
     * 查询多条数据
     *
     * @param cityName 城市名
     * @return 对象列表
     */
    List<Long> queryInfoIdByCity(String cityName);

    /**
     * 查询多条数据
     *
     * @return 对象列表
     */
    List<String> queryDistinctCity();

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<WorkCity> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param workCity 实例对象
     * @return 实例对象
     */
    WorkCity insert(WorkCity workCity);

    /**
     * 修改数据
     *
     * @param workCity 实例对象
     * @return 实例对象
     */
    WorkCity update(WorkCity workCity);

    /**
     * 通过主键删除数据
     *
     * @param cityId 主键
     * @return 是否成功
     */
    boolean deleteById(Long cityId);

}