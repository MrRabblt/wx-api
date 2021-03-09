package cn.hmxz.modules.lit.entity.io.request;

import cn.hmxz.modules.lit.entity.InterviewExperience;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @Author: zhengying
 * @Date: 2020/12/19 16:47
 * @FileName: CampusRecruitmentInfoRequest
 * @Description: 校招信息request
 */
@Data
public class InterviewExperienceRequest {
    @NotNull
    @Valid
    private InterviewExperience interviewExperience;
}
