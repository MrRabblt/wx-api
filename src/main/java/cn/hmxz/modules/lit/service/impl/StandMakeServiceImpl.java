package cn.hmxz.modules.lit.service.impl;

import cn.hmxz.modules.lit.dao.StandMakeDao;
import cn.hmxz.modules.lit.entity.StandMake;
import cn.hmxz.modules.lit.service.StandMakeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 薪资爆料表态表(StandMake)表服务实现类
 *
 * @author liangjiang
 * @since 2020-12-27 16:00:07
 */
@Service("standMakeService")
public class StandMakeServiceImpl implements StandMakeService {
    @Resource
    private StandMakeDao standMakeDao;

    /**
     * 通过ID查询单条数据
     *
     * @param standId 主键
     * @return 实例对象
     */
    @Override
    public StandMake queryById(Long standId) {
        return this.standMakeDao.queryById(standId);
    }

    @Override
    public List<StandMake> queryStandByCondition(StandMake standMake) {
        return this.standMakeDao.queryAll(standMake);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<StandMake> queryAllByLimit(int offset, int limit) {
        return this.standMakeDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param standMake 实例对象
     * @return 实例对象
     */
    @Override
    public StandMake insert(StandMake standMake) {
        this.standMakeDao.insert(standMake);
        return standMake;
    }

    /**
     * 修改数据
     *
     * @param standMake 实例对象
     * @return 实例对象
     */
    @Override
    public StandMake update(StandMake standMake) {
        this.standMakeDao.update(standMake);
        return this.queryById(standMake.getStandId());
    }

    /**
     * 通过主键删除数据
     *
     * @param standId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long standId) {
        return this.standMakeDao.deleteById(standId) > 0;
    }
}