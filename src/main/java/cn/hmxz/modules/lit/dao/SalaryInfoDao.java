package cn.hmxz.modules.lit.dao;

import cn.hmxz.modules.lit.entity.SalaryInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 薪资爆料信息表(SalaryInfo)表数据库访问层
 *
 * @author liangjiang
 * @since 2020-12-27 15:57:59
 */
@Mapper
public interface SalaryInfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param salaryId 主键
     * @return 实例对象
     */
    SalaryInfo queryById(Long salaryId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<SalaryInfo> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param salaryInfo 实例对象
     * @return 对象列表
     */
    List<SalaryInfo> queryAll(SalaryInfo salaryInfo);

    /**
     * 新增数据
     *
     * @param salaryInfo 实例对象
     * @return 影响行数
     */
    int insert(SalaryInfo salaryInfo);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SalaryInfo> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<SalaryInfo> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SalaryInfo> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<SalaryInfo> entities);

    /**
     * 修改数据
     *
     * @param salaryInfo 实例对象
     * @return 影响行数
     */
    int update(SalaryInfo salaryInfo);

    /**
     * 通过主键删除数据
     *
     * @param salaryId 主键
     * @return 影响行数
     */
    int deleteById(Long salaryId);

}