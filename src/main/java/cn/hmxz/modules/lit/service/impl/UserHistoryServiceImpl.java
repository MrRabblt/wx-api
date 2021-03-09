package cn.hmxz.modules.lit.service.impl;

import cn.hmxz.modules.lit.dao.UserHistoryDao;
import cn.hmxz.modules.lit.entity.UserHistory;
import cn.hmxz.modules.lit.service.UserHistoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户足迹表(UserHistory)表服务实现类
 *
 * @author liangjiang
 * @since 2020-12-19 14:26:10
 */
@Service("userHistoryService")
public class UserHistoryServiceImpl implements UserHistoryService {
    @Resource
    private UserHistoryDao userHistoryDao;

    /**
     * 通过ID查询单条数据
     *
     * @param hisId 主键
     * @return 实例对象
     */
    @Override
    public UserHistory queryById(Long hisId) {
        return this.userHistoryDao.queryById(hisId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<UserHistory> queryAllByLimit(int offset, int limit) {
        return this.userHistoryDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param userHistory 实例对象
     * @return 实例对象
     */
    @Override
    public UserHistory insert(UserHistory userHistory) {
        this.userHistoryDao.insert(userHistory);
        return userHistory;
    }

    /**
     * 修改数据
     *
     * @param userHistory 实例对象
     * @return 实例对象
     */
    @Override
    public UserHistory update(UserHistory userHistory) {
        this.userHistoryDao.update(userHistory);
        return this.queryById(userHistory.getHisId());
    }

    /**
     * 通过主键删除数据
     *
     * @param hisId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long hisId) {
        return this.userHistoryDao.deleteById(hisId) > 0;
    }
}