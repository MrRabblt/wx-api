package cn.hmxz.modules.lit.controller;

import cn.hmxz.modules.lit.entity.UserHistory;
import cn.hmxz.modules.lit.service.UserHistoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 用户足迹表(UserHistory)表控制层
 *
 * @author liangjiang
 * @since 2020-12-19 14:26:10
 */
@RestController
@RequestMapping("userHistory")
public class UserHistoryController {
    /**
     * 服务对象
     */
    @Resource
    private UserHistoryService userHistoryService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public UserHistory selectOne(Long id) {
        return this.userHistoryService.queryById(id);
    }

}