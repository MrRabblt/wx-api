package cn.hmxz.modules.email.controller;

import cn.hmxz.common.utils.R;
import cn.hmxz.modules.email.dao.MailSenderInfo;
import cn.hmxz.modules.email.util.SendMailUtil;
import org.apache.commons.mail.EmailException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liangjiang
 * @date 2021/3/10
 */
@RestController
@RequestMapping("email")
public class MailController {

    @PostMapping("/send")
    public R sendMail(@RequestBody MailSenderInfo mailSenderInfo) {
        try {
            SendMailUtil.sendHtmlEmail(mailSenderInfo);
        } catch (EmailException e) {
            e.printStackTrace();
            return R.error().put(e.getMessage());
        }
        return R.ok();
    }
}
