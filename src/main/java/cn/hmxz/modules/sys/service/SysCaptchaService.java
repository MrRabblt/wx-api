package cn.hmxz.modules.sys.service;

import cn.hmxz.modules.sys.entity.SysCaptchaEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.awt.image.BufferedImage;

/**
 * 验证码
 * @author liangjiang
 */
public interface SysCaptchaService extends IService<SysCaptchaEntity> {

    /**
     * 获取图片验证码
     */
    BufferedImage getCaptcha(String uuid);

    /**
     * 验证码效验
     * @param uuid  uuid
     * @param code  验证码
     * @return true：成功  false：失败
     */
    boolean validate(String uuid, String code);
}
