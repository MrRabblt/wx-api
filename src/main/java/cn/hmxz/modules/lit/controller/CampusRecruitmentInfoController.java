package cn.hmxz.modules.lit.controller;

import cn.hmxz.modules.lit.entity.CampusRecruitmentInfo;
import cn.hmxz.modules.lit.entity.WorkCity;
import cn.hmxz.modules.lit.entity.io.request.CampusRecruitmentInfoRequest;
import cn.hmxz.modules.lit.entity.io.request.QueryRecruitmentInfoRequest;
import cn.hmxz.modules.lit.entity.io.response.BlackHorseResponse;
import cn.hmxz.modules.lit.enumType.StatusType;
import cn.hmxz.modules.lit.service.CampusRecruitmentInfoService;
import cn.hmxz.modules.lit.service.WorkCityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 校招信息(CampusRecruitmentInfo)表控制层
 *
 * @author zhengying
 * @since 2020-12-19 14:26:05
 */
@RestController
@RequestMapping("/campusRecruitmentInfo")
@Api(value = "校招信息接口")
public class CampusRecruitmentInfoController {
    /**
     * 服务对象
     */
    @Resource
    private CampusRecruitmentInfoService campusRecruitmentInfoService;

    @Autowired
    private WorkCityService workCityService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public CampusRecruitmentInfo selectOne(Long id) {
        return this.campusRecruitmentInfoService.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param recruitmentInfoRequest recruitmentInfoRequest
     * @return BlackHorseResponse
     */
    @ApiOperation(value = "新增校招信息", notes = "新增校招信息的接口")
    @PostMapping("/addCampusRecruitmentInfo")
    public BlackHorseResponse<String> addCampusRecruitmentInfo(@RequestBody @Validated CampusRecruitmentInfoRequest recruitmentInfoRequest) {
        CampusRecruitmentInfo recruitmentInfo = recruitmentInfoRequest.getRecruitmentInfo();
        recruitmentInfo.setStatus(StatusType.ACTIVE.getCode());
        CampusRecruitmentInfo info = campusRecruitmentInfoService.insert(recruitmentInfo);
        for (WorkCity workCity : recruitmentInfoRequest.getWorkCityList()) {
            workCity.setInfoId(info.getInfoId());
            workCityService.insert(workCity);
        }
        return BlackHorseResponse.buildSuccess("新增校招信息成功！");
    }

    /**
     * 工作地点筛选
     *
     * @param city 城市名
     * @return BlackHorseResponse
     */
    @ApiOperation(value = "工作地点筛选", notes = "工作地点筛选")
    @GetMapping("/queryByCity/{city}")
    public BlackHorseResponse<List<CampusRecruitmentInfo>> queryByCity(@PathVariable String city) {
        List<Long> infoIdList = workCityService.queryInfoIdByCity(city);
        if (infoIdList.size() < 1) {
            return BlackHorseResponse.buildSuccess("");
        }
        List<CampusRecruitmentInfo> campusRecruitmentInfos = campusRecruitmentInfoService.queryInfoByIds(infoIdList);
        return BlackHorseResponse.buildSuccess(campusRecruitmentInfos);
    }

    /**
     * 公司名称筛选
     *
     * @param recruitmentInfoRequest recruitmentInfoRequest
     * @return BlackHorseResponse
     */
    @ApiOperation(value = "城市和公司名称筛选", notes = "城市和公司名称筛选")
    @GetMapping("/queryRecruitmentInfoByCondition")
    public BlackHorseResponse<List<CampusRecruitmentInfo>> queryRecruitmentInfoByCondition(@Validated QueryRecruitmentInfoRequest recruitmentInfoRequest) {
        List<Long> infoIdList = workCityService.queryInfoIdByCity(recruitmentInfoRequest.getCity());
        CampusRecruitmentInfo recruitmentInfo = new CampusRecruitmentInfo();
        recruitmentInfo.setInfoCompany(recruitmentInfo.getInfoCompany());
        List<CampusRecruitmentInfo> campusRecruitmentInfos =
                campusRecruitmentInfoService.queryInfoByCompany(recruitmentInfoRequest.getCompany(), infoIdList);
        return BlackHorseResponse.buildSuccess(campusRecruitmentInfos);
    }

}