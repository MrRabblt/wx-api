package cn.hmxz.modules.lit.entity.io.request;

import lombok.Data;

/**
 * @Author: zhengying
 * @Date: 2020/12/19 16:47
 * @FileName: CampusRecruitmentInfoRequest
 * @Description: 校招信息request
 */
@Data
public class QueryRecruitmentInfoRequest {
   private String city;
   private String company;
}
