package cn.hmxz.modules.lit.controller;

import cn.hmxz.modules.lit.entity.InterviewExperience;
import cn.hmxz.modules.lit.entity.io.request.InterviewExperienceRequest;
import cn.hmxz.modules.lit.entity.io.request.QueryInterviewExpRequest;
import cn.hmxz.modules.lit.entity.io.response.BlackHorseResponse;
import cn.hmxz.modules.lit.service.InterviewExperienceService;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 面试经验表(InterviewExperience)表控制层
 *
 * @author liangjiang
 * @since 2020-12-19 14:26:07
 */
@RestController
@RequestMapping("/interviewExperience")
public class InterviewExperienceController {
    /**
     * 服务对象
     */
    @Resource
    private InterviewExperienceService interviewExperienceService;

    /**
     * 通过主键查询单条数据
     *
     * @param expId 主键
     * @return 单条数据
     */
    @ApiOperation(value = "查询面经详情", notes = "查询面经详情")
    @GetMapping("/queryExpDetail")
    public BlackHorseResponse<InterviewExperience> selectOne(@RequestParam Long expId, @RequestParam Long userId) {
        return BlackHorseResponse.buildSuccess(this.interviewExperienceService.queryExpDetail(expId, userId));
    }

    /**
     * 通过主键查询单条数据
     *
     * @return 单条数据
     */
    @ApiOperation(value = "查询热门面经列表", notes = "根据浏览量查询面经列表")
    @GetMapping("/queryHotExpList")
    public BlackHorseResponse<List<InterviewExperience>> queryHotExpList() {
        return BlackHorseResponse.buildSuccess(this.interviewExperienceService.queryAllByLimit(0, 100));
    }

    /**
     * 通过主键查询单条数据
     *
     * @return 单条数据
     */
    @ApiOperation(value = "根据公司名或岗位查询面经", notes = "根据公司名或岗位查询面经")
    @GetMapping("/queryExpListByCondition")
    public BlackHorseResponse<List<InterviewExperience>> queryExpListByCondition(@Validated QueryInterviewExpRequest expRequest) {
        InterviewExperience experience = InterviewExperience.builder()
                .company(expRequest.getCompany())
                .position(expRequest.getPosition()).build();
        return BlackHorseResponse.buildSuccess(this.interviewExperienceService.queryAll(experience));
    }

    /**
     * 新增数据
     *
     * @param experienceRequest experienceRequest
     * @return BlackHorseResponse
     */
    @ApiOperation(value = "新增面试经验", notes = "新增面试经验")
    @PostMapping("/addInterviewExperience")
    public BlackHorseResponse<String> addInterviewExperience(@RequestBody @Validated InterviewExperienceRequest experienceRequest) {
        InterviewExperience experience = experienceRequest.getInterviewExperience();
        this.interviewExperienceService.insert(experience);
        return BlackHorseResponse.buildSuccess("新增面试经验成功！");
    }

}