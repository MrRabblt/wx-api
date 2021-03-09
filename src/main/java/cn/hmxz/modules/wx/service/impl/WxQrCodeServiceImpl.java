package cn.hmxz.modules.wx.service.impl;

import cn.hmxz.common.exception.RRException;
import cn.hmxz.common.utils.PageUtils;
import cn.hmxz.common.utils.Query;
import cn.hmxz.modules.wx.dao.WxQrCodeMapper;
import cn.hmxz.modules.wx.entity.WxQrCode;
import cn.hmxz.modules.wx.form.WxQrCodeForm;
import cn.hmxz.modules.wx.service.WxQrCodeService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.RequiredArgsConstructor;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpQrCodeTicket;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.util.StringUtils;


@Service("wxQrCodeService")
@RequiredArgsConstructor
public class WxQrCodeServiceImpl extends ServiceImpl<WxQrCodeMapper, WxQrCode> implements WxQrCodeService {
    private final WxMpService wxService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String sceneStr = (String) params.get("sceneStr");
        String appid = (String) params.get("appid");
        IPage<WxQrCode> page = this.page(
            new Query<WxQrCode>().getPage(params),
            new QueryWrapper<WxQrCode>()
                    .eq(StringUtils.hasText(appid), "appid", appid)
                    .like(StringUtils.hasText(sceneStr), "scene_str", sceneStr)
        );

        return new PageUtils(page);
    }

    /**
     * 创建公众号带参二维码
     *
     *
     * @param appid
     * @param form
     * @return
     */
    @Override
    public WxMpQrCodeTicket createQrCode(String appid, WxQrCodeForm form) throws WxErrorException {
        // 校验场景值不能重复

        LambdaQueryWrapper<WxQrCode> lqw = Wrappers.lambdaQuery();
        lqw.eq(WxQrCode::getSceneStr,form.getSceneStr());
        WxQrCode temp = baseMapper.selectOne(lqw);
        if (temp != null){
            throw new RRException("场景值重复");
        }
        WxMpQrCodeTicket ticket;
        if (form.getIsTemp()) {
            //创建临时二维码
            ticket = wxService.getQrcodeService().qrCodeCreateTmpTicket(form.getSceneStr(), form.getExpireSeconds());
        } else {
            //创建永久二维码
            ticket = wxService.getQrcodeService().qrCodeCreateLastTicket(form.getSceneStr());
        }
        WxQrCode wxQrCode = new WxQrCode(form,appid);
        wxQrCode.setTicket(ticket.getTicket());
        wxQrCode.setUrl(ticket.getUrl());
        if (form.getIsTemp()) {
            wxQrCode.setExpireTime(new Date(System.currentTimeMillis() + ticket.getExpireSeconds() * 1000L));
        }
        this.save(wxQrCode);
        return ticket;
    }

}
