package com.quanxiaoha.weblog.admin.service;
import com.quanxiaoha.weblog.common.utils.Response;
import com.quanxiaoha.weblog.admin.model.vo.category.AddCategoryReqVO;

public interface AdminCategoryService {
    /**
     * 添加分类
     * @param addCategoryReqVO
     * @return
     */
    Response addCategory(AddCategoryReqVO addCategoryReqVO);
}
