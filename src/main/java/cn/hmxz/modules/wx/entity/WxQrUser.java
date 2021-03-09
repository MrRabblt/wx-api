package cn.hmxz.modules.wx.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 公众号带参二维码
 *
 * @author liangjiang
 * @date
 */
@Data
@TableName("wx_qr_user")
public class WxQrUser implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * openId
     */
    private String openId;

    /**
     * 二维码id
     */
    private String qrKey;

    /**
     * 删除标志
     */
    private int del;
}
