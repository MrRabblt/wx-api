package cn.hmxz.modules.lit.entity.io.request;

import lombok.Data;

/**
 * @Author: zhengying
 * @Date: 2020/12/19 16:47
 * @FileName: CampusRecruitmentInfoRequest
 * @Description: 查询面试经验request
 */
@Data
public class QueryInterviewExpRequest {
   private String position;
   private String company;
}
