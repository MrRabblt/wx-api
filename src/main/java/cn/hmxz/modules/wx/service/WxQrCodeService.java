package cn.hmxz.modules.wx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cn.hmxz.common.utils.PageUtils;
import cn.hmxz.modules.wx.entity.WxQrCode;
import cn.hmxz.modules.wx.form.WxQrCodeForm;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.bean.result.WxMpQrCodeTicket;

import java.util.Map;

/**
 * 公众号带参二维码
 *
 * @author liangjiang
 *
 * @date 2020-01-02 11:11:55
 */
public interface WxQrCodeService extends IService<WxQrCode> {
    /**
     * 分页查询用户数据
     * @param params 查询参数
     * @return PageUtils 分页结果
     */
    PageUtils queryPage(Map<String, Object> params);

    /**
     * 创建公众号带参二维码
     *
     *
     * @param appid
     * @param form
     * @return
     */
    WxMpQrCodeTicket createQrCode(String appid, WxQrCodeForm form) throws WxErrorException;
}

