package com.xiaoxin.nmzp.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.xiaoxin.nmzp.domain.NmzpCompany;
import com.xiaoxin.nmzp.service.INmzpCompanyService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 公司Controller
 *
 * @author xiaoxin
 * @date 2024-10-16
 */
@RestController
@RequestMapping("/nmzp/company")
public class NmzpCompanyController extends BaseController {
    @Autowired
    private INmzpCompanyService nmzpCompanyService;

    /**
     * 查询公司列表
     */
    @PreAuthorize("@ss.hasPermi('nmzp:company:list')")
    @GetMapping("/list")
    public TableDataInfo list(NmzpCompany nmzpCompany) {
        startPage();
        List<NmzpCompany> list = nmzpCompanyService.selectNmzpCompanyList(nmzpCompany);
        return getDataTable(list);
    }

    /**
     * 导出公司列表
     */
    @PreAuthorize("@ss.hasPermi('nmzp:company:export')")
    @Log(title = "公司", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, NmzpCompany nmzpCompany) {
        List<NmzpCompany> list = nmzpCompanyService.selectNmzpCompanyList(nmzpCompany);
        ExcelUtil<NmzpCompany> util = new ExcelUtil<NmzpCompany>(NmzpCompany.class);
        util.exportExcel(response, list, "公司数据");
    }

    /**
     * 获取公司详细信息
     */
    @PreAuthorize("@ss.hasPermi('nmzp:company:query')")
    @GetMapping(value = "/{companyId}")
    public AjaxResult getInfo(@PathVariable("companyId") Long companyId) {
        return success(nmzpCompanyService.selectNmzpCompanyByCompanyId(companyId));
    }

    /**
     * 新增公司
     */
    @PreAuthorize("@ss.hasPermi('nmzp:company:add')")
    @Log(title = "公司", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody NmzpCompany nmzpCompany) {
        return toAjax(nmzpCompanyService.insertNmzpCompany(nmzpCompany));
    }

    /**
     * 修改公司
     */
    @PreAuthorize("@ss.hasPermi('nmzp:company:edit')")
    @Log(title = "公司", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody NmzpCompany nmzpCompany) {
        return toAjax(nmzpCompanyService.updateNmzpCompany(nmzpCompany));
    }

    /**
     * 删除公司
     */
    @PreAuthorize("@ss.hasPermi('nmzp:company:remove')")
    @Log(title = "公司", businessType = BusinessType.DELETE)
    @DeleteMapping("/{companyIds}")
    public AjaxResult remove(@PathVariable Long[] companyIds) {
        return toAjax(nmzpCompanyService.deleteNmzpCompanyByCompanyIds(companyIds));
    }
}
