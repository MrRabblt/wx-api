package cn.hmxz.modules.lit.entity.io.request;

import cn.hmxz.modules.lit.entity.StandMake;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @Author: zhengying
 * @Date: 2020/12/19 17:34
 * @FileName: QueryRecruitmentAd
 * @Description: 表态request
 */
@Data
public class StandMakeRequest {
    @NotNull
    @Valid
    private StandMake standMake;
}
