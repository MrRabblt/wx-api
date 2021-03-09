package cn.hmxz.modules.lit.dao;

import cn.hmxz.modules.lit.entity.InterviewExperience;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 面试经验表(InterviewExperience)表数据库访问层
 *
 * @author liangjiang
 * @since 2020-12-19 14:26:07
 */
@Mapper
public interface InterviewExperienceDao {

    /**
     * 通过ID查询单条数据
     *
     * @param expId 主键
     * @return 实例对象
     */
    InterviewExperience queryById(Long expId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<InterviewExperience> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 查询多条数据
     *
     * @param company 公司名
     * @return 对象列表
     */
    List<InterviewExperience> queryExpByCompany(@Param("company") String company);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param interviewExperience 实例对象
     * @return 对象列表
     */
    List<InterviewExperience> queryAll(InterviewExperience interviewExperience);

    /**
     * 新增数据
     *
     * @param interviewExperience 实例对象
     * @return 影响行数
     */
    int insert(InterviewExperience interviewExperience);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<InterviewExperience> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<InterviewExperience> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<InterviewExperience> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<InterviewExperience> entities);

    /**
     * 修改数据
     *
     * @param interviewExperience 实例对象
     * @return 影响行数
     */
    int update(InterviewExperience interviewExperience);

    /**
     * 通过主键删除数据
     *
     * @param expId 主键
     * @return 影响行数
     */
    int deleteById(Long expId);

}