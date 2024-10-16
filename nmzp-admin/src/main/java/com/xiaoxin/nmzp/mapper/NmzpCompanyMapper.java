package com.xiaoxin.nmzp.mapper;

import java.util.List;

import com.xiaoxin.nmzp.domain.NmzpCompany;

/**
 * 公司Mapper接口
 * 
 * @author ruoyi
 * @date 2024-10-16
 */
public interface NmzpCompanyMapper 
{
    /**
     * 查询公司
     * 
     * @param companyId 公司主键
     * @return 公司
     */
    public NmzpCompany selectNmzpCompanyByCompanyId(Long companyId);

    /**
     * 查询公司列表
     * 
     * @param nmzpCompany 公司
     * @return 公司集合
     */
    public List<NmzpCompany> selectNmzpCompanyList(NmzpCompany nmzpCompany);

    /**
     * 新增公司
     * 
     * @param nmzpCompany 公司
     * @return 结果
     */
    public int insertNmzpCompany(NmzpCompany nmzpCompany);

    /**
     * 修改公司
     * 
     * @param nmzpCompany 公司
     * @return 结果
     */
    public int updateNmzpCompany(NmzpCompany nmzpCompany);

    /**
     * 删除公司
     * 
     * @param companyId 公司主键
     * @return 结果
     */
    public int deleteNmzpCompanyByCompanyId(Long companyId);

    /**
     * 批量删除公司
     * 
     * @param companyIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteNmzpCompanyByCompanyIds(Long[] companyIds);
}
