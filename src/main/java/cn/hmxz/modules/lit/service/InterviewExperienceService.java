package cn.hmxz.modules.lit.service;


import cn.hmxz.modules.lit.entity.InterviewExperience;

import java.util.List;

/**
 * 面试经验表(InterviewExperience)表服务接口
 *
 * @author liangjiang
 * @since 2020-12-19 14:26:07
 */
public interface InterviewExperienceService {

    /**
     * 通过ID查询单条数据
     *
     * @param expId 主键
     * @return 实例对象
     */
    InterviewExperience queryById(Long expId);

    /**
     * 通过ID查询单条数据
     *
     * @param expId 主键
     * @return 实例对象
     */
    InterviewExperience queryExpDetail(Long expId,Long userId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<InterviewExperience> queryAllByLimit(int offset, int limit);

    /**
     * 查询多条数据
     *
     * @param experience experience
     * @return 对象列表
     */
    List<InterviewExperience> queryAll(InterviewExperience experience);

    /**
     * 查询多条数据
     *
     * @param company 公司名
     * @return 对象列表
     */
    List<InterviewExperience> queryExpByCompany(String company);

    /**
     * 新增数据
     *
     * @param interviewExperience 实例对象
     * @return 实例对象
     */
    InterviewExperience insert(InterviewExperience interviewExperience);

    /**
     * 修改数据
     *
     * @param interviewExperience 实例对象
     * @return 实例对象
     */
    InterviewExperience update(InterviewExperience interviewExperience);

    /**
     * 通过主键删除数据
     *
     * @param expId 主键
     * @return 是否成功
     */
    boolean deleteById(Long expId);

}