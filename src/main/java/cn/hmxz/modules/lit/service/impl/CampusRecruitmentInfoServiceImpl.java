package cn.hmxz.modules.lit.service.impl;

import cn.hmxz.modules.lit.dao.CampusRecruitmentInfoDao;
import cn.hmxz.modules.lit.entity.CampusRecruitmentInfo;
import cn.hmxz.modules.lit.service.CampusRecruitmentInfoService;
import cn.hmxz.modules.lit.util.IdGenerator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 校招信息(CampusRecruitmentInfo)表服务实现类
 *
 * @author liangjiang
 * @since 2020-12-19 14:26:05
 */
@Service("campusRecruitmentInfoService")
public class CampusRecruitmentInfoServiceImpl implements CampusRecruitmentInfoService {
    @Resource
    private CampusRecruitmentInfoDao campusRecruitmentInfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param infoId 主键
     * @return 实例对象
     */
    @Override
    public CampusRecruitmentInfo queryById(Long infoId) {
        return this.campusRecruitmentInfoDao.queryById(infoId);
    }

    @Override
    public List<CampusRecruitmentInfo> queryInfoByIds(List<Long> ids) {
        return this.campusRecruitmentInfoDao.queryInfoByIds(ids);
    }

    @Override
    public List<CampusRecruitmentInfo> queryInfoByCompany(String company, List<Long> idList) {
        return this.campusRecruitmentInfoDao.queryInfoByCompany(company,idList);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<CampusRecruitmentInfo> queryAllByLimit(int offset, int limit) {
        return this.campusRecruitmentInfoDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param campusRecruitmentInfo 实例对象
     * @return 实例对象
     */
    @Override
    public CampusRecruitmentInfo insert(CampusRecruitmentInfo campusRecruitmentInfo) {
        campusRecruitmentInfo.setInfoId(IdGenerator.getId());
        campusRecruitmentInfo.setCreateTime(new Date());
        this.campusRecruitmentInfoDao.insert(campusRecruitmentInfo);
        return campusRecruitmentInfo;
    }

    /**
     * 修改数据
     *
     * @param campusRecruitmentInfo 实例对象
     * @return 实例对象
     */
    @Override
    public CampusRecruitmentInfo update(CampusRecruitmentInfo campusRecruitmentInfo) {
        this.campusRecruitmentInfoDao.update(campusRecruitmentInfo);
        return this.queryById(campusRecruitmentInfo.getInfoId());
    }

    /**
     * 通过主键删除数据
     *
     * @param infoId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long infoId) {
        return this.campusRecruitmentInfoDao.deleteById(infoId) > 0;
    }
}