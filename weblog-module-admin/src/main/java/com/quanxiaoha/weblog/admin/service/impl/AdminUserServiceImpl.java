package com.quanxiaoha.weblog.admin.service.impl;

import com.quanxiaoha.weblog.admin.model.vo.UpdateAdminUserPasswordReqVO;
import com.quanxiaoha.weblog.admin.service.AdminUserService;
import com.quanxiaoha.weblog.common.domain.mapper.UserMapper;
import com.quanxiaoha.weblog.common.enums.ResponseCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.quanxiaoha.weblog.common.utils.Response;
@Service
public class AdminUserServiceImpl implements AdminUserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Response updatePassword(UpdateAdminUserPasswordReqVO updateAdminUserPasswordReqVO) {
        // 拿到用户名、密码
        String username = updateAdminUserPasswordReqVO.getUsername();
        String password = updateAdminUserPasswordReqVO.getPassword();
        // 加密密码
        String encodePassword = passwordEncoder.encode(password);

        // 更新到数据库
        int count = userMapper.updatePasswordByUsername(username, encodePassword);

        return count == 1 ? Response.success() : Response.fail(ResponseCodeEnum.USERNAME_NOT_FOUND);
    }
}
