package cn.hmxz.modules.lit.service.impl;

import cn.hmxz.modules.lit.dao.InterviewExperienceDao;
import cn.hmxz.modules.lit.dao.UserHistoryDao;
import cn.hmxz.modules.lit.entity.InterviewExperience;
import cn.hmxz.modules.lit.entity.UserHistory;
import cn.hmxz.modules.lit.enumType.BusinessType;
import cn.hmxz.modules.lit.enumType.StatusType;
import cn.hmxz.modules.lit.service.InterviewExperienceService;
import cn.hmxz.modules.lit.util.IdGenerator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 面试经验表(InterviewExperience)表服务实现类
 *
 * @author liangjiang
 * @since 2020-12-19 14:26:07
 */
@Service("interviewExperienceService")
public class InterviewExperienceServiceImpl implements InterviewExperienceService {
    @Resource
    private InterviewExperienceDao interviewExperienceDao;

    @Resource
    private UserHistoryDao userHistoryDao;


    @Override
    public InterviewExperience queryById(Long expId) {
        return this.interviewExperienceDao.queryById(expId);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param expId 主键
     * @return 实例对象
     */
    @Override
    public InterviewExperience queryExpDetail(Long expId,Long userId) {
        UserHistory userHistory = UserHistory.builder()
                .hisId(IdGenerator.getId())
                .userId(userId)
                .relatedId(expId)
                .relatedType(BusinessType.INTERVIEW_EXPERIENCE.getCode())
                .createTime(new Date())
                .build();
        userHistoryDao.insert(userHistory);
        return this.interviewExperienceDao.queryById(expId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<InterviewExperience> queryAllByLimit(int offset, int limit) {
        return this.interviewExperienceDao.queryAllByLimit(offset, limit);
    }

    @Override
    public List<InterviewExperience> queryAll(InterviewExperience experience) {
        return this.interviewExperienceDao.queryAll(experience);
    }

    @Override
    public List<InterviewExperience> queryExpByCompany(String company) {
        return null;
    }

    /**
     * 新增数据
     *
     * @param interviewExperience 实例对象
     * @return 实例对象
     */
    @Override
    public InterviewExperience insert(InterviewExperience interviewExperience) {
        interviewExperience.setExpId(IdGenerator.getId());
        interviewExperience.setStatus(StatusType.ACTIVE.getCode());
        interviewExperience.setViews(0L);
        interviewExperience.setLikes(0L);
        interviewExperience.setFavorites(0L);
        interviewExperience.setCreateTime(new Date());
        this.interviewExperienceDao.insert(interviewExperience);
        return interviewExperience;
    }

    /**
     * 修改数据
     *
     * @param interviewExperience 实例对象
     * @return 实例对象
     */
    @Override
    public InterviewExperience update(InterviewExperience interviewExperience) {
        this.interviewExperienceDao.update(interviewExperience);
        return this.queryById(interviewExperience.getExpId());
    }

    /**
     * 通过主键删除数据
     *
     * @param expId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long expId) {
        return this.interviewExperienceDao.deleteById(expId) > 0;
    }
}