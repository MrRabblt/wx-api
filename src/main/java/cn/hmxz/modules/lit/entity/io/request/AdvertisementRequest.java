package cn.hmxz.modules.lit.entity.io.request;

import cn.hmxz.modules.lit.entity.Advertisement;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Author: zhengying
 * @Date: 2020/12/19 17:34
 * @FileName: QueryRecruitmentAd
 * @Description: 查询轮播广告
 */
@Data
public class AdvertisementRequest {
    @NotNull
    private Advertisement advertisement;
}
