package cn.hmxz.modules.lit.service.impl;

import cn.hmxz.modules.lit.dao.AdvertisementDao;
import cn.hmxz.modules.lit.entity.Advertisement;
import cn.hmxz.modules.lit.service.AdvertisementService;
import cn.hmxz.modules.lit.util.IdGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 广告表(Advertisement)表服务实现类
 *
 * @author liangjiang
 * @since 2020-12-19 14:26:03
 */
@Service("advertisementService")
@Slf4j
public class AdvertisementServiceImpl implements AdvertisementService {
    @Resource
    private AdvertisementDao advertisementDao;

    /**
     * 通过ID查询单条数据
     *
     * @param adId 主键
     * @return 实例对象
     */
    @Override
    public Advertisement queryById(Long adId) {
        return this.advertisementDao.queryById(adId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Advertisement> queryAllByLimit(int offset, int limit) {
        return this.advertisementDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param advertisement 实例对象
     * @return 实例对象
     */
    @Override
    public Advertisement insert(Advertisement advertisement) {
        advertisement.setAdId(IdGenerator.getId());
        advertisement.setCreateTime(new Date());
        log.info("advertisement===" + advertisement);
        this.advertisementDao.insert(advertisement);
        return advertisement;
    }

    /**
     * 修改数据
     *
     * @param advertisement 实例对象
     * @return 实例对象
     */
    @Override
    public Advertisement update(Advertisement advertisement) {
        this.advertisementDao.update(advertisement);
        return this.queryById(advertisement.getAdId());
    }

    /**
     * 通过主键删除数据
     *
     * @param adId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long adId) {
        return this.advertisementDao.deleteById(adId) > 0;
    }

    @Override
    public List<Advertisement> queryByAdType(String type) {
        return this.advertisementDao.queryByAdType(type);
    }
}