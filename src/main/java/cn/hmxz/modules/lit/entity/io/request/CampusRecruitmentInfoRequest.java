package cn.hmxz.modules.lit.entity.io.request;

import cn.hmxz.modules.lit.entity.CampusRecruitmentInfo;
import cn.hmxz.modules.lit.entity.WorkCity;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Author: zhengying
 * @Date: 2020/12/19 16:47
 * @FileName: CampusRecruitmentInfoRequest
 * @Description: 校招信息request
 */
@Data
public class CampusRecruitmentInfoRequest {
    @NotNull
    private CampusRecruitmentInfo recruitmentInfo;

    private List<WorkCity> workCityList;
}
