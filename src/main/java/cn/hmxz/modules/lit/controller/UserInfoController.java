package cn.hmxz.modules.lit.controller;

import cn.hmxz.modules.lit.entity.UserInfo;
import cn.hmxz.modules.lit.service.UserInfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 用户信息表(UserInfo)表控制层
 *
 * @author liangjiang
 * @since 2020-12-19 14:26:11
 */
@RestController
@RequestMapping("userInfo")
public class UserInfoController {
    /**
     * 服务对象
     */
    @Resource
    private UserInfoService userInfoService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public UserInfo selectOne(Long id) {
        return this.userInfoService.queryById(id);
    }

}