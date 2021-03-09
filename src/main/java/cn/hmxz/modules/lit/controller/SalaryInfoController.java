package cn.hmxz.modules.lit.controller;

import cn.hmxz.modules.lit.entity.SalaryInfo;
import cn.hmxz.modules.lit.service.SalaryInfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 薪资爆料信息表(SalaryInfo)表控制层
 *
 * @author liangjiang
 * @since 2020-12-27 15:58:01
 */
@RestController
@RequestMapping("salaryInfo")
public class SalaryInfoController {
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
    public SalaryInfo selectOne(Long id) {
        return this.salaryInfoService.queryById(id);
    }

}