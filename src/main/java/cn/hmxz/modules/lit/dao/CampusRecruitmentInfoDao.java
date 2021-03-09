package cn.hmxz.modules.lit.dao;

import cn.hmxz.modules.lit.entity.CampusRecruitmentInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 校招信息(CampusRecruitmentInfo)表数据库访问层
 *
 * @author liangjiang
 * @since 2020-12-19 14:26:05
 */
@Mapper
public interface CampusRecruitmentInfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param infoId 主键
     * @return 实例对象
     */
    CampusRecruitmentInfo queryById(Long infoId);


    /**
     * 查询多条数据
     *
     * @param ids id列表
     * @return 对象列表
     */
    List<CampusRecruitmentInfo> queryInfoByIds(@Param("ids") List<Long> ids);

    /**
     * 查询多条数据
     *
     * @param company 公司名
     * @param idList idList
     * @return 对象列表
     */
    List<CampusRecruitmentInfo> queryInfoByCompany(@Param("company") String company, @Param("idList") List<Long> idList);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<CampusRecruitmentInfo> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param campusRecruitmentInfo 实例对象
     * @return 对象列表
     */
    List<CampusRecruitmentInfo> queryAll(CampusRecruitmentInfo campusRecruitmentInfo);

    /**
     * 新增数据
     *
     * @param campusRecruitmentInfo 实例对象
     * @return 影响行数
     */
    int insert(CampusRecruitmentInfo campusRecruitmentInfo);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<CampusRecruitmentInfo> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<CampusRecruitmentInfo> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<CampusRecruitmentInfo> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<CampusRecruitmentInfo> entities);

    /**
     * 修改数据
     *
     * @param campusRecruitmentInfo 实例对象
     * @return 影响行数
     */
    int update(CampusRecruitmentInfo campusRecruitmentInfo);

    /**
     * 通过主键删除数据
     *
     * @param infoId 主键
     * @return 影响行数
     */
    int deleteById(Long infoId);

}