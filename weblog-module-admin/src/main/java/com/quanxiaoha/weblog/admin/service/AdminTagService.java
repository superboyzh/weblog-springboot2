package com.quanxiaoha.weblog.admin.service;

import com.quanxiaoha.weblog.admin.model.vo.category.AddCategoryReqVO;
import com.quanxiaoha.weblog.admin.model.vo.category.DeleteCategoryReqVO;
import com.quanxiaoha.weblog.admin.model.vo.category.FindCategoryPageListReqVO;
import com.quanxiaoha.weblog.admin.model.vo.tag.AddTagReqVO;
import com.quanxiaoha.weblog.admin.model.vo.tag.DeleteTagReqVO;
import com.quanxiaoha.weblog.admin.model.vo.tag.FindTagPageListReqVO;
import com.quanxiaoha.weblog.admin.model.vo.tag.SearchTagReqVO;
import com.quanxiaoha.weblog.common.utils.PageResponse;
import com.quanxiaoha.weblog.common.utils.Response;

public interface AdminTagService {
    /**
     * 添加标签集合
     * @params addTagReqVO
     * @return
     */
    Response addTags(AddTagReqVO addTagReqVO);


    /**
     * 查询标签分页
     * @params addTagReqVO
     * @return
     */
    Response findTagPageList(FindTagPageListReqVO findTagPageListReqVO);

    /**
     * 删除标签
     */
    Response deleteTags(DeleteTagReqVO deleteTagReqVO);



    /**
     * 标签模糊查询
     */
    Response searchTags(SearchTagReqVO searchTagReqVO);

    /**
     * 下拉列表
     */
    Response findTagSelectList ();
}
