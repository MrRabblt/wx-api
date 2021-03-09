package cn.hmxz.modules.sys.service;


import cn.hmxz.modules.sys.entity.SysLogEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.hmxz.common.utils.PageUtils;

import java.util.Map;


/**
 * 系统日志
 * @author liangjiang
 */
public interface SysLogService extends IService<SysLogEntity> {
    /**
     * 分页查询用户数据
     * @param params 查询参数
     * @return PageUtils 分页结果
     */
    PageUtils queryPage(Map<String, Object> params);


}
