package cn.hmxz.modules.lit.dao;

import cn.hmxz.modules.lit.entity.WorkCity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 工作城市(WorkCity)表数据库访问层
 *
 * @author liangjiang
 * @since 2020-12-19 14:26:12
 */
@Mapper
public interface WorkCityDao {

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
     * @return 对象列表
     */
    List<String> queryDistinctCity();

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<WorkCity> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 查询多条数据
     *
     * @param cityName 城市名
     * @return 对象列表
     */
    List<Long> queryInfoIdByCity(@Param("cityName") String cityName);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param workCity 实例对象
     * @return 对象列表
     */
    List<WorkCity> queryAll(WorkCity workCity);

    /**
     * 新增数据
     *
     * @param workCity 实例对象
     * @return 影响行数
     */
    int insert(WorkCity workCity);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<WorkCity> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<WorkCity> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<WorkCity> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<WorkCity> entities);

    /**
     * 修改数据
     *
     * @param workCity 实例对象
     * @return 影响行数
     */
    int update(WorkCity workCity);

    /**
     * 通过主键删除数据
     *
     * @param cityId 主键
     * @return 影响行数
     */
    int deleteById(Long cityId);

}