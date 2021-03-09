package cn.hmxz.modules.lit.entity;

import java.io.Serializable;

/**
 * 薪资爆料信息表(SalaryInfo)实体类
 *
 * @author liangjiang
 * @since 2020-12-27 15:57:56
 */
public class SalaryInfo extends CommonInfo implements Serializable {
    private static final long serialVersionUID = 883490946266376698L;
    /**
     * 薪资爆料id
     */
    private Long salaryId;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 公司名
     */
    private String company;
    /**
     * 城市名
     */
    private String city;
    /**
     * 薪资
     */
    private String salary;
    /**
     * 学历
     */
    private String education;
    /**
     * 行业
     */
    private String industry;
    /**
     * 备注
     */
    private String remark;
    /**
     * 可信值
     */
    private Long trusted;
    /**
     * 不可信值
     */
    private Long notTrusted;


    public Long getSalaryId() {
        return salaryId;
    }

    public void setSalaryId(Long salaryId) {
        this.salaryId = salaryId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getTrusted() {
        return trusted;
    }

    public void setTrusted(Long trusted) {
        this.trusted = trusted;
    }

    public Long getNotTrusted() {
        return notTrusted;
    }

    public void setNotTrusted(Long notTrusted) {
        this.notTrusted = notTrusted;
    }

}