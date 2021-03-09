package cn.hmxz.modules.wx.handler;

import java.util.Map;

import cn.hmxz.modules.wx.service.WxUserService;
import cn.hmxz.modules.wx.dao.WxQrUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;

/**
 * @author liangjiang
 */
@Component
public class UnsubscribeHandler extends AbstractHandler {
    @Autowired
    WxUserService userService;
    @Autowired
    WxQrUserMapper wxQrUserMapper;

    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
                                    Map<String, Object> context, WxMpService wxMpService,
                                    WxSessionManager sessionManager) {
        String openid = wxMessage.getFromUser();
        this.logger.info("取消关注用户 OPENID: " + openid);
        logger.info(wxMessage.toString());
        userService.unsubscribe(openid);
//        // 查询 推广记录
//        LambdaQueryWrapper<WxQrUser> lqw = Wrappers.lambdaQuery();
//        lqw.eq(WxQrUser::getOpenId,openid);
//        WxQrUser wxQrUser = wxQrUserMapper.selectOne(lqw);
//        // 如果存在推广记录，删除推广记录
        return null;
    }

}
