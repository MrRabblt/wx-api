package cn.hmxz.modules.wx.dao;

import cn.hmxz.modules.wx.entity.WxQrCode;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 公众号带参二维码
 *
 * @author liangjiang
 *
 * @date 2020-01-02 11:11:55
 */
@Mapper
@CacheNamespace(flushInterval = 300000L)//缓存五分钟过期
public interface WxQrCodeMapper extends BaseMapper<WxQrCode> {

    void updateNumber(@Param("sceneStr") String sceneStr);
}
