package cn.hmxz.modules.lit.controller;

import cn.hmxz.modules.lit.entity.WorkCity;
import cn.hmxz.modules.lit.entity.io.response.BlackHorseResponse;
import cn.hmxz.modules.lit.service.WorkCityService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 工作城市(WorkCity)表控制层
 *
 * @author liangjiang
 * @since 2020-12-19 14:26:12
 */
@RestController
@RequestMapping("/workCity")
public class WorkCityController {
    /**
     * 服务对象
     */
    @Resource
    private WorkCityService workCityService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public WorkCity selectOne(Long id) {
        return this.workCityService.queryById(id);
    }

    /**
     * 通过主键查询单条数据
     *
     * @return BlackHorseResponse
     */
    @ApiOperation(value = "查找所有城市", notes = "查找所有城市")
    @GetMapping("/queryAllCity")
    public BlackHorseResponse<List<String>> selectCity() {
        List<String> cityNames = workCityService.queryDistinctCity();
        cityNames.add(0,"全国");
        return BlackHorseResponse.buildSuccess(cityNames);
    }

}