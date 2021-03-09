package cn.hmxz.modules.lit.service;


import cn.hmxz.modules.lit.entity.UserHistory;

import java.util.List;

/**
 * 用户足迹表(UserHistory)表服务接口
 *
 * @author liangjiang
 * @since 2020-12-19 14:26:10
 */
public interface UserHistoryService {

    /**
     * 通过ID查询单条数据
     *
     * @param hisId 主键
     * @return 实例对象
     */
    UserHistory queryById(Long hisId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<UserHistory> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param userHistory 实例对象
     * @return 实例对象
     */
    UserHistory insert(UserHistory userHistory);

    /**
     * 修改数据
     *
     * @param userHistory 实例对象
     * @return 实例对象
     */
    UserHistory update(UserHistory userHistory);

    /**
     * 通过主键删除数据
     *
     * @param hisId 主键
     * @return 是否成功
     */
    boolean deleteById(Long hisId);

}