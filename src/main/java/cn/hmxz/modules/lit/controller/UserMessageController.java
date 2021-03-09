package cn.hmxz.modules.lit.controller;

import cn.hmxz.modules.lit.entity.UserMessage;
import cn.hmxz.modules.lit.service.UserMessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 回复消息表(UserMessage)表控制层
 *
 * @author liangjiang
 * @since 2020-12-19 14:26:11
 */
@RestController
@RequestMapping("userMessage")
public class UserMessageController {
    /**
     * 服务对象
     */
    @Resource
    private UserMessageService userMessageService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public UserMessage selectOne(Long id) {
        return this.userMessageService.queryById(id);
    }

}