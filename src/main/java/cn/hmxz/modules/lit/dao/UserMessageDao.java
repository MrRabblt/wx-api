package cn.hmxz.modules.lit.dao;

import cn.hmxz.modules.lit.entity.UserMessage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 回复消息表(UserMessage)表数据库访问层
 *
 * @author liangjiang
 * @since 2020-12-19 14:26:11
 */
@Mapper
public interface UserMessageDao {

    /**
     * 通过ID查询单条数据
     *
     * @param msgId 主键
     * @return 实例对象
     */
    UserMessage queryById(Long msgId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<UserMessage> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param userMessage 实例对象
     * @return 对象列表
     */
    List<UserMessage> queryAll(UserMessage userMessage);

    /**
     * 新增数据
     *
     * @param userMessage 实例对象
     * @return 影响行数
     */
    int insert(UserMessage userMessage);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<UserMessage> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<UserMessage> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<UserMessage> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<UserMessage> entities);

    /**
     * 修改数据
     *
     * @param userMessage 实例对象
     * @return 影响行数
     */
    int update(UserMessage userMessage);

    /**
     * 通过主键删除数据
     *
     * @param msgId 主键
     * @return 影响行数
     */
    int deleteById(Long msgId);

}