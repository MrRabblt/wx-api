package cn.hmxz.modules.lit.service;


import cn.hmxz.modules.lit.entity.UserMessage;

import java.util.List;

/**
 * 回复消息表(UserMessage)表服务接口
 *
 * @author liangjiang
 * @since 2020-12-19 14:26:11
 */
public interface UserMessageService {

    /**
     * 通过ID查询单条数据
     *
     * @param msgId 主键
     * @return 实例对象
     */
    UserMessage queryById(Long msgId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<UserMessage> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param userMessage 实例对象
     * @return 实例对象
     */
    UserMessage insert(UserMessage userMessage);

    /**
     * 修改数据
     *
     * @param userMessage 实例对象
     * @return 实例对象
     */
    UserMessage update(UserMessage userMessage);

    /**
     * 通过主键删除数据
     *
     * @param msgId 主键
     * @return 是否成功
     */
    boolean deleteById(Long msgId);

}