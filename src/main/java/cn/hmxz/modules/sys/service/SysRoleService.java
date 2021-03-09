package cn.hmxz.modules.sys.service;

import cn.hmxz.modules.sys.entity.SysRoleEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.hmxz.common.utils.PageUtils;

import java.util.List;
import java.util.Map;


/**
 * 角色
 * @author liangjiang
 */
public interface SysRoleService extends IService<SysRoleEntity> {
    /**
     * 分页查询用户数据
     * @param params 查询参数
     * @return PageUtils 分页结果
     */
    PageUtils queryPage(Map<String, Object> params);

    void saveRole(SysRoleEntity role);

    void update(SysRoleEntity role);

    void deleteBatch(Long[] roleIds);


    /**
     * 查询用户创建的角色ID列表
     */
    List<Long> queryRoleIdList(Long createUserId);
}
