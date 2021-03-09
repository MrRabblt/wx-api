package cn.hmxz.modules.lit.service.impl;

import cn.hmxz.modules.lit.dao.SalaryInfoDao;
import cn.hmxz.modules.lit.entity.SalaryInfo;
import cn.hmxz.modules.lit.service.SalaryInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 薪资爆料信息表(SalaryInfo)表服务实现类
 *
 * @author liangjiang
 * @since 2020-12-27 15:58:00
 */
@Service("salaryInfoService")
public class SalaryInfoServiceImpl implements SalaryInfoService {
    @Resource
    private SalaryInfoDao salaryInfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param salaryId 主键
     * @return 实例对象
     */
    @Override
    public SalaryInfo queryById(Long salaryId) {
        return this.salaryInfoDao.queryById(salaryId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<SalaryInfo> queryAllByLimit(int offset, int limit) {
        return this.salaryInfoDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param salaryInfo 实例对象
     * @return 实例对象
     */
    @Override
    public SalaryInfo insert(SalaryInfo salaryInfo) {
        this.salaryInfoDao.insert(salaryInfo);
        return salaryInfo;
    }

    /**
     * 修改数据
     *
     * @param salaryInfo 实例对象
     * @return 实例对象
     */
    @Override
    public SalaryInfo update(SalaryInfo salaryInfo) {
        this.salaryInfoDao.update(salaryInfo);
        return this.queryById(salaryInfo.getSalaryId());
    }

    /**
     * 通过主键删除数据
     *
     * @param salaryId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long salaryId) {
        return this.salaryInfoDao.deleteById(salaryId) > 0;
    }
}