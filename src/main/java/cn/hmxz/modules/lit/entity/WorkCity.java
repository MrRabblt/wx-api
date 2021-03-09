package cn.hmxz.modules.lit.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 工作城市(WorkCity)实体类
 *
 * @author liangjiang
 * @since 2020-12-19 14:26:12
 */
public class WorkCity implements Serializable {
    private static final long serialVersionUID = -41454499635944960L;
    /**
     * 城市id
     */
    private Long cityId;
    /**
     * 城市名称
     */
    private String cityName;
    /**
     * 校招信息id
     */
    private Long infoId;
    /**
     * 创建时间
     */
    private Date createTime;


    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Long getInfoId() {
        return infoId;
    }

    public void setInfoId(Long infoId) {
        this.infoId = infoId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}