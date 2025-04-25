package com.quanxiaoha.weblog.admin.service;
import com.quanxiaoha.weblog.admin.model.vo.user.UpdateAdminUserPasswordReqVO;
import com.quanxiaoha.weblog.common.utils.Response;

public interface AdminUserService {
    Response updatePassword(UpdateAdminUserPasswordReqVO updateAdminUserPasswordReqVO);

    /**
     * 获取当前用户信息
     * @return
     */
    Response findUserInfo();
}
