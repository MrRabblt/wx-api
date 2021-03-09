package cn.hmxz.modules.lit.dao;

import cn.hmxz.modules.lit.entity.Advertisement;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 广告表(Advertisement)表数据库访问层
 *
 * @author liangjiang
 * @since 2020-12-19 14:26:01
 */
@Mapper
public interface AdvertisementDao {

    /**
     * 通过ID查询单条数据
     *
     * @param adId 主键
     * @return 实例对象
     */
    Advertisement queryById(Long adId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Advertisement> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param advertisement 实例对象
     * @return 对象列表
     */
    List<Advertisement> queryAll(Advertisement advertisement);

    /**
     * 新增数据
     *
     * @param advertisement 实例对象
     * @return 影响行数
     */
    int insert(Advertisement advertisement);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Advertisement> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Advertisement> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Advertisement> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Advertisement> entities);

    /**
     * 修改数据
     *
     * @param advertisement 实例对象
     * @return 影响行数
     */
    int update(Advertisement advertisement);

    /**
     * 通过主键删除数据
     *
     * @param adId 主键
     * @return 影响行数
     */
    int deleteById(Long adId);

    /**
     * 通过广告类型查询广告列表
     *
     * @param type type
     * @return 实例对象
     */
    List<Advertisement> queryByAdType(@Param("adType") String type);
}