package cn.hmxz.modules.lit.dao;

import cn.hmxz.modules.lit.entity.UserHistory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户足迹表(UserHistory)表数据库访问层
 *
 * @author liangjiang
 * @since 2020-12-19 14:26:09
 */
@Mapper
public interface UserHistoryDao {

    /**
     * 通过ID查询单条数据
     *
     * @param hisId 主键
     * @return 实例对象
     */
    UserHistory queryById(Long hisId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<UserHistory> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param userHistory 实例对象
     * @return 对象列表
     */
    List<UserHistory> queryAll(UserHistory userHistory);

    /**
     * 新增数据
     *
     * @param userHistory 实例对象
     * @return 影响行数
     */
    int insert(UserHistory userHistory);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<UserHistory> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<UserHistory> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<UserHistory> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<UserHistory> entities);

    /**
     * 修改数据
     *
     * @param userHistory 实例对象
     * @return 影响行数
     */
    int update(UserHistory userHistory);

    /**
     * 通过主键删除数据
     *
     * @param hisId 主键
     * @return 影响行数
     */
    int deleteById(Long hisId);

}