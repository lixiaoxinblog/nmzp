package com.xiaoxin.nmzp.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 公司对象 nmzp_company
 * 
 * @author xiaoxin
 * @date 2024-10-16
 */
public class NmzpCompany extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id 主键 */
    private Long companyId;

    /** 公司名称 */
    @Excel(name = "公司名称")
    private String name;

    /** 地址 */
    @Excel(name = "地址")
    private String address;

    /** 电话 */
    @Excel(name = "电话")
    private String phone;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String email;

    /** 公司logo */
    @Excel(name = "公司logo")
    private String logo;

    /** 公司老总ID */
    @Excel(name = "公司老总ID")
    private Long boss;

    /** 创建用户 */
    @Excel(name = "创建用户")
    private String createUser;

    /** 删除标识（0默认1删除） */
    private Long isDel;

    /** 状态（0为审核，1已审核） */
    @Excel(name = "状态", readConverterExp = "0=为审核，1已审核")
    private Long status;

    public void setCompanyId(Long companyId) 
    {
        this.companyId = companyId;
    }

    public Long getCompanyId() 
    {
        return companyId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }
    public void setLogo(String logo) 
    {
        this.logo = logo;
    }

    public String getLogo() 
    {
        return logo;
    }
    public void setBoss(Long boss) 
    {
        this.boss = boss;
    }

    public Long getBoss() 
    {
        return boss;
    }
    public void setCreateUser(String createUser) 
    {
        this.createUser = createUser;
    }

    public String getCreateUser() 
    {
        return createUser;
    }
    public void setIsDel(Long isDel) 
    {
        this.isDel = isDel;
    }

    public Long getIsDel() 
    {
        return isDel;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("companyId", getCompanyId())
            .append("name", getName())
            .append("address", getAddress())
            .append("phone", getPhone())
            .append("email", getEmail())
            .append("logo", getLogo())
            .append("boss", getBoss())
            .append("createTime", getCreateTime())
            .append("createUser", getCreateUser())
            .append("updateTime", getUpdateTime())
            .append("isDel", getIsDel())
            .append("status", getStatus())
            .toString();
    }
}
