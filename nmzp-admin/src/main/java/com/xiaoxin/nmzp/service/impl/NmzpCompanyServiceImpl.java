package com.xiaoxin.nmzp.service.impl;

import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import com.xiaoxin.nmzp.domain.NmzpCompany;
import com.xiaoxin.nmzp.mapper.NmzpCompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xiaoxin.nmzp.service.INmzpCompanyService;

/**
 * 公司Service业务层处理
 *
 * @author ruoyi
 * @date 2024-10-16
 */
@Service
public class NmzpCompanyServiceImpl implements INmzpCompanyService {
    @Autowired
    private NmzpCompanyMapper nmzpCompanyMapper;

    /**
     * 查询公司
     *
     * @param companyId 公司主键
     * @return 公司
     */
    @Override
    public NmzpCompany selectNmzpCompanyByCompanyId(Long companyId) {
        return nmzpCompanyMapper.selectNmzpCompanyByCompanyId(companyId);
    }

    /**
     * 查询公司列表
     *
     * @param nmzpCompany 公司
     * @return 公司
     */
    @Override
    public List<NmzpCompany> selectNmzpCompanyList(NmzpCompany nmzpCompany) {
        return nmzpCompanyMapper.selectNmzpCompanyList(nmzpCompany);
    }

    /**
     * 新增公司
     *
     * @param nmzpCompany 公司
     * @return 结果
     */
    @Override
    public int insertNmzpCompany(NmzpCompany nmzpCompany) {
        nmzpCompany.setCreateTime(DateUtils.getNowDate());
        return nmzpCompanyMapper.insertNmzpCompany(nmzpCompany);
    }

    /**
     * 修改公司
     *
     * @param nmzpCompany 公司
     * @return 结果
     */
    @Override
    public int updateNmzpCompany(NmzpCompany nmzpCompany) {
        nmzpCompany.setUpdateTime(DateUtils.getNowDate());
        return nmzpCompanyMapper.updateNmzpCompany(nmzpCompany);
    }

    /**
     * 批量删除公司
     *
     * @param companyIds 需要删除的公司主键
     * @return 结果
     */
    @Override
    public int deleteNmzpCompanyByCompanyIds(Long[] companyIds) {
        return nmzpCompanyMapper.deleteNmzpCompanyByCompanyIds(companyIds);
    }

    /**
     * 删除公司信息
     *
     * @param companyId 公司主键
     * @return 结果
     */
    @Override
    public int deleteNmzpCompanyByCompanyId(Long companyId) {
        return nmzpCompanyMapper.deleteNmzpCompanyByCompanyId(companyId);
    }
}
