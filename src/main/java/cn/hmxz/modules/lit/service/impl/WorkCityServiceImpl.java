package cn.hmxz.modules.lit.service.impl;

import cn.hmxz.modules.lit.dao.WorkCityDao;
import cn.hmxz.modules.lit.entity.WorkCity;
import cn.hmxz.modules.lit.service.WorkCityService;
import cn.hmxz.modules.lit.util.IdGenerator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 工作城市(WorkCity)表服务实现类
 *
 * @author liangjiang
 * @since 2020-12-19 14:26:12
 */
@Service("workCityService")
public class WorkCityServiceImpl implements WorkCityService {
    @Resource
    private WorkCityDao workCityDao;

    /**
     * 通过ID查询单条数据
     *
     * @param cityId 主键
     * @return 实例对象
     */
    @Override
    public WorkCity queryById(Long cityId) {
        return this.workCityDao.queryById(cityId);
    }

    @Override
    public List<Long> queryInfoIdByCity(String cityName) {
        return this.workCityDao.queryInfoIdByCity(cityName);
    }

    @Override
    public List<String> queryDistinctCity() {
        return this.workCityDao.queryDistinctCity();
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<WorkCity> queryAllByLimit(int offset, int limit) {
        return this.workCityDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param workCity 实例对象
     * @return 实例对象
     */
    @Override
    public WorkCity insert(WorkCity workCity) {
        workCity.setCityId(IdGenerator.getId());
        workCity.setCreateTime(new Date());
        this.workCityDao.insert(workCity);
        return workCity;
    }

    /**
     * 修改数据
     *
     * @param workCity 实例对象
     * @return 实例对象
     */
    @Override
    public WorkCity update(WorkCity workCity) {
        this.workCityDao.update(workCity);
        return this.queryById(workCity.getCityId());
    }

    /**
     * 通过主键删除数据
     *
     * @param cityId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long cityId) {
        return this.workCityDao.deleteById(cityId) > 0;
    }
}