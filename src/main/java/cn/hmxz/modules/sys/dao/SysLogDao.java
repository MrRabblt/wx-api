package cn.hmxz.modules.sys.dao;


import cn.hmxz.modules.sys.entity.SysLogEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统日志
 * @author liangjiang
 */
@Mapper
public interface SysLogDao extends BaseMapper<SysLogEntity> {

}
