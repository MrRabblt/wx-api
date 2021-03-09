package cn.hmxz.modules.lit.controller;

import cn.hmxz.modules.lit.entity.CommonInfo;
import cn.hmxz.modules.lit.entity.InterviewExperience;
import cn.hmxz.modules.lit.entity.SalaryInfo;
import cn.hmxz.modules.lit.entity.StandMake;
import cn.hmxz.modules.lit.entity.io.request.StandMakeRequest;
import cn.hmxz.modules.lit.entity.io.response.BlackHorseResponse;
import cn.hmxz.modules.lit.enumType.BusinessType;
import cn.hmxz.modules.lit.enumType.StandType;
import cn.hmxz.modules.lit.service.InterviewExperienceService;
import cn.hmxz.modules.lit.service.SalaryInfoService;
import cn.hmxz.modules.lit.service.StandMakeService;
import cn.hmxz.modules.lit.util.IdGenerator;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

import static cn.hmxz.modules.lit.enumType.StandType.FAVORITE;


/**
 * 薪资爆料表态表(StandMake)表控制层
 *
 * @author liangjiang
 * @since 2020-12-27 16:00:07
 */
@RestController
@RequestMapping("standMake")
public class StandMakeController {
    /**
     * 服务对象
     */
    @Resource
    private StandMakeService standMakeService;

    /**
     * 服务对象
     */
    @Resource
    private InterviewExperienceService interviewExperienceService;

    /**
     * 服务对象
     */
    @Resource
    private SalaryInfoService salaryInfoService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public StandMake selectOne(Long id) {
        return this.standMakeService.queryById(id);
    }

    /**
     * 用户进行表态
     *
     * @param request request
     * @return BlackHorseResponse
     */
    @ApiOperation(value = "用户进行表态", notes = "用户进行表态")
    @PostMapping("/makeStand")
    public BlackHorseResponse<String> makeStand(@RequestBody @Validated StandMakeRequest request) {
        StandMake standMake = request.getStandMake();
        if (BusinessType.INTERVIEW_EXPERIENCE.getCode().equals(standMake.getRelatedType())) {
            // 查询现有的面试经验信息
            InterviewExperience experience = interviewExperienceService.queryById(standMake.getRelatedId());
            if (experience == null) {
                return BlackHorseResponse.buildFailure("查询不到面试信息！");
            }
            if (StandType.LIKE.getCode().equals(standMake.getStandType())) {
                // 点赞该进行的操作
                InterviewExperience tempExp = (InterviewExperience) makeInfoStand(standMake.getRelatedId(), standMake.getUserId(),
                        BusinessType.INTERVIEW_EXPERIENCE.getCode(), StandType.LIKE.getCode(), experience);
                tempExp.setExpId(experience.getExpId());
                interviewExperienceService.update(tempExp);
                // 收藏该进行的操作
            } else if (FAVORITE.getCode().equals(request.getStandMake().getStandType())) {
                InterviewExperience tempExp = (InterviewExperience) makeInfoStand(standMake.getRelatedId(), standMake.getUserId(),
                        BusinessType.INTERVIEW_EXPERIENCE.getCode(), FAVORITE.getCode(), experience);
                tempExp.setExpId(experience.getExpId());
                interviewExperienceService.update(tempExp);
            } else {
                return BlackHorseResponse.buildFailure("不可进行表态！");
            }
        } else if (BusinessType.SALARY_INFO.getCode().equals(standMake.getRelatedType())) {
            // 查询现有的薪资爆料信息
            SalaryInfo salaryInfo = salaryInfoService.queryById(standMake.getRelatedId());
            if (salaryInfo == null) {
                return BlackHorseResponse.buildFailure("查询不到薪资信息！");
            }
            if (StandType.LIKE.getCode().equals(standMake.getStandType())) {
                // 点赞该进行的操作
                SalaryInfo tempSalary = (SalaryInfo) makeInfoStand(standMake.getRelatedId(), standMake.getUserId(),
                        BusinessType.SALARY_INFO.getCode(), StandType.LIKE.getCode(), salaryInfo);
                tempSalary.setSalaryId(tempSalary.getSalaryId());
                salaryInfoService.update(tempSalary);
                // 收藏该进行的操作
            } else if (FAVORITE.getCode().equals(request.getStandMake().getStandType())) {
                SalaryInfo tempSalary = (SalaryInfo) makeInfoStand(standMake.getRelatedId(), standMake.getUserId(),
                        BusinessType.SALARY_INFO.getCode(), FAVORITE.getCode(), salaryInfo);
                tempSalary.setSalaryId(salaryInfo.getSalaryId());
                salaryInfoService.update(tempSalary);
            } else {
                return BlackHorseResponse.buildFailure("不可进行表态！");
            }
        }
        return BlackHorseResponse.buildFailure("不可进行表态！");
    }

    private CommonInfo makeInfoStand(Long relatedId, Long userId, String relatedType, String standType, CommonInfo commonInfo) {
        StandMake tempStandMake = StandMake.builder()
                .standType(standType)
                .relatedId(relatedId)
                .relatedType(relatedType)
                .userId(userId)
                .build();
        // 查询该info下的现有表态
        List<StandMake> make = standMakeService.queryStandByCondition(tempStandMake);
        // 如果为0则为第一次表态，increase
        if (make.size() == 0) {
            tempStandMake.setIsStand(true);
            tempStandMake.setCreateTime(new Date());
            tempStandMake.setStandId(IdGenerator.getId());
            standMakeService.insert(tempStandMake);
            // 插入表态信息后进行info的更改
            increaseInfo(standType, commonInfo);
        } else {
            if (make.get(0).getIsStand()) {
                // 取消表态
                tempStandMake.setIsStand(false);
                tempStandMake.setStandId(make.get(0).getStandId());
                standMakeService.update(tempStandMake);
                if (StandType.LIKE.getCode().equals(standType)) {
                    commonInfo.setLikes(commonInfo.getLikes() - 1);
                } else if (FAVORITE.getCode().equals(standType)) {
                    commonInfo.setFavorites(commonInfo.getFavorites() - 1);
                }
            } else {
                // 表态
                tempStandMake.setIsStand(true);
                tempStandMake.setStandId(make.get(0).getStandId());
                standMakeService.update(tempStandMake);
                increaseInfo(standType, commonInfo);
            }
        }
        return commonInfo;
    }

    private void increaseInfo(String standType, CommonInfo commonInfo) {
        if (StandType.LIKE.getCode().equals(standType)) {
            commonInfo.setLikes(commonInfo.getLikes() + 1);
        } else if (FAVORITE.getCode().equals(standType)) {
            commonInfo.setFavorites(commonInfo.getFavorites() + 1);
        }
    }
}