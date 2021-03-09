package cn.hmxz.modules.wx.dao;

import cn.hmxz.modules.wx.entity.WxQrUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;

@Mapper
@CacheNamespace(flushInterval = 300000L)//缓存五分钟过期
public interface WxQrUserMapper extends BaseMapper<WxQrUser> {
}
