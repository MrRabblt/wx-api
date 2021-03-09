package cn.hmxz.modules.lit.service;


import cn.hmxz.modules.lit.entity.SalaryInfo;

import java.util.List;

/**
 * 薪资爆料信息表(SalaryInfo)表服务接口
 *
 * @author liangjiang
 * @since 2020-12-27 15:58:00
 */
public interface SalaryInfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param salaryId 主键
     * @return 实例对象
     */
    SalaryInfo queryById(Long salaryId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<SalaryInfo> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param salaryInfo 实例对象
     * @return 实例对象
     */
    SalaryInfo insert(SalaryInfo salaryInfo);

    /**
     * 修改数据
     *
     * @param salaryInfo 实例对象
     * @return 实例对象
     */
    SalaryInfo update(SalaryInfo salaryInfo);

    /**
     * 通过主键删除数据
     *
     * @param salaryId 主键
     * @return 是否成功
     */
    boolean deleteById(Long salaryId);

}