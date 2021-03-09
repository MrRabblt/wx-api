package cn.hmxz.modules.lit.service.impl;

import cn.hmxz.modules.lit.dao.UserMessageDao;
import cn.hmxz.modules.lit.entity.UserMessage;
import cn.hmxz.modules.lit.service.UserMessageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 回复消息表(UserMessage)表服务实现类
 *
 * @author liangjiang
 * @since 2020-12-19 14:26:11
 */
@Service("userMessageService")
public class UserMessageServiceImpl implements UserMessageService {
    @Resource
    private UserMessageDao userMessageDao;

    /**
     * 通过ID查询单条数据
     *
     * @param msgId 主键
     * @return 实例对象
     */
    @Override
    public UserMessage queryById(Long msgId) {
        return this.userMessageDao.queryById(msgId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<UserMessage> queryAllByLimit(int offset, int limit) {
        return this.userMessageDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param userMessage 实例对象
     * @return 实例对象
     */
    @Override
    public UserMessage insert(UserMessage userMessage) {
        this.userMessageDao.insert(userMessage);
        return userMessage;
    }

    /**
     * 修改数据
     *
     * @param userMessage 实例对象
     * @return 实例对象
     */
    @Override
    public UserMessage update(UserMessage userMessage) {
        this.userMessageDao.update(userMessage);
        return this.queryById(userMessage.getMsgId());
    }

    /**
     * 通过主键删除数据
     *
     * @param msgId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long msgId) {
        return this.userMessageDao.deleteById(msgId) > 0;
    }
}