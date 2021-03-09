package cn.hmxz.modules.lit.dao;

import cn.hmxz.modules.lit.entity.StandMake;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 薪资爆料表态表(StandMake)表数据库访问层
 *
 * @author liangjiang
 * @since 2020-12-27 16:00:07
 */
@Mapper
public interface StandMakeDao {

    /**
     * 通过ID查询单条数据
     *
     * @param standId 主键
     * @return 实例对象
     */
    StandMake queryById(Long standId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<StandMake> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param standMake 实例对象
     * @return 对象列表
     */
    List<StandMake> queryAll(StandMake standMake);

    /**
     * 新增数据
     *
     * @param standMake 实例对象
     * @return 影响行数
     */
    int insert(StandMake standMake);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<StandMake> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<StandMake> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<StandMake> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<StandMake> entities);

    /**
     * 修改数据
     *
     * @param standMake 实例对象
     * @return 影响行数
     */
    int update(StandMake standMake);

    /**
     * 通过主键删除数据
     *
     * @param standId 主键
     * @return 影响行数
     */
    int deleteById(Long standId);

}