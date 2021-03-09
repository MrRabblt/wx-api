package cn.hmxz.modules.lit.service;


import cn.hmxz.modules.lit.entity.CampusRecruitmentInfo;

import java.util.List;

/**
 * 校招信息(CampusRecruitmentInfo)表服务接口
 *
 * @author liangjiang
 * @since 2020-12-19 14:26:05
 */
public interface CampusRecruitmentInfoService {

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
    List<CampusRecruitmentInfo> queryInfoByIds(List<Long> ids);

    /**
     * 查询多条数据
     *
     * @param company 公司名
     * @param idList
     * @return 对象列表
     */
    List<CampusRecruitmentInfo> queryInfoByCompany(String company, List<Long> idList);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<CampusRecruitmentInfo> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param campusRecruitmentInfo 实例对象
     * @return 实例对象
     */
    CampusRecruitmentInfo insert(CampusRecruitmentInfo campusRecruitmentInfo);

    /**
     * 修改数据
     *
     * @param campusRecruitmentInfo 实例对象
     * @return 实例对象
     */
    CampusRecruitmentInfo update(CampusRecruitmentInfo campusRecruitmentInfo);

    /**
     * 通过主键删除数据
     *
     * @param infoId 主键
     * @return 是否成功
     */
    boolean deleteById(Long infoId);

}