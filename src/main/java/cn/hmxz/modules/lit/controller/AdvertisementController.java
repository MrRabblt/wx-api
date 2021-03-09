package cn.hmxz.modules.lit.controller;

import cn.hmxz.modules.lit.entity.Advertisement;
import cn.hmxz.modules.lit.entity.io.request.AdvertisementRequest;
import cn.hmxz.modules.lit.entity.io.response.BlackHorseResponse;
import cn.hmxz.modules.lit.enumType.AdType;
import cn.hmxz.modules.lit.service.AdvertisementService;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 广告表(Advertisement)表控制层
 *
 * @author liangjiang
 * @since 2020-12-19 14:26:03
 */
@RestController
@RequestMapping("/advertisement")
public class AdvertisementController {
    /**
     * 服务对象
     */
    @Resource
    private AdvertisementService advertisementService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Advertisement selectOne(Long id) {
        return this.advertisementService.queryById(id);
    }

    /**
     * 通过主键查询单条数据
     *
     * @return BlackHorseResponse
     */
    @ApiOperation(value = "查询校招信息广告", notes = "查询校招信息广告的接口")
    @GetMapping("/selectRecruitmentAd")
    public BlackHorseResponse<List<Advertisement>> selectRecruitmentAds() {
        List<Advertisement> advertisementList = advertisementService.queryByAdType(AdType.ROUND_ROBIN_ADVERTISING.getCode());
        return BlackHorseResponse.buildSuccess(advertisementList);
    }
    /**
     * 新增数据
     *
     * @param advertisementRequest advertisementRequest
     * @return BlackHorseResponse
     */
    @ApiOperation(value = "新增校招信息广告", notes = "新增校招信息广告的接口")
    @PostMapping("/addRecruitmentAds")
    public BlackHorseResponse<String> addRecruitmentAds(@RequestBody @Validated AdvertisementRequest advertisementRequest) {
        advertisementService.insert(advertisementRequest.getAdvertisement());
        return BlackHorseResponse.buildSuccess("新增广告成功！");
    }
}